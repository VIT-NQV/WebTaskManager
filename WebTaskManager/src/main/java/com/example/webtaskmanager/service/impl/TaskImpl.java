package com.example.webtaskmanager.service.impl;

import com.example.webtaskmanager.model.Task;
import com.example.webtaskmanager.repository.TaskRepository;
import com.example.webtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Page<Task> findAll(int page, String searchTitle, String searchStatus) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        return taskRepository.findAll(pageable, searchTitle, searchStatus);
    }

    @Override
    public Task findById(int taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()){
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

}
