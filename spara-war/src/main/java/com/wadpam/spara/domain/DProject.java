package com.wadpam.spara.domain;

import net.sf.mardao.core.domain.AbstractStringEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by sosandstrom on 2014-12-30.
 */
@Entity
public class DProject extends AbstractStringEntity {

    @Basic
    private String displayName;

    @Basic
    private String description;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
