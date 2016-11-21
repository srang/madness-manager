package org.srang.madness.manager.controller;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@Slf4j
@RequestMapping("/auth")
public class AuthController {
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
}
