package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entity.Event;

public class createEventCaseImpl implements createEventCase {

    @Override
    public Event execute(Event event) {
        return new Event(
                event.id(),
                event.title(),
                event.description(),
                event.identifier(),
                event.start_date(),
                event.end_date(),
                event.venue(),
                event.capacity(),
                event.type()
        );
    }
}
