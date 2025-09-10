package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

public class UpdateEventUseCaseImpl implements UpdateEventUseCase {

    private final EventGateway eventGateway;

    public UpdateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Long id, Event event) {
        return eventGateway.updateEvent(id, event);
    }
}
