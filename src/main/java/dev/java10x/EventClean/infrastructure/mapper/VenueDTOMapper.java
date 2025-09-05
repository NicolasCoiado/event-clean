package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entity.Venue;
import dev.java10x.EventClean.infrastructure.dtos.VenueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VenueDTOMapper {

    public VenueDTO toDTO (Venue entity){

        return new VenueDTO(
                entity.id(),
                entity.adstablishment_name(),
                entity.street(),
                entity.number(),
                entity.neighborhood(),
                entity.zipCode(),
                entity.eventId()
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
                dto.idEvent()
        );

    }

}
