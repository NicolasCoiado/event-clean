package dev.java10x.EventClean.core.entity;

public record Venue(
        Long id,
        String establishment_name,
        String street,
        String number,
        String neighborhood,
        String zipCode,
        Event event
) {
}
