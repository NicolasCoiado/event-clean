package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entity.Venue;

import java.util.List;

public interface VenueGateway {
    Venue registerVenue (Venue venue);

    List<Venue> listVenues ();
    Venue findVenueById (Long id);
    Venue findVenueByStablishmentName (String stablishmentName);
//    Venue findVenueByNeighborhood (String neighborhood);
    Venue findVenueByZipCode (String zipcode);

    // TODO: Create put to Venue
    // TODO: Create patch to Venue
    // TODO: Create delete to Venue

}
