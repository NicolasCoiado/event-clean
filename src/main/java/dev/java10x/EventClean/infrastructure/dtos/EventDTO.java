package dev.java10x.EventClean.infrastructure.dtos;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.enums.EventType;

import java.time.LocalDateTime;

public record EventDTO(
        Long id,
        String title,
        String description,
        String identifier,
        LocalDateTime start_date,
        LocalDateTime end_date,
        Venue venue,
        Integer capacity,
        EventType type
) {
}