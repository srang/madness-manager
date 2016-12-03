package org.srang.madness.manager.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@RequestMapping("/user")
@Log
public class UserController {
    @RequestMapping("")
    public String index(Model model) {
        return "user/index";
    }

}
