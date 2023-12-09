package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Occupation;
import com.telecom.telecomplus.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OccupationController {

    private final OccupationService occupationService;

    @Autowired
    public OccupationController(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @GetMapping("/occupation/getAllOccupations")
    public List<Occupation> getAllOccupations(){
        return occupationService.getAllOccupations();
    }

    @GetMapping("/occupation/getOccupationById/{id}")
    public Optional<Occupation> getOccupationById(@PathVariable Long id){
        return occupationService.getOccupationById(id);
    }

    @PutMapping("/occupation/updateOccupation/{id}")
    public Occupation updateOccupation(@RequestBody Occupation updatedOccupation, @PathVariable  Long id){
        return occupationService.updateOccupation(id, updatedOccupation);
    }

    @PostMapping("/occupation/createOccupation")
    public Occupation createOccupation(@RequestBody Occupation newOccupation){
        return occupationService.createOccupation(newOccupation);
    }

    @DeleteMapping("/occupation/deleteOccupation/{id}")
    public String deleteOccupation(@PathVariable Long id){
        return occupationService.deleteOccupationById(id);
    }
}
