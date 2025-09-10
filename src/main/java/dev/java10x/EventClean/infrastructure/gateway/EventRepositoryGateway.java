package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infrastructure.config.IdentifierGenerator;
import dev.java10x.EventClean.infrastructure.exceptions.EventNotFoundException;
import dev.java10x.EventClean.infrastructure.exceptions.UnregisteredVenueException;
import dev.java10x.EventClean.infrastructure.mapper.EventEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventRepository;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;
    private final IdentifierGenerator identifierGenerator;
    private final VenueRepository venueRepository;

    @Override
    public Event createEvent(Event event) {
        String identifier = identifierGenerator.generate(event);

        EventEntity entity = eventEntityMapper.toEntity(event);
        entity.setIdentifier(identifier);

        if (event.venueId() != null) {
            VenueEntity venueEntity = venueRepository.findById(event.venueId())
                    .orElseThrow(() -> new UnregisteredVenueException("The venue with ID " + event.venueId() + " has not been registered."));
            entity.setVenue(venueEntity);
        }

        EventEntity newEvent = eventRepository.save(entity);
        return eventEntityMapper.toDomain(newEvent);
    }

    @Override
    public Event findEventById(Long id) {
        EventEntity event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID: " + id + " not found!"));
        return eventEntityMapper.toDomain(event);
    }

    @Override
    public Event findEventByIdentifier(String identifier) {
        EventEntity event = eventRepository.findEventByIdentifier(identifier)
                .orElseThrow(() -> new EventNotFoundException("Event with Identifier: " + identifier + " not found!"));
        return eventEntityMapper.toDomain(event);
    }

    @Override
    public List<Event> listEvents() {
        List<EventEntity> eventEntities = eventRepository.findAll();
        return eventEntities.stream().map(eventEntityMapper::toDomain).toList();
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID: " + id + " not found!"));

        eventEntity.setId(id);
        eventEntity.setTitle(event.title());
        eventEntity.setDescription(event.description());
        eventEntity.setStart_date(event.start_date());
        eventEntity.setEnd_date(event.end_date());
        eventEntity.setCapacity(event.capacity());
        eventEntity.setType(event.type());

        if (event.venueId() != null) {
            VenueEntity venueEntity = venueRepository.findById(event.venueId())
                    .orElseThrow(() -> new UnregisteredVenueException("The venue with ID " + event.venueId() + " has not been registered."));
            eventEntity.setVenue(venueEntity);
        }

        EventEntity updatedEvent = eventRepository.save(eventEntity);
        return eventEntityMapper.toDomain(updatedEvent);
    }

    @Override
    public Event editEvent(Long id, Event event) {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID: " + id + " not found!"));

        if (event.title() != null) {
            eventEntity.setTitle(event.title());
        }
        if (event.description() != null) {
            eventEntity.setDescription(event.description());
        }
        if (event.start_date() != null) {
            eventEntity.setStart_date(event.start_date());
        }
        if (event.end_date() != null) {
            eventEntity.setEnd_date(event.end_date());
        }
        if (event.capacity() != null) {
            eventEntity.setCapacity(event.capacity());
        }
        if (event.type() != null) {
            eventEntity.setType(event.type());
        }

        if (event.venueId() != null) {
            VenueEntity venueEntity = venueRepository.findById(event.venueId())
                    .orElseThrow(() -> new UnregisteredVenueException("The venue with ID " + event.venueId() + " has not been registered."));
            eventEntity.setVenue(venueEntity);
        }

        EventEntity updatedEvent = eventRepository.save(eventEntity);
        return eventEntityMapper.toDomain(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID: " + id + " not found!"));

        if (eventEntity.getVenue() != null) {
            VenueEntity venueEntity = eventEntity.getVenue();
            venueEntity.setEvent(null);
            venueRepository.save(venueEntity);
        }

        eventRepository.delete(eventEntity);
    }
}