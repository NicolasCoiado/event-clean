package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entity.Venue;

import java.util.List;

public interface VenueGateway {
    Venue registerVenue (Venue venue);

    List<Venue> listVenues ();
    Venue findVenueById (Long id);
    Venue findVenueByStablishmentName (String stablishmentName);
    Venue findVenueByNeighborhood (String neighborhood);
    Venue findVenueByZipCode (String zipcode);

    Venue updateVenue(Long id, Venue venue);
    Venue editVenue (Long id, Venue venue);
    void deleteVenue (Long id);
}
