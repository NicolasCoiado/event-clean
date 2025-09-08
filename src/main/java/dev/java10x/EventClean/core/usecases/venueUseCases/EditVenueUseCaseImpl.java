package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class EditVenueUseCaseImpl implements EditVenueUseCase{

    private final VenueGateway venueGateway;

    public EditVenueUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(Long id, Venue venue) {
        return venueGateway.editVenue(id, venue);
    }
}
