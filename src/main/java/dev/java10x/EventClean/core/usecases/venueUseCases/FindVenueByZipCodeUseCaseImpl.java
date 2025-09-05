package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;

public class FindVenueByZipCodeUseCaseImpl implements FindVenueByZipCodeUseCase{

    private final VenueGateway venueGateway;

    public FindVenueByZipCodeUseCaseImpl(VenueGateway venueGateway) {
        this.venueGateway = venueGateway;
    }

    @Override
    public Venue execute(String zipcode) {
        return venueGateway.findVenueByZipCode(zipcode);
    }
}
