package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.usecases.eventUseCases.CreateEventUseCase;
import dev.java10x.EventClean.core.usecases.eventUseCases.FindEventByIdUseCase;
import dev.java10x.EventClean.core.usecases.eventUseCases.FindEventByIdentifierUseCase;
import dev.java10x.EventClean.core.usecases.eventUseCases.ListEventsUseCase;
import dev.java10x.EventClean.infrastructure.dtos.EventDTO;
import dev.java10x.EventClean.infrastructure.mapper.EventDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
@RequiredArgsConstructor
public class EventController{

    private final CreateEventUseCase createEventCase;
    private final ListEventsUseCase listEventsUseCase;
    private final FindEventByIdUseCase findEventByIdUseCase;
    private final FindEventByIdentifierUseCase findEventByIdentifierUseCase;
    private final EventDTOMapper eventDTOMapper;

    @PostMapping
    public EventDTO createEvent(@RequestBody EventDTO dto){
        Event newEvent = createEventCase.execute(eventDTOMapper.toDomain(dto));
        return eventDTOMapper.toDTO(newEvent);
    }

    @GetMapping
    public List<EventDTO> listEvents (){
        List<Event> eventModels = listEventsUseCase.execute();
        return eventModels.stream().map(eventDTOMapper::toDTO).toList();        
    }

    @GetMapping("/{id}")
    public EventDTO findEventById (@PathVariable Long id){
        // TODO: Create response DTO or remove Event from Venue response
        // TODO: Event not found
        return eventDTOMapper.toDTO(findEventByIdUseCase.execute(id));
    }

    @GetMapping("/{identifier}")
    public EventDTO findEventByIdentifier (@PathVariable String identifier){
        return eventDTOMapper.toDTO(findEventByIdentifierUseCase.execute(identifier));
    }

}