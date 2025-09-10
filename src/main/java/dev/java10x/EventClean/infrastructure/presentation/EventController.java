package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.usecases.eventUseCases.*;
import dev.java10x.EventClean.infrastructure.dtos.EventDTO;
import dev.java10x.EventClean.infrastructure.mapper.EventDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("event")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventCase;
    private final ListEventsUseCase listEventsUseCase;
    private final FindEventByIdUseCase findEventByIdUseCase;
    private final FindEventByIdentifierUseCase findEventByIdentifierUseCase;
    private final UpdateEventUseCase updateEventUseCaseImpl;
    private final EditEventUseCase editEventUseCase;
    private final DeleteEventUseCase deleteEventUseCase;
    private final EventDTOMapper eventDTOMapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEvent(@Valid @RequestBody EventDTO dto) {
        Event newEvent = createEventCase.execute(eventDTOMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event successfully created.");
        response.put("eventDetails", eventDTOMapper.toDTO(newEvent));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listEvents() {
        List<Event> eventModels = listEventsUseCase.execute();
        List<EventDTO> eventDTOS = eventModels.stream().map(eventDTOMapper::toDTO).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Events successfully listed.");
        response.put("events", eventDTOS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findEventById(@PathVariable Long id) {
        Event eventFound = findEventByIdUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event successfully found.");
        response.put("eventDetails", eventDTOMapper.toDTO(eventFound));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<Map<String, Object>> findEventByIdentifier(@PathVariable String identifier) {
        Event eventFound = findEventByIdentifierUseCase.execute(identifier);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event successfully found.");
        response.put("eventDetails", eventDTOMapper.toDTO(eventFound));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEvent(@PathVariable Long id, @Valid @RequestBody EventDTO dto) {
        Event eventUpdated = updateEventUseCaseImpl.execute(id, eventDTOMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event successfully updated.");
        response.put("eventDetails", eventDTOMapper.toDTO(eventUpdated));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editEvent(@PathVariable Long id, @Valid @RequestBody EventDTO dto) {
        Event eventEdited = editEventUseCase.execute(id, eventDTOMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event successfully edited.");
        response.put("eventDetails", eventDTOMapper.toDTO(eventEdited));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteEvent(@PathVariable Long id) {
        deleteEventUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event successfully deleted.");
        return ResponseEntity.ok(response);
    }
}