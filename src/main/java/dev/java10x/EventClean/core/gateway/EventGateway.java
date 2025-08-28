package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entity.Event;

public interface EventGateway {
    Event createEvent(Event event);
}
