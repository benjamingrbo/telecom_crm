package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.CustomPlanService;
import com.telecom.telecomplus.repository.CustomPlanServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomPlanServiceService {

    private final CustomPlanServiceRepository customPlanServiceRepository;

    @Autowired
    public CustomPlanServiceService(CustomPlanServiceRepository customPlanServiceRepository) {
        this.customPlanServiceRepository = customPlanServiceRepository;
    }

    public List<CustomPlanService> getAllCustomPlanServices() {
        return customPlanServiceRepository.findAll();
    }

    public Optional<CustomPlanService> getCustomPlanServiceById(Long CustomPlanServiceId) {
        return customPlanServiceRepository.findById(CustomPlanServiceId);
    }

    public CustomPlanService updateCustomPlanService(Long customPlanServiceId, CustomPlanService updatedCustomPlanService) {
        return customPlanServiceRepository.findById(customPlanServiceId)
                .map(customPlanService -> {

                    if (updatedCustomPlanService.getService() != null) {
                        customPlanService.setService(updatedCustomPlanService.getService());
                    }
                    if (updatedCustomPlanService.getCustomPlan() != null) {
                        customPlanService.setCustomPlan(updatedCustomPlanService.getCustomPlan());
                    }

                    return customPlanServiceRepository.save(customPlanService);
                })
                .orElse(null);
    }

    public CustomPlanService createCustomPlanService(CustomPlanService newCustomPlanService) {
        return customPlanServiceRepository.save(newCustomPlanService);
    }


    public String deleteCustomPlanServiceById(Long customPlanServiceId) {
        customPlanServiceRepository.deleteById(customPlanServiceId);
        return "CustomPlanService with id: " + customPlanServiceId + " has been deleted.";
    }
}
