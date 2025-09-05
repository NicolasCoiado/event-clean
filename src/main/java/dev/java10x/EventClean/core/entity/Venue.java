package dev.java10x.EventClean.core.entity;

public record Venue(
        Long id,
        String stablishment_name,
        String street,
        String number,
        String neighborhood,
        String zipCode,
        Long eventId
) {
}
