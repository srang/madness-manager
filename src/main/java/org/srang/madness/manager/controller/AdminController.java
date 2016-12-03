package org.srang.madness.manager.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@RequestMapping("/admin")
@Log
public class AdminController {
    @RequestMapping("")
    public String index(Model model) {
        return "admin/index";
    }

    @RequestMapping("/test")
    public String other(Model model) {
        return "admin/other";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String enter(@PathVariable(required = false, value = "name")String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping("/hello")
    public String noName() {
        return "redirect:/hello/world";
    }

}
