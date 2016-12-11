package org.srang.madness.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by srang on 12/10/16.
 */
@Controller
public class RootController {

    @RequestMapping("/app/home")
    public String home() {
        return "home";
    }

    @RequestMapping({"", "/"})
    public String takeHome() {
        return "redirect:/app/home";
    }
}
