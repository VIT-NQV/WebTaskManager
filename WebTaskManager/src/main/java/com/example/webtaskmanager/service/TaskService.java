package com.example.webtaskmanager.service;

import com.example.webtaskmanager.model.Task;
import com.example.webtaskmanager.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public interface TaskService {

    //jpa

    Page<Task> findAll(int page, String searchTitle, String searchStatus);

    Task findById(int taskId);

    Task addTask(Task task);

    Task updateTask(int taskid, Task task);

    void deleteTask(int taskid);


    //Mybatis

    List<Task> findTaskMybatis(String searchTitle, String searchStatus, int start);

    int countTaskMybatis(String title, String status);

    List<Task> findCsv(String title, String status);

    Task findByTitle(String title);


    Integer addTaskMybatis(Task task);

    void editTaskMybatis(Task task);

    void deleteTaskMybatis(int taskid);

    void exportCsv(HttpServletResponse response, String searchTitle, String searchStatus) throws IOException;

}
