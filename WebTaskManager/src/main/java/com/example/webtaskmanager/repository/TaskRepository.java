package com.example.webtaskmanager.repository;

import com.example.webtaskmanager.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {

    @Query(value = "SELECT t FROM Task as t WHERE t.title LIKE %:searchTitle% AND t.status LIKE %:searchStatus%")
    Page<Task> findAll(Pageable page, @Param("searchTitle") String searchTitle, @Param("searchStatus") String searchStatus);

}
