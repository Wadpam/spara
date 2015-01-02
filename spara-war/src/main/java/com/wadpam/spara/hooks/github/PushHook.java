package com.wadpam.spara.hooks.github;

import com.google.inject.Inject;
import com.wadpam.spara.api.SparaResource;
import com.wadpam.spara.hooks.EventHook;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by sosandstrom on 2014-12-29.
 */
public class PushHook extends EventHook<PushRequest> {

    /** 2014-12-30T13:15:45+01:00 */
    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    final SparaResource sparaResource;

    @Inject
    public PushHook(SparaResource sparaResource) {
        super(PushRequest.class);
        this.sparaResource = sparaResource;
    }

    @Override
    public void onEvent(PushRequest push) {
        if (null != push.getCommits()) {
            for (Commit commit : push.getCommits()) {
                try {
                    sparaResource.processCommit(commit.getMessage(), commit.getId(), commit.getAuthor().getUsername(),
                            SDF.parse(commit.getTimestamp()), commit.getUrl());
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
