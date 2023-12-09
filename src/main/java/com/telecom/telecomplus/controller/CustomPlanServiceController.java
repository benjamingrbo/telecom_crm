package com.telecom.telecomplus.controller;


import com.telecom.telecomplus.model.CustomPlanService;
import com.telecom.telecomplus.service.CustomPlanServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomPlanServiceController {

    private final CustomPlanServiceService customPlanServiceService;

    @Autowired
    public CustomPlanServiceController(CustomPlanServiceService customPlanServiceService) {
        this.customPlanServiceService = customPlanServiceService;
    }

    @GetMapping("/customPlanService/getAllCustomPlanServices")
    public List<CustomPlanService> getAllCustomPlanServices(){
        return customPlanServiceService.getAllCustomPlanServices();
    }

    @GetMapping("/customPlanService/getCustomPlanServiceById/{id}")
    public Optional<CustomPlanService> getCustomPlanServiceById(@PathVariable Long id){
        return customPlanServiceService.getCustomPlanServiceById(id);
    }

    @PutMapping("/customPlanService/updateCustomPlanService/{id}")
    public CustomPlanService updateCustomPlanServiceService(@RequestBody CustomPlanService updatedCustomPlanService, @PathVariable  Long id){
        return customPlanServiceService.updateCustomPlanService(id, updatedCustomPlanService);
    }

    @PostMapping("/customPlanService/createCustomPlanService")
    public CustomPlanService createCustomPlanService(@RequestBody CustomPlanService newCustomPlanService){
        return customPlanServiceService.createCustomPlanService(newCustomPlanService);
    }

    @DeleteMapping("/customPlanService/deleteCustomPlanService/{id}")
    public String deleteCustomPlanService(@PathVariable Long id){
        return customPlanServiceService.deleteCustomPlanServiceById(id);
    }
}
