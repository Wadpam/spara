package com.wadpam.spara.api;

import com.google.appengine.api.utils.SystemProperty;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.wadpam.guja.util.Pair;
import com.wadpam.spara.dao.DCommitDaoBean;
import com.wadpam.spara.dao.DProjectDaoBean;
import com.wadpam.spara.dao.DTicketDaoBean;
import com.wadpam.spara.domain.DCommit;
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
import java.util.*;
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
    private final DCommitDaoBean commitDao;

    @Inject
    public SparaResource(DProjectDaoBean projectDao, DTicketDaoBean ticketDao, DCommitDaoBean commitDao) throws IOException {
        this.projectDao = projectDao;
        this.ticketDao = ticketDao;
        this.commitDao = commitDao;
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

    static final Pattern TICKET_PATTERN = Pattern.compile("([A-Z]+)-([\\d]+)[\\s,:]+");
    protected static TreeSet<Pair<String, Long>> findTicketIds(String message) {
        final TreeSet<Pair<String, Long>> tickets = new TreeSet<>();
        Matcher matcher = TICKET_PATTERN.matcher(message);
        while (matcher.find()) {
            tickets.add(Pair.of(matcher.group(1), Long.parseLong(matcher.group(2))));
        }
        return tickets;
    }

    public Set<String> processCommit(String message, String commitId, String username,
                                     Date timestamp, String commitUrl) throws IOException {
        final TreeSet<String> ticketIds = new TreeSet<>();
        // iterate across mentioned tickets
        for (Pair<String, Long> ticketPair : findTicketIds(message)) {

            // check if project exists
            final String projectId = ticketPair.first();
            final DProject project = projectDao.get(projectId);
            if (null != project) {
                final Object projectKey = projectDao.getKey(projectId);
                final Long ticketId = ticketPair.second();
                final Object ticketKey = ticketDao.getKey(projectKey, ticketId);

                final DCommit commit = commitDao.newBuilder()
                        .createdBy(username)
                        .createdDate(timestamp)
                        .id(commitId)
                        .ticketKey(ticketKey)
                        .message(message)
                        .url(commitUrl)
                        .build();
                commitDao.put(commit);

                ticketIds.add(projectId + "-" + ticketId);
            }
        }
        return ticketIds;
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
