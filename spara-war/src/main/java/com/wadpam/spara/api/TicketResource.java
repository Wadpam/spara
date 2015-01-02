package com.wadpam.spara.api;

import com.google.inject.Inject;
import com.wadpam.guja.crud.ParentedCrudResource;
import com.wadpam.spara.dao.DProjectDaoBean;
import com.wadpam.spara.dao.DTicketDaoBean;
import com.wadpam.spara.domain.DProject;
import com.wadpam.spara.domain.DTicket;

import javax.ws.rs.Path;

/**
 * Created by sosandstrom on 2014-12-30.
 */
@Path("api/project/{parentId}")
public class TicketResource extends ParentedCrudResource<DProject, String, DProjectDaoBean, DTicket, Long, DTicketDaoBean> {

    @Inject
    public TicketResource(DProjectDaoBean parentDao, DTicketDaoBean dao) {
        super(parentDao, dao);
    }
}
