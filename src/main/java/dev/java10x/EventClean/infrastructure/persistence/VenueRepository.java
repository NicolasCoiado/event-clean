package dev.java10x.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Long> {
    public Optional<VenueEntity> findVenueByZipCode (String zipcode);
    public Optional<VenueEntity> findVenueByStablishmentName(String stablishmentName);
}
