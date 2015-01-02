package com.wadpam.spara.api;

import com.google.appengine.api.utils.SystemProperty;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.wadpam.spara.dao.DProjectDaoBean;
import com.wadpam.spara.dao.DTicketDaoBean;
import com.wadpam.spara.domain.DProject;
import com.wadpam.spara.domain.DTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sosandstrom on 2014-12-30.
 */
@Path("api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SparaResource {

    static final Logger LOGGER = LoggerFactory.getLogger(SparaResource.class);

    private final DProjectDaoBean projectDao;
    private final DTicketDaoBean ticketDao;

    @Inject
    public SparaResource(DProjectDaoBean projectDao, DTicketDaoBean ticketDao) throws IOException {
        this.projectDao = projectDao;
        this.ticketDao = ticketDao;
    }

    public void populateExample() throws java.io.IOException {
        if (SystemProperty.Environment.Value.Development.equals(SystemProperty.environment.value()) ||
                null == projectDao.get("SPARA")) {
            projectDao.put(DProjectDaoBean.newBuilder()
                .id("SPARA")
                .displayName("Spara, the Issue Manager")
                .build());
            final Object projectKey = projectDao.getKey("SPARA");

            ticketDao.put(DTicketDaoBean.newBuilder()
                    .projectKey(projectKey)
                    .id(1L)
                    .title("Bootstrap the Spara project")
                    .build());

            LOGGER.info("populated example");
        }
    }

    static final Pattern TICKET_PATTERN = Pattern.compile("([A-Z]+-[\\d]+)[\\s,:]+");
    public static TreeSet<String> findTicketIds(String message) {
        final TreeSet<String> tickets = new TreeSet<>();
        Matcher matcher = TICKET_PATTERN.matcher(message);
        while (matcher.find()) {
            tickets.add(matcher.group(1));
        }
        return tickets;
    }

    @GET
    public Map<String, Object> getApiEndpoints(@Context HttpServletRequest request) {
        final String fullUrl = request.getRequestURL().toString();
        final String baseUrl = fullUrl.substring(0, fullUrl.indexOf("/api"));
        return ImmutableMap.<String, Object>of(
                "Projects", baseUrl + "/api/project",
                "Project", baseUrl + "/api/project/NAME"
        );
    }
}
