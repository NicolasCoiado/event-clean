package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

public class EditEventUseCaseImpl implements EditEventUseCase{

    private final EventGateway eventGateway;

    public EditEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Long id, Event event) {
        return eventGateway.editEvent(id, event);
    }
}
