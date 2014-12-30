package com.wadpam.spara.hooks.github;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by sosandstrom on 2014-12-29.
 */
@XmlRootElement
public class PushRequest {
    private String compare;
    private List<Commit> commits;

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }
}
