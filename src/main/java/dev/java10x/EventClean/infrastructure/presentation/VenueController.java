package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.usecases.venueUseCases.FindVenueByIdUseCase;
import dev.java10x.EventClean.core.usecases.venueUseCases.RegisterVenueUseCase;
import dev.java10x.EventClean.infrastructure.dtos.VenueDTO;
import dev.java10x.EventClean.infrastructure.mapper.VenueDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("venue")
@RequiredArgsConstructor
public class VenueController {

    private final VenueDTOMapper venueDTOMapper;
    private final RegisterVenueUseCase registerVenueUseCase;
    private final FindVenueByIdUseCase findVenueByIdUseCase;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerVenue (@RequestBody VenueDTO dto){
        Venue venue = registerVenueUseCase.execute(venueDTOMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully registered.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venue));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findVenueById (@PathVariable Long id){
        Venue venueFound = findVenueByIdUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully found.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueFound));
        return ResponseEntity.ok(response);
    }

}
