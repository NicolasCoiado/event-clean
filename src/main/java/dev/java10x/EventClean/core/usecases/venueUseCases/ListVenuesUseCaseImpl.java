package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

import java.util.List;

public class ListVenuesUseCaseImpl implements ListVenuesUseCase {

    private final VenueGateway venueGateway;

    public ListVenuesUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public List<Venue> execute() {
        return venueGateway.listVenues();
    }
}
