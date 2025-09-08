package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class UpdateVenueUseCaseImpl implements UpdateVenueUseCase {

    private final VenueGateway venueGateway;

    public UpdateVenueUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(Long id, Venue venue) {
        return venueGateway.updateVenue(id, venue);
    }
}
