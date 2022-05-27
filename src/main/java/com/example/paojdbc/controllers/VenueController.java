package com.example.paojdbc.controllers;

import com.example.paojdbc.models.Product;
import com.example.paojdbc.models.Venue;
import com.example.paojdbc.services.VenueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class VenueController {
    private final VenueService venueService;

    public void addVenue(Venue venue){
        venueService.addVenue(venue);
    }

    public void deleteVenue(Venue venue){
        venueService.deleteVenue(venue);
    }

    public List<Venue> getVenues(){
        return venueService.getVenues();
    }

    public List<Product> getMenuOfAVenue(Venue venue){
       return venueService.getMenuOfAVenue(venue);
    }
}
