package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class FindVenueByIdUseCaseImpl implements FindVenueByIdUseCase{

    private final VenueGateway venueGateway;

    public FindVenueByIdUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(Long id) {
        return venueGateway.findVenueById(id);
    }
}
