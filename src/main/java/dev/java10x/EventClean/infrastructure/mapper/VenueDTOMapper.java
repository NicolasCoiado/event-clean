package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.infrastructure.dtos.VenueDTO;
import org.springframework.stereotype.Component;

@Component
public class VenueDTOMapper {

    public VenueDTO toDTO (Venue entity){

        return new VenueDTO(
                entity.id(),
                entity.establishment_name(),
                entity.street(),
                entity.number(),
                entity.neighborhood(),
                entity.zipCode(),
                entity.event()
        );

    }

    public Venue toDomain (VenueDTO dto){

        return new Venue(
                dto.id(),
                dto.establishment_name(),
                dto.street(),
                dto.number(),
                dto.neighborhood(),
                dto.zipCode(),
                dto.event()
        );

    }

}
