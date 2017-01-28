package org.srang.madness.manager.routing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            return "redirect:/app/home";
        }
        return "redirect:/welcome";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
