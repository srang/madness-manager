package org.srang.bracketpicker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
public class AdminController {
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
