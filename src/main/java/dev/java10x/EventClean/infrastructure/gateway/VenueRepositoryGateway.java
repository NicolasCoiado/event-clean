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

//    @Override
//    public List<Venue> listVenues() {
//        return List.of();
//    }
//
    @Override
    public Venue findVenueById(Long id) {
        Optional<VenueEntity> optVenue = venueRepository.findById(id);
        return venueEntityMapper.toDomain(optVenue.get());
    }
//
//    @Override
//    public Venue findVenueByStablishmentName(String stablishmentName) {
//        return null;
//    }
//
//    @Override
//    public Venue findVenueByNeighborhood(String neighborhood) {
//        return null;
//    }
//
//    @Override
//    public Venue findVenueByZipCode(String zipcode) {
//        return null;
//    }
}
