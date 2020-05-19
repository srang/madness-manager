package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.model.Game;
import com.github.srang.madness.manager.model.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/games")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {

    @GET
    public List<Game> list() {
        return Game.findRootGames();
    }

    @GET
    @Path("/id/{id}")
    public Game getGameId(@PathParam("id") Long id) {
        Game game = Game.findById(id);
        if (game == null) {
            throw new WebApplicationException("Team with id " + id + " does not exist", 404);
        }
        return game;
    }
}
