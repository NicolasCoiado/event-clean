package dev.java10x.EventClean.infrastructure.dtos;


public record VenueDTO (
        Long id,
        String establishment_name,
        String street,
        String number,
        String neighborhood,
        String zipCode,
        Long idEvent
){
}