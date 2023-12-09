package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Gender;
import com.telecom.telecomplus.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GenderController {

    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("/gender/getAllGenders")
    public List<Gender> getAllGenders(){
        return genderService.getAllGenders();
    }

    @GetMapping("/gender/getGenderById/{id}")
    public Optional<Gender> getGenderById(@PathVariable Long id){
        return genderService.getGenderById(id);
    }

    @PutMapping("/gender/updateGender/{id}")
    public Gender updateGender(@RequestBody Gender updatedGender, @PathVariable  Long id){
        return genderService.updateGender(id, updatedGender);
    }

    @PostMapping("/gender/createGender")
    public Gender createGender(@RequestBody Gender newGender){
        return genderService.createGender(newGender);
    }

    @DeleteMapping("/gender/deleteGender/{id}")
    public String deleteGender(@PathVariable Long id){
        return genderService.deleteGenderById(id);
    }
}
