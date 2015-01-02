package com.wadpam.spara.domain;

import net.sf.mardao.core.Parent;
import net.sf.mardao.domain.AbstractLongEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by sosandstrom on 2014-12-30.
 */
@Entity
public class DTicket extends AbstractLongEntity {

    @Parent(kind = "DProject")
    private Object projectKey;

    @Basic
    private String title;

    @Basic
    private String description;

    public Object getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(Object projectKey) {
        this.projectKey = projectKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
