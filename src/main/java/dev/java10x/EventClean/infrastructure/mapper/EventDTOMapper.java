package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.infrastructure.dtos.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventDTOMapper {

    public EventDTO toDTO (Event entity){

        return new EventDTO(
                entity.id(),
                entity.title(),
                entity.description(),
                entity.identifier(),
                entity.start_date(),
                entity.end_date(),
                entity.venueId(),
                entity.capacity(),
                entity.type()
        );

    }

    public Event toDomain (EventDTO dto){

        return new Event(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.identifier(),
                dto.start_date(),
                dto.end_date(),
                dto.venueId(),
                dto.capacity(),
                dto.type()
        );

    }

}
