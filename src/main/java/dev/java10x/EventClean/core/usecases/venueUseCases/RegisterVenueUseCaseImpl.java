package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class RegisterVenueUseCaseImpl implements RegisterVenueUseCase{

    private final VenueGateway venueGateway;

    public RegisterVenueUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(Venue venue) {
        return venueGateway.registerVenue(venue);
    }
}
