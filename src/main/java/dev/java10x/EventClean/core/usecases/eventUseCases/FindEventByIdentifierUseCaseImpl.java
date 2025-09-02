package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

public class FindEventByIdentifierUseCaseImpl implements FindEventByIdentifierUseCase {

    private final EventGateway eventGateway;

    public FindEventByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.findEventByIdentifier(identifier);
    }
}
