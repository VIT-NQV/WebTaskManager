package com.example.webtaskmanager.mapper;

import com.example.webtaskmanager.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
@Mapper
public interface TaskMapper {

    List<Task> findAllMybatis(@Param("title") String title, @Param("status") String status , @Param("start") int start);

    List<Task> countAllMybatis(@Param("title") String title,  @Param("status") String status);

    List<Task> findAllCsv(@Param("title") String title, @Param("status") String status);

    Task addTask(@Param("task") Task task);

    void editTask(@Param("task") Task task);

    void deleteTask(@Param("taskid") int taskid);

//    Long insertTask(@Param("task") ListTaskEntity task);

}
