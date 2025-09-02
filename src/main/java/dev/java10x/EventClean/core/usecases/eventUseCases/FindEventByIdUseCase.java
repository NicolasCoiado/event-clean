package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;

public interface FindEventByIdUseCase {
    public Event execute (Long id);
}
