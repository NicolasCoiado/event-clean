package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

import java.util.List;

public class ListEventsUseCaseImpl implements ListEventsUseCase{

    private final EventGateway eventGateway;

    public ListEventsUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute () {
        return eventGateway.listEvents();
    }
}
