package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.model.Bracket;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/brackets")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BracketResource {
    @GET
    public List<Bracket> list() {
        return Bracket.listAll();
    }

    @GET
    @Path("/name/{name}")
    public Bracket byName(@PathParam("name") String name) {
        Bracket bracket = Bracket.findByName(name);
        if (bracket == null) {
            throw new WebApplicationException("Bracket with name " + name + "does not exist");
        }
        return bracket;
    }
}
