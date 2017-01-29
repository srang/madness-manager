package com.github.srang.madness.routing.controller;

import com.github.srang.madness.model.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@RequestMapping("/users")
@Log
public class UserController {

    @Autowired
    UserRepository users;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("users", users.findAll());
        List<String> errors = Arrays.asList(new String[] {});
        model.addAttribute("errors", errors);
        return "user/index";
    }
}
