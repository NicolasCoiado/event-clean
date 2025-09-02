package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Event;
import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.VenueEntity;
import org.springframework.stereotype.Component;

@Component
public class VenueEntityMapper {
        private EventEntityMapper eventEntityMapper;

        public VenueEntity toEntity (Venue venue){

            VenueEntity venueEntity = new VenueEntity();

            venueEntity.setId(venue.id());
            venueEntity.setEstablishment_name(venue.establishment_name());
            venueEntity.setStreet(venue.street());
            venueEntity.setNumber(venue.number());
            venueEntity.setNeighborhood(venue.neighborhood());
            venueEntity.setZipCode(venue.zipCode());

            if (venue.event() == null){
                venueEntity.setEvent(null);
            }else{
                EventEntity eventEntity = eventEntityMapper.toEntity(venue.event());
                venueEntity.setEvent(eventEntity);
            }

            return venueEntity;
        }

        public Venue toDomain (VenueEntity venueEntity){
            if(venueEntity.getEvent() == null){
                return new Venue(
                        venueEntity.getId(),
                        venueEntity.getEstablishment_name(),
                        venueEntity.getStreet(),
                        venueEntity.getNumber(),
                        venueEntity.getNeighborhood(),
                        venueEntity.getZipCode(),
                        null
                );
            }else{
                Event event = eventEntityMapper.toDomain(venueEntity.getEvent());

                return new Venue(
                        venueEntity.getId(),
                        venueEntity.getEstablishment_name(),
                        venueEntity.getStreet(),
                        venueEntity.getNumber(),
                        venueEntity.getNeighborhood(),
                        venueEntity.getZipCode(),
                        event
                );
            }

        }
}
