package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entity.Event;

import java.util.List;

public interface EventGateway {
    Event createEvent (Event event);
    Event findEventById (Long id);
    Event findEventByIdentifier (String identifier);
    List<Event> listEvents();
}
