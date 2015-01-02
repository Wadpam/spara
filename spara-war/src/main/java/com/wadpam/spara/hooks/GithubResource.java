package com.wadpam.spara.hooks;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.wadpam.spara.api.SparaResource;
import com.wadpam.spara.hooks.github.GithubEvent;
import com.wadpam.spara.hooks.github.PushHook;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sosandstrom on 2014-12-29.
 */
@Path("hooks/github")
@Produces(MediaType.APPLICATION_JSON)
public class GithubResource {

    static final Logger LOGGER = LoggerFactory.getLogger(GithubResource.class);
    public static final String X_GIT_HUB_EVENT = "X-GitHub-Event";

    private final Map<GithubEvent, EventHook> HOOKS = new HashMap<>();

    @Inject
    public GithubResource(SparaResource sparaResource) {
        HOOKS.put(GithubEvent.push, new PushHook(sparaResource));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response webhook(@Context HttpServletRequest request, Map<String, Object> body) {
        final String xGithubEvent = request.getHeader(X_GIT_HUB_EVENT);
        LOGGER.info("{}: {}", X_GIT_HUB_EVENT, xGithubEvent);
        GithubEvent event = GithubEvent.valueOf(xGithubEvent);

        EventHook eventHook = HOOKS.get(event);

        if (null != eventHook) {
            eventHook.process(body);
        }
        else {
            LOGGER.warn("No such EventHook for {}", xGithubEvent);
        }

        return Response.ok().build();
    }
}
