package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.model.Team;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/api/teams")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {
    Logger log = Logger.getLogger(TeamResource.class);
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

    @PUT
    @Path("/id/{id}")
    @Transactional
    public Team updateTeam(@PathParam("id") Long id, @Valid Team team) {
        Team entity = Team.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Team with id " + id + " does not exist", 404);
        }
        try {
            entity = Team.mirrorFields(entity, team);
            entity.persistAndFlush();
        }  catch (Exception e) {
            log.warn(e.getMessage());
            throw new WebApplicationException("Team with name " + team.name + " already exists", 400);
        }
        return entity;
    }

    @DELETE
    @Path("/id/{id}")
    @Transactional
    public Response deleteTeam(@PathParam("id") Long id) {
        Team team = Team.findById(id);
        if (team == null) {
            throw new WebApplicationException("Team with id " + id + " does not exist", 404);
        }
        team.delete();
        return Response.status(204).build();
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
        try {
            team.persistAndFlush();
        } catch (PersistenceException e) {
            throw new WebApplicationException("Team with name " + team.name + " already exists", 400);
        }
        return Response.ok(team).status(201).build();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Override
        public Response toResponse(Exception exception) {
            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response.status(code)
                .entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
                .build();
        }

    }
}
