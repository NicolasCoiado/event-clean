package dev.java10x.EventClean.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Venues")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VenueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String establishment_name;
    @Column(nullable = false)
    private String street;
    private String number;
    private String neighborhood;
    @Column(name = "zipcode", nullable = false)
    private String zipCode;
    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id") // cria coluna event_id em Venues
    private EventEntity event;
}
