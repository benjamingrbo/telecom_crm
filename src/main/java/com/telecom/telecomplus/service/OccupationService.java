package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Occupation;
import com.telecom.telecomplus.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {

    private final OccupationRepository occupationRepository;

    @Autowired
    public OccupationService(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    public List<Occupation> getAllOccupations() {
        return occupationRepository.findAll();
    }

    public Optional<Occupation> getOccupationById(Long occupationId) {
        return occupationRepository.findById(occupationId);
    }

    public Occupation updateOccupation(Long occupationId, Occupation updatedOccupation) {
        return occupationRepository.findById(occupationId)
                .map(occupation -> {

                    if (updatedOccupation.getOccupationName() != null) {
                        occupation.setOccupationName(updatedOccupation.getOccupationName());
                    }

                    return occupationRepository.save(occupation);
                })
                .orElse(null);
    }

    public Occupation createOccupation(Occupation newOccupation) {
        return occupationRepository.save(newOccupation);
    }


    public String deleteOccupationById(Long occupationId) {
        occupationRepository.deleteById(occupationId);
        return "Occupation with id: " + occupationId + " has been deleted.";
    }
}
