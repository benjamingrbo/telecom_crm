package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.CustomPlan;
import com.telecom.telecomplus.service.CustomPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomPlanController {

    private final CustomPlanService customPlanService;

    @Autowired
    public CustomPlanController(CustomPlanService customPlanService) {
        this.customPlanService = customPlanService;
    }

    @GetMapping("/customPlan/getAllCustomPlans")
    public List<CustomPlan> getAllCustomPlans(){
        return customPlanService.getAllCustomPlans();
    }

    @GetMapping("/customPlan/getCustomPlanById/{id}")
    public Optional<CustomPlan> getCustomPlanById(@PathVariable Long id){
        return customPlanService.getCustomPlanById(id);
    }

    @PutMapping("/customPlan/updateCustomPlan/{id}")
    public CustomPlan updateCustomPlan(@RequestBody CustomPlan updatedCustomPlan, @PathVariable  Long id){
        return customPlanService.updateCustomPlan(id, updatedCustomPlan);
    }

    @PostMapping("/customPlan/createCustomPlan")
    public CustomPlan createCustomPlan(@RequestBody CustomPlan newCustomPlan){
        return customPlanService.createCustomPlan(newCustomPlan);
    }

    @DeleteMapping("/customPlan/deleteCustomPlan/{id}")
    public String deleteCustomPlan(@PathVariable Long id){
        return customPlanService.deleteCustomPlanById(id);
    }
}
