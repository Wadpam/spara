package com.wadpam.spara.hooks.github;

import com.wadpam.spara.hooks.EventHook;

/**
 * Created by sosandstrom on 2014-12-29.
 */
public class PushHook extends EventHook<PushRequest> {

    public PushHook() {
        super(PushRequest.class);
    }

    @Override
    public void onEvent(PushRequest push) {
    }
}
