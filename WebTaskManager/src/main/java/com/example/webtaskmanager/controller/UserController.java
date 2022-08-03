package com.example.webtaskmanager.controller;

import com.example.webtaskmanager.model.User;
import com.example.webtaskmanager.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserImpl userimpl;

    @GetMapping("/webtask/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/webtask/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/webtask/register/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String enCode = passwordEncoder.encode(user.getPassword());
        user.setPassword(enCode);
//        userimpl.saveUser(user);
        userimpl.addUserMybatis(user);
        return "redirect:/webtask/login";
    }












}
