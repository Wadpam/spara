package com.wadpam.spara.api;

import com.google.appengine.api.utils.SystemProperty;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.wadpam.spara.dao.DProjectDaoBean;
import com.wadpam.spara.dao.DTicketDaoBean;
import com.wadpam.spara.domain.DProject;
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
import java.util.Map;

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

        if (SystemProperty.Environment.Value.Development.equals(SystemProperty.environment.value())) {
            populateExample(projectDao);
        }
    }

    private void populateExample(DProjectDaoBean projectDao) throws java.io.IOException {
        final DProject spara = new DProject();
        spara.setId("SPARA");
        spara.setDisplayName("Spara, the Issue Manager");
        projectDao.put(spara);
        LOGGER.info("populated example");
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
