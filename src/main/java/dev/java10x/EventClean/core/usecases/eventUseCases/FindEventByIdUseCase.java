package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entity.Event;

public interface FindEventByIdUseCase {
    public Event execute (Long id);
}
