package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.model.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Path("/api/teams")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @GET
    public List<Team> list() {
        return Team.listAll();
    }

    @GET
    @Path("/id/{id}")
    public Team getTeamId(@PathParam("id") Long id) {
        Team team = Team.findById(id);
        if (team == null) {
            throw new WebApplicationException("Team with id " + id + " does not exist", 404);
        }
        return team;
    }

    @GET
    @Path("/name/{name}")
    public Team getTeamName(@PathParam("name") String name) {
        Team team = Team.findByName(name);
        if (team == null) {
            throw new WebApplicationException("Team with name " + name + " does not exist", 404);
        }
        return team;
    }

    @POST
    @Transactional
    public Response add(@Valid Team team) {
        if (team.id != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        team.persist();
        return Response.ok(team).status(201).build();
    }

}
