package com.github.srang.madness.manager.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by srang on 12/10/16.
 */

@Path("/")
public class RootController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        return "home";
    }
}
