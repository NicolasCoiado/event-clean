package dev.java10x.EventClean.infrastructure.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

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

}
