package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class FindVenueByStablishmentNameUseCaseImpl implements FindVenueByStablishmentNameUseCase{

    private final VenueGateway venueGateway;

    public FindVenueByStablishmentNameUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(String stablishmentName) {
        return venueGateway.findVenueByStablishmentName(stablishmentName);
    }
}
