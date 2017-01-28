package org.srang.madness.manager.routing.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.srang.madness.manager.model.forms.RegisterForm;
import org.srang.madness.manager.service.UserService;

import javax.validation.Valid;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@Log
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping("/verify/{token}")
    public String verifyUser(
            @PathVariable(name = "token") String token,
            Model model) {
        return "hello";
    }

    @RequestMapping("/verify")
    public String showUnverified() {
        return "hello";
    }

    @RequestMapping("/reverify")
    public String reverify() {
        return "hello";
    }

    @RequestMapping("/disabled")
    public String disabled() {
        return "hello";
    }

    @RequestMapping("/password/reset")
    public String reset() {
        return "auth/login";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String getRegister(RegisterForm registerForm) {
        return "auth/register";
    }

    @PostMapping("/register")
    public String submitRegister(@Valid RegisterForm registerForm, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/register";
        }
        userService.registerUser(registerForm);
        return "redirect:/app/home";
    }

}
