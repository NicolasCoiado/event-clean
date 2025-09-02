package dev.java10x.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<VenueEntity, Long> {
}
