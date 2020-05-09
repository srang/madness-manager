package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.model.Team;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/api/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {
    private Set<Team> teams =
        Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    @GET
    public Set<Team> list() {
        return teams;
    }

    @POST
    public Set<Team> add(@Valid Team team) {
        teams.add(team);
        return teams;
    }

}
