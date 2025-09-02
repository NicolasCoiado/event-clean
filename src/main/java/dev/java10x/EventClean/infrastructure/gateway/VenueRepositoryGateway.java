package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.core.gateway.VenueGateway;
import dev.java10x.EventClean.infrastructure.mapper.VenueEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VenueRepositoryGateway implements VenueGateway {

    private final VenueRepository venueRepository;
    private final VenueEntityMapper entityMapper;

    @Override
    public Venue registerVenue(Venue venue) {
        VenueEntity venueEntity = entityMapper.toEntity(venue);
        VenueEntity venueSaved = venueRepository.save(venueEntity);
        return entityMapper.toDomain(venueSaved);
    }

//    @Override
//    public List<Venue> listVenues() {
//        return List.of();
//    }
//
//    @Override
//    public Venue findVenueById(Long id) {
//        return null;
//    }
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
