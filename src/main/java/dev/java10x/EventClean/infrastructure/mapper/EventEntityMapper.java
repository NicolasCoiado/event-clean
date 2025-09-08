package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEntityMapper {

    private final VenueEntityMapper venueEntityMapper;

    public EventEntity toEntity(Event event) {

        EventEntity eventEntity = new EventEntity();
        
        eventEntity.setId(event.id());
        eventEntity.setTitle(event.title());
        eventEntity.setDescription(event.description());
        eventEntity.setIdentifier(event.identifier());
        eventEntity.setStart_date(event.start_date());
        eventEntity.setEnd_date(event.end_date());
        eventEntity.setVenue(null);
        eventEntity.setCapacity(event.capacity());
        eventEntity.setType(event.type());

        return eventEntity;
    }

    public EventEntity toEntityWithVenue (Event event, VenueEntity venue) {

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId(event.id());
        eventEntity.setTitle(event.title());
        eventEntity.setDescription(event.description());
        eventEntity.setIdentifier(event.identifier());
        eventEntity.setStart_date(event.start_date());
        eventEntity.setEnd_date(event.end_date());
        eventEntity.setVenue(venue);
        eventEntity.setCapacity(event.capacity());
        eventEntity.setType(event.type());

        return eventEntity;
    }

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getTitle(),
                eventEntity.getDescription(),
                eventEntity.getIdentifier(),
                eventEntity.getStart_date(),
                eventEntity.getEnd_date(),
                eventEntity.getVenue() != null ? eventEntity.getVenue().getId() : null,
                eventEntity.getCapacity(),
                eventEntity.getType()
        );
    }
}
