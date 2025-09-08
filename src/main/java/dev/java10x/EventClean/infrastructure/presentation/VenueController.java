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
    private final FindVenueByNeighborhoodUseCase findVenueByNeighborhoodUseCase;

    private final UpdateVenueUseCase updateVenueUseCase;
    private final EditVenueUseCase editVenueUseCase;
    private final DeleteVenueUseCase deleteVenueUseCase;

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
    public ResponseEntity<Map<String, Object>> findVenueByZipCode (@RequestParam String zipcode){
        Venue venueFound = findVenueByZipCodeUseCase.execute(zipcode);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully found.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueFound));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stablishment")
    public ResponseEntity<Map<String, Object>> findVenueByStablishmentName (@RequestParam String stablishmentName){
        Venue venueFound = findVenueByStablishmentNameUseCase.execute(stablishmentName);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully found.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueFound));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/neighborhood")
    public ResponseEntity<Map<String, Object>> findVenueByNeighborhood (@RequestParam String neighborhood){
        Venue venueFound = findVenueByNeighborhoodUseCase.execute(neighborhood);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully found.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueFound));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateVenue (@PathVariable Long id, @RequestBody VenueDTO venueDTO){
        Venue venueUpdated = updateVenueUseCase.execute(id, venueDTOMapper.toDomain(venueDTO));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully updated.");
        response.put("Venue details: ", venueDTOMapper.toDTO(venueUpdated));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editVenue (@PathVariable Long id, @RequestBody VenueDTO venueDTO){
        Venue editedVenue = editVenueUseCase.execute(id, venueDTOMapper.toDomain(venueDTO));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully edited.");
        response.put("Venue details: ", venueDTOMapper.toDTO(editedVenue));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteVenue (@PathVariable Long id){
        deleteVenueUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Venue successfully deleted.");
        return ResponseEntity.ok(response);
    }

}
