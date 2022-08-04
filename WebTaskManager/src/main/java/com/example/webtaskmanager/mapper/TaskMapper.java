package com.example.webtaskmanager.mapper;

import com.example.webtaskmanager.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
@Mapper
public interface TaskMapper {

    List<Task> findTaskMybatis(@Param("title") String title, @Param("status") String status , @Param("start") int start);

    List<Task> countTaskMybatis(@Param("title") String title,  @Param("status") String status);

    List<Task> findCsv(@Param("title") String title, @Param("status") String status);

    Task findByTitle(@Param("title") String title);

    Integer addTask(@Param("task") Task task);

    void editTask(@Param("task") Task task);

    void deleteTask(@Param("taskid") int taskid);

//    Long insertTask(@Param("task") ListTaskEntity task);

}
