package com.example.webtaskmanager.controller;

import com.example.webtaskmanager.mapper.TaskMapper;
import com.example.webtaskmanager.model.Task;
import com.example.webtaskmanager.service.TaskService;
import com.example.webtaskmanager.service.impl.TaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskImpl taskImpl;

    @GetMapping("/webtask/tasklist/index")
    public String showTasklist(Model model){
        return pagination(model, 1, "", "");
    }

    @GetMapping("/webtask/tasklist/page/{page}")
    public String pagination(Model model,
                             @PathVariable("page") int page,
                             @Param(value = "searchTitle") String searchTitle,
                             @Param(value = "searchStatus") String searchStatus) {

//        Page<Task> pagelist = taskService.findAll(page, searchTitle, searchStatus);


        int AllItem = taskService.countAllMybatis(searchTitle, searchStatus);


        int itemPerPage = 5;
        int itemIndex =  (itemPerPage * (page - 1) );
        double value = AllItem / itemPerPage;
        double theRest = AllItem % itemPerPage;
        double totalPagesMybitis =  Math.ceil(value);

        if(theRest > 0){
            totalPagesMybitis =  totalPagesMybitis + 1;
        }

        if(page == 1 ) {
            itemIndex = 0;
        }

        List<Task> tasklist = taskService.findAllItem(searchTitle, searchStatus, itemIndex);

//        System.out.println(taskService.countAllTitle("searchTitle"));

//        int totalPages = pagelist.getTotalPages();
//        List<Task> tasklist = pagelist.getContent();

        model.addAttribute("show", tasklist);
        model.addAttribute("totalPages", totalPagesMybitis);
        model.addAttribute("currentPage", page);
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchStatus", searchStatus);

        return "tasklist";
    }

    @GetMapping("/webtask/tasklist/search")
    public String search(Model model,
                         @Param(value = "searchTitle") String searchTitle,
                         @Param(value = "searchStatus") String searchStatus) {

        return pagination(model, 1, searchTitle, searchStatus);

    }

    @GetMapping("/webtask/tasklist/newtask")
    public String showNewtask(Model model) {
        model.addAttribute("newtask", new Task());
        return "newtask";
    }

    @PostMapping("/webtask/tasklist/newtask/addnew")
    public String addTask(@ModelAttribute("newtask") Task task) {
//        taskImpl.addTask(task);
        taskImpl.addTaskMybatis(task);
        return "redirect:/webtask/tasklist/index";
    }

    @GetMapping("/webtask/tasklist/updatetask/{taskid}")
    public String showUpdatetask(Model model, @PathVariable("taskid") int taskid) {
        Task task = taskService.findById(taskid);
        if(task == null){
            task = new Task();
        }
        model.addAttribute("updatetask",task);
        return "updatetask";
    }

    @PostMapping("/webtask/tasklist/updatetask/update")
    public String updateTask (@ModelAttribute("updatetask") Task task) {
//        taskImpl.addTask(task);
        taskImpl.editTaskMybatis(task);
        return "redirect:/webtask/tasklist/index";
    }

    @GetMapping("/webtask/tasklist/deletetask/delete/{taskid}")
    public String deleteTask(Model model, @PathVariable("taskid") int taskid) {
//        taskImpl.deleteTask(taskid);
        taskImpl.deleteTaskMybatis(taskid);
        return "redirect:/webtask/tasklist/index";
    }

}
