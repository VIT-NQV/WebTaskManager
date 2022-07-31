package com.example.webtaskmanager.controller;

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

    @GetMapping("/tasklist/index")
    public String showTasklist(Model model){
        return pagination(model, 1, "", "");
    }

    @GetMapping("/tasklist/page/{page}")
    public String pagination(Model model,
                             @PathVariable("page") int page,
                             @Param(value = "searchTitle") String searchTitle,
                             @Param(value = "searchStatus") String searchStatus) {

        Page<Task> pagelist = taskService.findAll(page, searchTitle, searchStatus);

        int totalPages = pagelist.getTotalPages();
        List<Task> tasklist = pagelist.getContent();

        model.addAttribute("show", tasklist);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchStatus", searchStatus);

        return "tasklist";
    }

    @GetMapping("/tasklist/search")
    public String search(Model model,
                         @Param(value = "searchTitle") String searchTitle,
                         @Param(value = "searchStatus") String searchStatus) {

        return pagination(model, 1, searchTitle, searchStatus);

    }

    @GetMapping("/tasklist/newtask")
    public String showNewtask(Model model) {
        model.addAttribute("newtask", new Task());
        return "newtask";
    }

    @PostMapping("/tasklist/newtask/addnew")
    public String addTask(@ModelAttribute("newtask") Task task) {
        taskImpl.addTask(task);
        return "redirect:/tasklist/index";
    }

    @GetMapping("/tasklist/updatetask/{taskid}")
    public String showUpdatetask(Model model, @PathVariable("taskid") int taskid) {
        Task task = taskService.findById(taskid);
        if(task == null){
            task = new Task();
        }

        model.addAttribute("updatetask",task);
        return "updatetask";
    }

    @PostMapping("/tasklist/updatetask/update")
    public String updateTask (@ModelAttribute("updatetask") Task task) {
        taskImpl.addTask(task);
        return "redirect:/tasklist/index";
    }

    @GetMapping("/tasklist/deletetask/delete/{taskid}")
    public String deleteTask(Model model, @PathVariable("taskid") int taskid) {
        taskImpl.deleteTask(taskid);
        return "redirect:/tasklist/index";
    }

}
