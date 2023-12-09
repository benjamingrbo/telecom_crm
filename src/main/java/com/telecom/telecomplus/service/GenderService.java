package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Gender;
import com.telecom.telecomplus.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    private final GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    public Optional<Gender> getGenderById(Long genderId) {
        return genderRepository.findById(genderId);
    }

    public Gender updateGender(Long genderId, Gender updatedGender) {
        return genderRepository.findById(genderId)
                .map(gender -> {

                    if (updatedGender.getGender() != null) {
                        gender.setGender(updatedGender.getGender());
                    }

                    return genderRepository.save(gender);
                })
                .orElse(null);
    }

    public Gender createGender(Gender newGender) {
        return genderRepository.save(newGender);
    }


    public String deleteGenderById(Long genderId) {
        genderRepository.deleteById(genderId);
        return "Gender with id: " + genderId + " has been deleted.";
    }
}
