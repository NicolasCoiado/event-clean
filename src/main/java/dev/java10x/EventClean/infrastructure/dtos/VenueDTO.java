package dev.java10x.EventClean.infrastructure.dtos;


import jakarta.validation.constraints.NotBlank;

public record VenueDTO (
        Long id,
        String establishment_name,
        @NotBlank(message = "Street is mandatory")
        String street,
        String number,
        String neighborhood,
        String zipCode,
        Long idEvent
){
}