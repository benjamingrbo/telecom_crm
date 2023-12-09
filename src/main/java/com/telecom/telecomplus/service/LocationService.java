package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Location;
import com.telecom.telecomplus.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long locationId) {
        return locationRepository.findById(locationId);
    }

    public Location updateLocation(Long locationId, Location updatedLocation) {
        return locationRepository.findById(locationId)
                .map(location -> {

                    if (updatedLocation.getCity() != null) {
                        location.setCity(updatedLocation.getCity());
                    }
                    if (updatedLocation.getDistrict() != null) {
                        location.setDistrict(updatedLocation.getDistrict());
                    }

                    return locationRepository.save(location);
                })
                .orElse(null);
    }

    public Location createLocation(Location newLocation) {
        return locationRepository.save(newLocation);
    }


    public String deleteLocationById(Long locationId) {
        locationRepository.deleteById(locationId);
        return "Location with id: " + locationId + " has been deleted.";
    }
}
