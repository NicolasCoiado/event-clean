package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class FindVenueByNeighborhoodUseCaseImpl implements FindVenueByNeighborhoodUseCase{
    private final VenueGateway venueGateway;

    public FindVenueByNeighborhoodUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(String neighborhood) {
        return venueGateway.findVenueByNeighborhood(neighborhood);
    }
}
