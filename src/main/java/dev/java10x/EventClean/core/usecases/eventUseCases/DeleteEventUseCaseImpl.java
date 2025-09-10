package dev.java10x.EventClean.core.usecases.eventUseCases;

import dev.java10x.EventClean.core.gateway.EventGateway;

public class DeleteEventUseCaseImpl implements DeleteEventUseCase{

    private final EventGateway eventGateway;

    public DeleteEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(Long id) {
        eventGateway.deleteEvent(id);
    }
}
