package org.srang.madness.manager.controller;

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
import org.srang.madness.manager.model.entities.Bracket;
import org.srang.madness.manager.model.ephemeral.Alert;
import org.srang.madness.manager.model.forms.CreateMasterBracketForm;
import org.srang.madness.manager.service.BracketService;
import org.srang.madness.manager.service.TeamService;

import javax.validation.Valid;

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
        /*
        $games = BracketFactory::reverseBracket($bracket,new ReverseBaseBracketStrategy());
        $regions = Region::orderedRegions();
        $rounds = count($games);
        return view('brackets.bracket_display',[
            'teamRepo' => $this->teamRepo,
            'bracket' => $bracket,
            'master' => true,
            'games' => $games,
            'regions' => $regions,
            'game_container' => 'brackets.game_buttons',
            'bracket_link' => url('admin/brackets/master'),
            'back_link' => url('admin/brackets')
        ]);
         */
        return "home";
    }

    private void setCreateMasterModel(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        model.addAttribute("regions", bracketService.regions());
        model.addAttribute("matchups", bracketService.generateMatchups());
    }

    @RequestMapping(value = "/brackets/master/create", method = GET)
    public String createMaster(Model model) {
        setCreateMasterModel(model);
        model.addAttribute("bracketForm", new CreateMasterBracketForm(bracketService.regions(), teamService));

        return "bracket/create_master";
    }

    @RequestMapping(value = "/brackets/master/create", method = POST)
    public ModelAndView createMaster(@Valid CreateMasterBracketForm bracketForm, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            setCreateMasterModel(model);
            model.addAttribute("bracketForm", bracketForm);
            model.addAttribute("result", result);
            log.warning(result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(toList()).toString());
            return new ModelAndView("bracket/create_master", model.asMap());
        }
        bracketForm.getRankedTeams().forEach((regionId, teams) -> {
            teams.forEach((rank, teamId) -> {
                if (teamId != null) {
                    teamService.setTeamRegionRank(teamId, regionId, rank);
                }
            });
        });
        String redirect = "redirect:/app/admin/brackets/master/create";
        if (bracketForm.getMadnessFlag()) {
            // change application state
            // redirect = "redirect:/brackets/master";
        } else {
            attributes.addFlashAttribute("alerts", new Alert[] {new Alert("Master Bracket Saved", "success")});
            log.warning("alert added");
        }
        return new ModelAndView(redirect, attributes.asMap());
    }

    @RequestMapping(value = "/brackets/master", method = POST)
    public String updateMaster(Model model) {
        return "redirect:/app/admin/brackets/master";
    }
}
