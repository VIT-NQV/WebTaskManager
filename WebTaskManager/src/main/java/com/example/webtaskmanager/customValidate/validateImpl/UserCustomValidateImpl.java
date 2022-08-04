package com.example.webtaskmanager.customValidate.validateImpl;

import com.example.webtaskmanager.customValidate.UserCustomValidate;
import com.example.webtaskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserCustomValidateImpl implements ConstraintValidator<UserCustomValidate,String> {

    @Autowired
    private UserService userService;

    public boolean isValid(String username, ConstraintValidatorContext cvc) {

        if (userService.findByUsername(username) == null) {
            return true;
        }

        return false;
    }

}