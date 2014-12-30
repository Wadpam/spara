package com.wadpam.spara.hooks;

import com.wadpam.spara.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by sosandstrom on 2014-12-29.
 */
public abstract class EventHook<T> {
    protected static final Logger LOGGER = LoggerFactory.getLogger(EventHook.class);
    protected final Class<T> requestClass;

    protected EventHook(Class<T> requestClass) {
        this.requestClass = requestClass;
    }

    public void process(Map<String, Object> body) {
        final String json = JsonUtils.toString(body);
    }

    protected void process(String json) {
        T event = parseEvent(json);
        onEvent(event);
    }

    public T parseEvent(String json) {
        return JsonUtils.parse(json, requestClass);
    }

    protected abstract void onEvent(T event);
}
