package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.CustomPlan;
import com.telecom.telecomplus.repository.CustomPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomPlanService {
    
    private final CustomPlanRepository customPlanRepository;

    @Autowired
    public CustomPlanService(CustomPlanRepository customPlanRepository) {
        this.customPlanRepository = customPlanRepository;
    }

    public List<CustomPlan> getAllCustomPlans() {
        return customPlanRepository.findAll();
    }

    public Optional<CustomPlan> getCustomPlanById(Long customPlanId) {
        return customPlanRepository.findById(customPlanId);
    }

    public CustomPlan updateCustomPlan(Long customPlanId, CustomPlan updatedCustomPlan) {
        return customPlanRepository.findById(customPlanId)
                .map(customPlan -> {

                    if (updatedCustomPlan.getCostPerMonth() != null) {
                        customPlan.setCostPerMonth(updatedCustomPlan.getCostPerMonth());
                    }
                    if (updatedCustomPlan.getMinimumContractLength() != null) {
                        customPlan.setMinimumContractLength(updatedCustomPlan.getMinimumContractLength());
                    }

                    return customPlanRepository.save(customPlan);
                })
                .orElse(null);
    }

    public CustomPlan createCustomPlan(CustomPlan newCustomPlan) {
        return customPlanRepository.save(newCustomPlan);
    }


    public String deleteCustomPlanById(Long customPlanId) {
        customPlanRepository.deleteById(customPlanId);
        return "CustomPlan with id: " + customPlanId + " has been deleted.";
    }
}
