package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.gateway.VenueGateway;

public class DeleteVenueUseCaseImpl implements DeleteVenueUseCase {
    private final VenueGateway venueGateway;

    public DeleteVenueUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public void execute(Long id) {
        venueGateway.deleteVenue(id);
    }
}
