package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDateTime;

@Entity
@Table(name = "Events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false, unique = true)
    private String identifier;
    @Column(nullable = false)
    private LocalDateTime start_date;
    @Column(nullable = false)
    private LocalDateTime end_date;
    @OneToOne(mappedBy = "event")
    private VenueEntity venue;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(columnDefinition = "event_type")
    private EventType type;
}