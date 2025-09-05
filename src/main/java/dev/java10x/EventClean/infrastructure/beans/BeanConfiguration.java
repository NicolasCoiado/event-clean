package dev.java10x.EventClean.infrastructure.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.gateway.VenueGateway;
import dev.java10x.EventClean.core.usecases.eventUseCases.*;
import dev.java10x.EventClean.core.usecases.venueUseCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // Bean configuration for the Event

    @Bean
    public CreateEventUseCase createEvent (EventGateway eventGateway){
        return new CreateEventUseCaseImpl(eventGateway);
    }

    @Bean
    public ListEventsUseCase listEvents (EventGateway eventGateway){
        return new ListEventsUseCaseImpl(eventGateway);
    }

    @Bean
    public FindEventByIdUseCase findEventById (EventGateway eventGateway){
        return new FindEventByIdUseCaseImpl(eventGateway);
    }

    @Bean
    public FindEventByIdentifierUseCase findEventByIdentifier (EventGateway eventGateway){
        return new FindEventByIdentifierUseCaseImpl(eventGateway);
    }

    // Bean configuration for the Venue

    @Bean
    public RegisterVenueUseCase registerVenue (VenueGateway venueGateway){
        return new RegisterVenueUseCaseImpl(venueGateway);
    }

    @Bean
    public ListVenuesUseCase listVenuesUseCase (VenueGateway venueGateway){
        return new ListVenuesUseCaseImpl(venueGateway);
    }

    @Bean
    public FindVenueByIdUseCase findVenueById (VenueGateway venueGateway){
        return new FindVenueByIdUseCaseImpl(venueGateway);
    }

    @Bean
    public FindVenueByZipCodeUseCase findVenueByZipCode (VenueGateway venueGateway){
        return new FindVenueByZipCodeUseCaseImpl(venueGateway);
    }

    @Bean
    public FindVenueByStablishmentNameUseCase findVenueByStablishmentName (VenueGateway venueGateway){
        return new FindVenueByStablishmentNameUseCaseImpl(venueGateway);
    }
}
