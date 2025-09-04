package dev.java10x.EventClean.core.usecases.venueUseCases;

import dev.java10x.EventClean.core.entity.Venue;

public interface FindVenueByIdUseCase {
    public Venue execute(Long id);
}
