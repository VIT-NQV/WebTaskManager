package com.example.webtaskmanager.service;

import com.example.webtaskmanager.model.Task;
import com.example.webtaskmanager.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Page<Task> findAll(int page, String searchTitle, String searchStatus);

//    List<Task> findAllItem(String searchTitle, String searchStatus);

    List<Task> findAllItem(String searchTitle, String searchStatus, int start);

    Task findById(int taskId);

    Task addTask(Task task);

    Task updateTask(int taskid, Task task);

    void deleteTask(int taskid);

    int countAllMybatis(String title, String status);

    void addTaskMybatis(Task task);

    void editTaskMybatis(Task task);

    void deleteTaskMybatis(int taskid);
//    Long createTask(ListTaskEntity listTask);

}
