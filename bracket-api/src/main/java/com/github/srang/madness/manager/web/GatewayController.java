package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.util.MatchupService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class GatewayController {
    @Inject
    MatchupService matchupService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/matchups")
    public List<Integer> matchups(@QueryParam("seeds") Integer seeds) {
        return matchupService.seedMatchups(seeds);
    }
}
