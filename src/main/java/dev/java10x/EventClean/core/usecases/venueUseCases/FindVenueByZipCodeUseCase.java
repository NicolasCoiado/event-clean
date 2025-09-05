package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;

public interface FindVenueByZipCodeUseCase {
    public Venue execute (String zipcode);
}
