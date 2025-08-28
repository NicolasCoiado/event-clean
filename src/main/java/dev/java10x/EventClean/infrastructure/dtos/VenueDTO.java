package dev.java10x.EventClean.infrastructure.dtos;

import dev.java10x.EventClean.core.entity.Event;

public record VenueDTO (
        Long id,
        String establishment_name,
        String street,
        String number,
        String neighborhood,
        String zipCode,
        Event event
){
}