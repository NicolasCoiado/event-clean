package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.usecases.venueUseCases.*;
import dev.java10x.EventClean.infrastructure.dtos.VenueDTO;
import dev.java10x.EventClean.infrastructure.mapper.VenueDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("venue")
@RequiredArgsConstructor
public class VenueController {

    private final VenueDTOMapper venueDTOMapper;
    private final RegisterVenueUseCase registerVenueUseCase;
    private final ListVenuesUseCase listVenuesUseCase;
    private final FindVenueByIdUseCase findVenueByIdUseCase;
    private final FindVenueByZipCodeUseCase findVenueByZipCodeUseCase;
    private final FindVenueByStablishmentNameUseCase findVenueByStablishmentNameUseCase;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerVenue (@RequestBody VenueDTO dto){
        Venue venue = registerVenueUseCase.execute(venueDTOMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully registered.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venue));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listVenues (){
        List<Venue> venues = listVenuesUseCase.execute();
        List<VenueDTO> venueDTOS = venues.stream().map(venueDTOMapper::toDTO).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venues successfully listed.");
        response.put("Venues: ", venueDTOS);
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

    @GetMapping("/zipcode")
    public ResponseEntity<Map<String, Object>> findBenueByZipCode (@RequestParam String zipcode){
        Venue venueFound = findVenueByZipCodeUseCase.execute(zipcode);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully found.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueFound));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stablishment")
    public ResponseEntity<Map<String, Object>> findBenueByStablishmentName (@RequestParam String stablishmentName){
        Venue venueFound = findVenueByStablishmentNameUseCase.execute(stablishmentName);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully found.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueFound));
        return ResponseEntity.ok(response);
    }
}
