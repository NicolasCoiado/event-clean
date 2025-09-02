package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.entity.Venue;
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
        eventEntity.setCapacity(event.capacity());
        eventEntity.setType(event.type());

        if (event.venue() == null){
            eventEntity.setVenue(null);
        }else{
            VenueEntity venueEntity = venueEntityMapper.toEntity(event.venue());
            eventEntity.setVenue(venueEntity);
        }

        return eventEntity;
    }

    public Event toDomain(EventEntity eventEntity) {
        if (eventEntity.getVenue() == null){
            return new Event(
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
        }else{
            Venue venue = venueEntityMapper.toDomain(eventEntity.getVenue());
            return new Event(
                    eventEntity.getId(),
                    eventEntity.getTitle(),
                    eventEntity.getDescription(),
                    eventEntity.getIdentifier(),
                    eventEntity.getStart_date(),
                    eventEntity.getEnd_date(),
                    venue,
                    eventEntity.getCapacity(),
                    eventEntity.getType()
            );
        }
    }
}
