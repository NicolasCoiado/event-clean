package dev.java10x.EventClean.infrastructure.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecases.CreateEventUseCase;
import dev.java10x.EventClean.core.usecases.CreateEventUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEvent (EventGateway eventGateway){
        return new CreateEventUseCaseImpl(eventGateway);
    }

}
