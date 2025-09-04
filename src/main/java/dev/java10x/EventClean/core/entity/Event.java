package dev.java10x.EventClean.core.entity;

import dev.java10x.EventClean.core.enums.EventType;

import java.time.LocalDateTime;

public record Event (
    Long id,
    String title,
    String description,
    String identifier,
    LocalDateTime start_date,
    LocalDateTime end_date,
    Long venueId,
    Integer capacity,
    EventType type
){
}
