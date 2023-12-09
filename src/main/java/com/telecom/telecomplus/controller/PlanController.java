package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Plan;
import com.telecom.telecomplus.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlanController {
    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/plan/getAllPlans")
    public List<Plan> getAllPlans(){
        return planService.getAllPlans();
    }

    @GetMapping("/plan/getPlanById/{id}")
    public Optional<Plan> getPlanById(@PathVariable Long id){
        return planService.getPlanById(id);
    }

    @PutMapping("/plan/updatePlan/{id}")
    public Plan updatePlan(@RequestBody Plan updatedPlan, @PathVariable  Long id){
        return planService.updatePlan(id, updatedPlan);
    }

    @PostMapping("/plan/createPlan")
    public Plan createPlan(@RequestBody Plan newPlan){
        return planService.createPlan(newPlan);
    }

    @DeleteMapping("/plan/deletePlan/{id}")
    public String deletePlan(@PathVariable Long id){
        return planService.deletePlanById(id);
    }
}
