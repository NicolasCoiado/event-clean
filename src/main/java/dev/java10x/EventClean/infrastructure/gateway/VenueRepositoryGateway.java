package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;
import dev.java10x.EventClean.infrastructure.exceptions.EventNotFound;
import dev.java10x.EventClean.infrastructure.exceptions.VenueNotFoundException;
import dev.java10x.EventClean.infrastructure.mapper.VenueEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventRepository;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VenueRepositoryGateway implements VenueGateway {

    private final VenueRepository venueRepository;
    private final VenueEntityMapper venueEntityMapper;

    private final EventRepository eventRepository;

    @Override
    public Venue registerVenue(Venue venue) {
        VenueEntity venueEntity;

        if (venue.eventId() == null) {
            venueEntity = venueEntityMapper.toEntity(venue);
        } else {
            EventEntity eventEntity = eventRepository.findById(venue.eventId())
                    .orElseThrow(() -> new VenueNotFoundException("Venue with ID: " + venue.eventId() + " not found!"));

            venueEntity = venueEntityMapper.toEntityWithEvent(venue, eventEntity);

            eventEntity.setVenue(venueEntity);
        }

        VenueEntity venueSaved = venueRepository.save(venueEntity);
        return venueEntityMapper.toDomain(venueSaved);
    }

    @Override
    public List<Venue> listVenues() {
        List<VenueEntity> venueEntities = venueRepository.findAll();
        return venueEntities.stream().map(venueEntityMapper::toDomain).toList();
    }

    @Override
    public Venue findVenueById(Long id) {
        VenueEntity venueEntity = venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID: " + id + " not found!"));

        return venueEntityMapper.toDomain(venueEntity);
    }

    public VenueEntity findVenueEntityById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID: " + id + " not found!"));
    }

    @Override
    public Venue findVenueByStablishmentName(String stablishmentName) {
        VenueEntity venueEntity = venueRepository.findVenueByStablishmentName(stablishmentName)
                .orElseThrow(() -> new VenueNotFoundException("Venue named '" + stablishmentName + "' was not found."));
        return venueEntityMapper.toDomain(venueEntity);
    }

    @Override
    public Venue findVenueByNeighborhood(String neighborhood) {
        VenueEntity optVenueFound = venueRepository.findVenueByNeighborhood(neighborhood)
                .orElseThrow(() -> new VenueNotFoundException("No venue found in neighborhood '" + neighborhood + "'."));
        return venueEntityMapper.toDomain(optVenueFound);
    }

    @Override
    public Venue findVenueByZipCode(String zipcode) {
        VenueEntity venueEntity = venueRepository.findVenueByZipCode(zipcode)
                .orElseThrow(() -> new VenueNotFoundException("Venue with zip code '" + zipcode + "' not found!"));
        return venueEntityMapper.toDomain(venueEntity);
    }

    @Override
    public Venue updateVenue(Long id, Venue venue) {
        VenueEntity venueEntity = venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID: " + id + " not found!"));

        venueEntity.setId(id);
        venueEntity.setStablishmentName(venue.stablishment_name());
        venueEntity.setStreet(venue.street());
        venueEntity.setNumber(venue.number());
        venueEntity.setNeighborhood(venue.neighborhood());
        venueEntity.setZipCode(venue.zipCode());

        if (venue.eventId() != null){
            EventEntity eventEntity = eventRepository.findById(venue.eventId())
                    .orElseThrow(() -> new EventNotFound ("Event with ID: " + id + " not found!"));
            venueEntity.setEvent(eventEntity);
        }

        VenueEntity venueUpdate = venueRepository.save(venueEntity);

        return venueEntityMapper.toDomain(venueUpdate);
    }

    @Override
    public Venue editVenue(Long id, Venue venue) {
        VenueEntity venueEntity = venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID: " + id + " not found!"));

        if (venue.stablishment_name() != null) {
            venueEntity.setStablishmentName(venue.stablishment_name());
        }
        if (venue.street() != null) {
            venueEntity.setStreet(venue.street());
        }
        if (venue.number() != null) {
            venueEntity.setNumber(venue.number());
        }
        if (venue.neighborhood() != null) {
            venueEntity.setNeighborhood(venue.neighborhood());
        }
        if (venue.zipCode() != null) {
            venueEntity.setZipCode(venue.zipCode());
        }

        if (venue.eventId() != null) {
            EventEntity eventEntity = eventRepository.findById(venue.eventId())
                    .orElseThrow(() -> new EventNotFound("Event with ID: " + venue.eventId() + " not found!"));
            venueEntity.setEvent(eventEntity);
        }

        VenueEntity updatedVenue = venueRepository.save(venueEntity);
        return venueEntityMapper.toDomain(updatedVenue);
    }

    @Override
    public void deleteVenue(Long id) {
        VenueEntity venueEntity = venueRepository.findById(id)
                .orElseThrow(() -> new EventNotFound("Venue with ID: " + id + " not found!"));

        if (venueEntity.getEvent() != null) {
            EventEntity eventEntity = venueEntity.getEvent();
            eventEntity.setVenue(null);
            eventRepository.save(eventEntity);
        }

        venueRepository.delete(venueEntity);
    }
}
