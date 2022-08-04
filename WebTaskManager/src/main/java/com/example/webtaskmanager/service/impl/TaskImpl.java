package com.example.webtaskmanager.service.impl;

import com.example.webtaskmanager.mapper.TaskMapper;
import com.example.webtaskmanager.model.Task;
import com.example.webtaskmanager.repository.TaskRepository;
import com.example.webtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Page<Task> findAll(int page, String searchTitle, String searchStatus) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        return taskRepository.findAll(pageable, searchTitle, searchStatus);
    }

    @Override
    public Task findById(int taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent()) {
            return task.get();
        }
        return null;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(int taskid, Task task) {
        Task fromDB = taskRepository.findById(taskid).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setTitle(fromDB.getTitle());
        fromDB.setStatus(fromDB.getStatus());
        fromDB.setDescribe(fromDB.getDescribe());
        return taskRepository.save(fromDB);
    }

    @Override
    public void deleteTask(int taskid) {
        taskRepository.deleteById(taskid);
    }

//    @Override
//    public List<Task> findAll(int page, String title, String status) {
//        Pageable pageable = PageRequest.of(page - 1, 5);
//        return taskMapper.findAll(pageable, title, status);
//    }

    @Override
    public List<Task> findAllMybatis(String searchTitle, String searchStatus, int start) {
        List<Task> items = taskMapper.findAllMybatis(searchTitle, searchStatus, start);

        if (items.size() > 0) {
            return items;
        }

        return null;
    }

    @Override
    public int countAllMybatis(String title, String status) {
        int count = taskMapper.countAllMybatis(title, status).size();
        return count;
    }

    @Override
    public Integer addTaskMybatis(Task task) {
        return taskMapper.addTask(task);
    }

    @Override
    public void editTaskMybatis(Task task) {
        taskMapper.editTask(task);
    }

    @Override
    public void deleteTaskMybatis(int taskid) {
        taskMapper.deleteTask(taskid);
    }

    @Override
    public List<Task> findAllCsv(String searchTitle, String searchStatus) {
        List<Task> items = taskMapper.findAllCsv(searchTitle, searchStatus);

        if (items.size() > 0) {
            return items;
        }

        return null;
    }

    @Override
    public void exportCsv(HttpServletResponse response,
                          String searchTitle,
                          String searchStatus) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Task> tasklist = taskMapper.findAllCsv(searchTitle, searchStatus);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Task ID", "Describe", "Status", "Title"};
        String[] nameMapping = {"taskid", "describe", "status", "title"};

        csvWriter.writeHeader(csvHeader);

        for (Task task : tasklist) {
            csvWriter.write(task, nameMapping);
        }

        csvWriter.close();
    }
}
