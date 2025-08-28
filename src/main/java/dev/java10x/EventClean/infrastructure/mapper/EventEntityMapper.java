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
        if (event == null) return null;

        EventEntity eventEntity = new EventEntity(
                event.id(),
                event.title(),
                event.description(),
                event.identifier(),
                event.start_date(),
                event.end_date(),
                null,
                event.capacity(),
                event.type()
        );

        if (event.venue() != null) {
            VenueEntity venueEntity = venueEntityMapper.toEntity(event.venue(), eventEntity);
            eventEntity.setVenue(venueEntity);
        }

        return eventEntity;
    }

    public Event toDomain(EventEntity eventEntity) {
        if (eventEntity == null) return null;

        Event event = new Event(
                eventEntity.getId(),
                eventEntity.getTitle(),
                eventEntity.getDescription(),
                eventEntity.getIdentifier(),
                eventEntity.getStart_date(),
                eventEntity.getEnd_date(),
                null,
                eventEntity.getCapacity(),
                eventEntity.getType()
        );

        if (eventEntity.getVenue() != null) {
            event = new Event(
                    event.id(),
                    event.title(),
                    event.description(),
                    event.identifier(),
                    event.start_date(),
                    event.end_date(),
                    venueEntityMapper.toDomainWithEvent(eventEntity.getVenue(), event),
                    event.capacity(),
                    event.type()
            );
        }

        return event;
    }
}
