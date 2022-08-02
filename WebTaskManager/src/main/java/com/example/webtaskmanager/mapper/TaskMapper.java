package com.example.webtaskmanager.mapper;

import com.example.webtaskmanager.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
@Mapper
public interface TaskMapper {

//    Page<Task> findAll(Pageable page, @Param("title") String title, @Param("status") String status);

    List<Task> findAllItem( @Param("title") String title, @Param("status") String status , @Param("start") int start);

    List<Task> countAllMybatis(@Param("title") String title,  @Param("status") String status);

    void deleteTask(@Param("taskid") int taskid);

    void addTask(@Param("task") Task task);

    void editTask(@Param("task") Task task);

//    Long insertTask(@Param("task") ListTaskEntity task);

}
