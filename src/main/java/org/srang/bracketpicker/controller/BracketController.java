package org.srang.bracketpicker.controller;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@RequestMapping("/brackets")
@Slf4j
public class BracketController {
    @RequestMapping("/")
    public String listBrackets(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/bracket", method = GET)
    public String showCreateBracket() {
        return "hello";
    }

    @RequestMapping(value = "/bracket", method = POST)
    public String submitBracket() {
        return "redirect:/brackets/";
    }

    @RequestMapping(value = "/bracket/{bracketid}", method = GET)
    public String viewBracket() {
        return "hello";
    }

    @RequestMapping(value = "/bracket/{bracketid}", method = PUT)
    public String updateBracket() {
        return "redirect:/brackets/bracket/${bracketid}";
    }

    @RequestMapping(value = "/bracket/{bracketid}", method = DELETE)
    public String deleteBracket() {
        return "redirect:/brackets/";
    }

    @RequestMapping(value = "/bracket/{bracketid}/print", method = GET)
    public String showPrintBracket() {
        return "hello";
    }
}
