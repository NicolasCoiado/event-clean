package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.usecases.CreateEventUseCase;
import dev.java10x.EventClean.infrastructure.dtos.EventDTO;
import dev.java10x.EventClean.infrastructure.mapper.EventDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class EventController{

    private final CreateEventUseCase createEventCase;
    private final EventDTOMapper eventDTOMapper;

    @PostMapping("create")
    public EventDTO createEvent(@RequestBody EventDTO dto){
        Event newEvent = createEventCase.execute(eventDTOMapper.toDomain(dto));
        return eventDTOMapper.toDTO(newEvent);
    }

}