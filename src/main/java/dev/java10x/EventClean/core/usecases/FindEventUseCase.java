package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entity.Event;

public interface FindEventUseCase {
    public Event execute (Long id);
}
