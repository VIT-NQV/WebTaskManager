package com.example.webtaskmanager.repository;

import com.example.webtaskmanager.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {


}
