package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

public class FindEventByIdUseCaseImpl implements FindEventByIdUseCase {

    private final EventGateway eventGateway;

    public FindEventByIdUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Long id) {
        return eventGateway.findEventById(id);
    }
}
