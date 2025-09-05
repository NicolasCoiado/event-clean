package dev.java10x.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<VenueEntity, Long> {
    public Optional<VenueEntity> findVenueByZipCode (String zipcode);
}
