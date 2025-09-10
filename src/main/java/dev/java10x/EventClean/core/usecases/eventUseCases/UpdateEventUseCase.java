package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;

public interface UpdateEventUseCase {
    public Event execute (Long id, Event event);
}
