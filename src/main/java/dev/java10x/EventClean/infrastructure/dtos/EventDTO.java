package dev.java10x.EventClean.infrastructure.dtos;

import dev.java10x.EventClean.core.enums.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventDTO(
        Long id,
        @NotBlank(message = "Title is mandatory")
        String title,
        String description,
        String identifier,
        @NotNull(message = "Start date is mandatory")
        LocalDateTime start_date,
        @NotNull(message = "End date is mandatory")
        LocalDateTime end_date,
        Long venueId,
        Integer capacity,
        EventType type
) {
}