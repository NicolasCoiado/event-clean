package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;
import dev.java10x.EventClean.infrastructure.mapper.VenueEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventRepository;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
                    .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com id: " + venue.eventId()));

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
        Optional<VenueEntity> optVenue = venueRepository.findById(id);
        return venueEntityMapper.toDomain(optVenue.get());
    }

    public VenueEntity findVenueEntityById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));
    }

    @Override
    public Venue findVenueByStablishmentName(String stablishmentName) {
        Optional<VenueEntity> venueEntity = venueRepository.findVenueByStablishmentName(stablishmentName);
        return venueEntityMapper.toDomain(venueEntity.get());
    }

    @Override
    public Venue findVenueByNeighborhood(String neighborhood) {
        Optional<VenueEntity> optVenueFound = venueRepository.findVenueByNeighborhood(neighborhood);
        return venueEntityMapper.toDomain(optVenueFound.get());
    }

    @Override
    public Venue findVenueByZipCode(String zipcode) {
        Optional<VenueEntity> venueEntity = venueRepository.findVenueByZipCode(zipcode);
        return venueEntityMapper.toDomain(venueEntity.get());
    }

    @Override
    public Venue updateVenue(Long id, Venue venue) {
        Optional<VenueEntity> optVenueEntity = venueRepository.findById(id);

        if(optVenueEntity.isPresent()){
            VenueEntity venueEntity = optVenueEntity.get();
            venueEntity.setId(id);
            venueEntity.setStablishmentName(venue.stablishment_name());
            venueEntity.setStreet(venue.street());
            venueEntity.setNumber(venue.number());
            venueEntity.setNeighborhood(venue.neighborhood());
            venueEntity.setZipCode(venue.zipCode());

            if (venue.eventId() != null){
                Optional<EventEntity> optEventFound = eventRepository.findById(venue.eventId());
                venueEntity.setEvent(optEventFound.get());
            }

            VenueEntity venueUpdate = venueRepository.save(venueEntity);

            return venueEntityMapper.toDomain(venueUpdate);
        }

        return null;
    }

    @Override
    public Venue editVenue(Long id, Venue venue) {
        VenueEntity venueEntity = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));

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
                    .orElseThrow(() -> new RuntimeException("Event not found with id " + venue.eventId()));
            venueEntity.setEvent(eventEntity);
        }

        VenueEntity updatedVenue = venueRepository.save(venueEntity);
        return venueEntityMapper.toDomain(updatedVenue);
    }

    @Override
    public void deleteVenue(Long id) {
        VenueEntity venueEntity = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));

        if (venueEntity.getEvent() != null) {
            EventEntity eventEntity = venueEntity.getEvent();
            eventEntity.setVenue(null);
            eventRepository.save(eventEntity);
        }

        venueRepository.delete(venueEntity);
    }
}
