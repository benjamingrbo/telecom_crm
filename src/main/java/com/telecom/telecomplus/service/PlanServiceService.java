package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.PlanService;
import com.telecom.telecomplus.model.Role;
import com.telecom.telecomplus.repository.PlanServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceService {

    private final PlanServiceRepository planServiceRepository;

    @Autowired
    public PlanServiceService(PlanServiceRepository planServiceRepository) {
        this.planServiceRepository = planServiceRepository;
    }

    public List<PlanService> getAllPlanServices() {
        return planServiceRepository.findAll();
    }

    public Optional<PlanService> getPlanServiceById(Long planServiceId) {
        return planServiceRepository.findById(planServiceId);
    }

    public PlanService updatePlanService(Long planServiceId, PlanService updatedPlanService) {
        return planServiceRepository.findById(planServiceId)
                .map(planService -> {

                    if (updatedPlanService.getService() != null) {
                        planService.setService(updatedPlanService.getService());
                    }
                    if (updatedPlanService.getPlan() != null){
                        planService.setPlan(updatedPlanService.getPlan());
                    }

                    return planServiceRepository.save(planService);
                })
                .orElse(null);
    }

    public PlanService createPlanService(PlanService newPlanService) {
        return planServiceRepository.save(newPlanService);
    }


    public String deletePlanServiceById(Long planServiceId) {
        planServiceRepository.deleteById(planServiceId);
        return "PlanService with id: " + planServiceId + " has been deleted.";
    }
}
