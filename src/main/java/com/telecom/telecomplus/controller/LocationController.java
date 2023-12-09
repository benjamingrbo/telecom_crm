package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Location;
import com.telecom.telecomplus.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {
    
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location/getAllLocations")
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping("/location/getLocationById/{id}")
    public Optional<Location> getLocationById(@PathVariable Long id){
        return locationService.getLocationById(id);
    }

    @PutMapping("/location/updateLocation/{id}")
    public Location updateLocation(@RequestBody Location updatedLocation, @PathVariable  Long id){
        return locationService.updateLocation(id, updatedLocation);
    }

    @PostMapping("/location/createLocation")
    public Location createLocation(@RequestBody Location newLocation){
        return locationService.createLocation(newLocation);
    }

    @DeleteMapping("/location/deleteLocation/{id}")
    public String deleteLocation(@PathVariable Long id){
        return locationService.deleteLocationById(id);
    }
}
