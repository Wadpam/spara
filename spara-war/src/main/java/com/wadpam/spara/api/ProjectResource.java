package com.wadpam.spara.api;

import com.google.inject.Inject;
import com.wadpam.guja.crud.CrudResource;
import com.wadpam.spara.dao.DProjectDaoBean;
import com.wadpam.spara.domain.DProject;

import javax.ws.rs.Path;

/**
 * Created by sosandstrom on 2014-12-30.
 */
@Path("api/project")
public class ProjectResource extends CrudResource<DProject, String, DProjectDaoBean> {

    @Inject
    public ProjectResource(DProjectDaoBean dao) {
        super(dao);
    }
}
