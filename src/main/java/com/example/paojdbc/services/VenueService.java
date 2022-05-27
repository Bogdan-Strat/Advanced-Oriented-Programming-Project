package com.example.paojdbc.services;

import com.example.paojdbc.models.Drink;
import com.example.paojdbc.models.Food;
import com.example.paojdbc.models.Product;
import com.example.paojdbc.models.Venue;
import com.example.paojdbc.repositories.VenueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VenueService {
    private final VenueRepository venueRepository;

    public void addVenue(Venue venue){
        venueRepository.addVenue(venue);
    }

    public void deleteVenue(Venue venue){
        venueRepository.deleteVenue(venue);
    }

    public List<Venue> getVenues(){
        return venueRepository.getVenues();
    }

    public List<Product> getMenuOfAVenue(Venue venue){
        List<Food> food = venueRepository.getFoodOfAVenue(venue);
        List<Drink> drinks = venueRepository.getDrinksOfAVenue(venue);

        List<Product> menu = new ArrayList<>();

        for(Food f : food){
            menu.add(f);
        }

        for(Drink drink : drinks){
            menu.add(drink);
        }

        return menu;
    }

}
