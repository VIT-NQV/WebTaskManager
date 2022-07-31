package com.example.webtaskmanager.service;

import com.example.webtaskmanager.model.Task;
import com.example.webtaskmanager.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

    Page<Task> findAll(int page, String searchTitle, String searchStatus);

    Task findById(int taskId);

    Task addTask(Task task);

    Task updateTask(int taskid, Task task);

    void deleteTask(int taskid);

}
