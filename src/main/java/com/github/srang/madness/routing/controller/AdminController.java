package com.github.srang.madness.routing.controller;

import com.github.srang.madness.model.dto.BracketInfo;
import com.github.srang.madness.model.entities.Bracket;
import com.github.srang.madness.model.ephemeral.Alert;
import com.github.srang.madness.model.forms.BracketForm;
import com.github.srang.madness.model.forms.CreateMasterBracketForm;
import com.github.srang.madness.service.BracketService;
import com.github.srang.madness.service.TeamService;
import com.github.srang.madness.service.TournamentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@RequestMapping("/app/admin")
@Secured("ROLE_ADMIN")
@Log
public class AdminController {

    @Autowired
    TournamentService tournamentService;
    @Autowired
    BracketService bracketService;
    @Autowired
    TeamService teamService;

    @RequestMapping("")
    public String index(Model model) {
        return "admin/index";
    }

    @RequestMapping(value = "/brackets/master", method = GET)
    public String showMaster(Model model) {
        Bracket master = bracketService.getMaster();
        if (master == null) {
            return "redirect:/app/admin/brackets/master/create";
        }
        model.addAttribute("bracketForm", new BracketForm(bracketService, master));
        model.addAttribute("backLink", "/app/admin/brackets");
        model.addAttribute("formLink", "/app/admin/brackets/master");
        model.addAttribute("bracketLink", "/app/admin/brackets/master");

        model.addAttribute("mode", "master");
        model.addAttribute("container", "game_button");
        model.addAttribute("teams", teamService.getTeams());
        return "bracket/display";
    }


    @RequestMapping(value = "/brackets/master", method = POST)
    public String updateMaster(BracketForm masterBracketForm, Model model, RedirectAttributes attributes) {
        bracketService.saveMaster(masterBracketForm);
        attributes.addFlashAttribute("alerts", new Alert[]{new Alert("Master Bracket Saved", "success")});
        return "redirect:/app/admin/brackets/master";
    }

    private void setCreateMasterModel(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        model.addAttribute("regions", bracketService.regions());
        model.addAttribute("matchups", bracketService.generateMatchups());
    }

    @RequestMapping(value = "/brackets/master/create", method = GET)
    public String createMaster(Model model) {
        // TODO check if master exists
        setCreateMasterModel(model);
        model.addAttribute("bracketForm", new CreateMasterBracketForm(bracketService.regions(), teamService));
        return "bracket/create_master";
    }

    @RequestMapping(value = "/brackets/master/create", method = POST)
    public ModelAndView createMaster(@Valid CreateMasterBracketForm bracketForm, BindingResult result, Model model, RedirectAttributes attributes) {
        // TODO check if master exists
        if (result.hasErrors()) {
            setCreateMasterModel(model);
            model.addAttribute("bracketForm", bracketForm);
            model.addAttribute("result", result);
            log.warning(result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(toList()).toString());
            return new ModelAndView("bracket/create_master", model.asMap());
        }
        teamService.saveTeamsRanks(bracketForm);
        String redirect = "redirect:/app/admin/brackets/master/create";
        if (bracketForm.getMadnessFlag()) {
            Bracket master = bracketService.createMaster(bracketForm);
            tournamentService.next();
            attributes.addFlashAttribute("alerts", new Alert[]{new Alert("Master Bracket Created", "success")});
            redirect = "redirect:/app/admin/brackets";
        } else {
            attributes.addFlashAttribute("alerts", new Alert[]{new Alert("Master Bracket Saved", "success")});
            log.warning("alert added");
        }
        return new ModelAndView(redirect, attributes.asMap());
    }

    @RequestMapping(value = "/brackets", method = GET)
    public String listBrackets(Model model) {
        List<BracketInfo> brackets = bracketService.getAllBracketInfo();
        model.addAttribute("brackets", brackets);
        model.addAttribute("backLink", "/app/admin");
        return "admin/brackets";
    }

}
