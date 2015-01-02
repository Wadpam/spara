package com.wadpam.spara.domain;

import net.sf.mardao.core.Parent;
import net.sf.mardao.domain.AbstractStringEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by sosandstrom on 2014-12-30.
 */
@Entity
public class DCommit extends AbstractStringEntity {

    @Parent(kind = "DTicket")
    private Object ticketKey;

    @Basic
    private String message;

    @Basic
    private String url;

    public Object getTicketKey() {
        return ticketKey;
    }

    public void setTicketKey(Object ticketKey) {
        this.ticketKey = ticketKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
