package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import org.springframework.stereotype.Component;

@Component
public class VenueEntityMapper {

    public VenueEntity toEntity(Venue venue, EventEntity eventEntity) {
        if (venue == null) return null;

        return new VenueEntity(
                venue.id(),
                venue.establishment_name(),
                venue.street(),
                venue.number(),
                venue.neighborhood(),
                venue.zipCode(),
                eventEntity
        );
    }

    public Venue toDomain(VenueEntity venueEntity) {
        if (venueEntity == null) return null;

        return new Venue(
                venueEntity.getId(),
                venueEntity.getEstablishment_name(),
                venueEntity.getStreet(),
                venueEntity.getNumber(),
                venueEntity.getNeighborhood(),
                venueEntity.getZipCode(),
                null
        );
    }


    public Venue toDomainWithEvent(VenueEntity venueEntity, Event event) {
        Venue venue = toDomain(venueEntity);

        return new Venue(
                venue.id(),
                venue.establishment_name(),
                venue.street(),
                venue.number(),
                venue.neighborhood(),
                venue.zipCode(),
                event
        );
    }
}
