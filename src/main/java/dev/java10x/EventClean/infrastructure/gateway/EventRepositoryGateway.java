package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infrastructure.mapper.EventEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity entity = eventEntityMapper.toEntity(event);
        EventEntity newEvent = eventRepository.save(entity);
        return eventEntityMapper.toDomain(newEvent);
    }

    @Override
    public Event findEventById(Long id) {
        Optional<EventEntity> event = eventRepository.findById(id);
        return eventEntityMapper.toDomain(event.get());
    }

    @Override
    public Event findEventByIdentifier(String identifier) {
        Optional<EventEntity> event = eventRepository.findEventByIdentifier(identifier);
        return eventEntityMapper.toDomain(event.get());
    }

    @Override
    public List<Event> ListEvents() {
        List<EventEntity> eventEntities = eventRepository.findAll();
        return eventEntities.stream().map(eventEntityMapper::toDomain).toList();
    }
}