package com.telecom.telecomplus.service;

import com.telecom.telecomplus.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<com.telecom.telecomplus.model.Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Optional<com.telecom.telecomplus.model.Plan> getPlanById(Long planId) {
        return planRepository.findById(planId);
    }

    public com.telecom.telecomplus.model.Plan updatePlan(Long planId, com.telecom.telecomplus.model.Plan updatedPlan) {
        return planRepository.findById(planId)
                .map(plan -> {

                    if (updatedPlan.getName() != null) {
                        plan.setName(updatedPlan.getName());
                    }
                    if (updatedPlan.getCostPerMonth() != null){
                        plan.setCostPerMonth(updatedPlan.getCostPerMonth());
                    }
                    if (updatedPlan.getMinimumContractLength() != null){
                        plan.setMinimumContractLength(updatedPlan.getMinimumContractLength());
                    }

                    return planRepository.save(plan);
                })
                .orElse(null);
    }

    public com.telecom.telecomplus.model.Plan createPlan(com.telecom.telecomplus.model.Plan newPlan) {
        return planRepository.save(newPlan);
    }


    public String deletePlanById(Long planId) {
        planRepository.deleteById(planId);
        return "Plan with id: " + planId + " has been deleted.";
    }
}
