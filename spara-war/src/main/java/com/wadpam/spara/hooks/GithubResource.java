package com.wadpam.spara.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by sosandstrom on 2014-12-29.
 */
@Path("hooks/github")
@Produces(MediaType.APPLICATION_JSON)
public class GithubResource {

    static final Logger LOGGER = LoggerFactory.getLogger(GithubResource.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response webhook(@Context HttpServletRequest request, Map<String, Object> body) {
        for (Enumeration<String> names = request.getHeaderNames(); names.hasMoreElements(); ) {
            String name = names.nextElement();
            LOGGER.debug("{}: {}", name, request.getHeader(name));
        }
        LOGGER.info("body={}", body);

        return Response.ok().build();
    }
}
