package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.usecases.venueUseCases.RegisterVenueUseCase;
import dev.java10x.EventClean.infrastructure.dtos.VenueDTO;
import dev.java10x.EventClean.infrastructure.mapper.VenueDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("venue")
@RequiredArgsConstructor
public class VenueController {

    private final VenueDTOMapper venueDTOMapper;
    private final RegisterVenueUseCase registerVenueUseCase;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerVenue (@RequestBody VenueDTO dto){
        Venue venue = registerVenueUseCase.execute(venueDTOMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully registered.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venue));
        return ResponseEntity.ok(response);
    }

}
