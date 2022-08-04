package com.example.webtaskmanager.customValidate.validateImpl;

import com.example.webtaskmanager.customValidate.TaskCustomValidate;
import com.example.webtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaskCustomValidateImpl implements ConstraintValidator<TaskCustomValidate,String> {

    @Autowired
    private TaskService taskService;

    public boolean isValid(String title, ConstraintValidatorContext cvc) {

        if (taskService.findByTitle(title) == null) {
            return true;
        }

        return false;
    }

}