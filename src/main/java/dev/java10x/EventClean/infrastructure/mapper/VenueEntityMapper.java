package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VenueEntityMapper {
    public VenueEntity toEntity (Venue venueDomain){
        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setId(venueDomain.id());
        venueEntity.setStablishmentName(venueDomain.stablishment_name());
        venueEntity.setStreet(venueDomain.street());
        venueEntity.setNumber(venueDomain.number());
        venueEntity.setNeighborhood(venueDomain.neighborhood());
        venueEntity.setZipCode(venueDomain.zipCode());
        venueEntity.setEvent(null);

        return venueEntity;
    }

    public VenueEntity toEntityWithEvent (Venue venueDomain, EventEntity event){
        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setId(venueDomain.id());
        venueEntity.setStablishmentName(venueDomain.stablishment_name());
        venueEntity.setStreet(venueDomain.street());
        venueEntity.setNumber(venueDomain.number());
        venueEntity.setNeighborhood(venueDomain.neighborhood());
        venueEntity.setZipCode(venueDomain.zipCode());
        venueEntity.setEvent(event);

        return venueEntity;
    }

    public Venue toDomain (VenueEntity venueEntity){
        return new Venue(
            venueEntity.getId(),
            venueEntity.getStablishmentName(),
            venueEntity.getStreet(),
            venueEntity.getNumber(),
            venueEntity.getNeighborhood(),
            venueEntity.getZipCode(),
            venueEntity.getEvent() != null ? venueEntity.getEvent().getId() : null
        );
    }



}
