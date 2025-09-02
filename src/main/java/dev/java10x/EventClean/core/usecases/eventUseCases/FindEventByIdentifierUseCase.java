package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;

public interface FindEventByIdentifierUseCase {
    public Event execute (String identifier);
}
