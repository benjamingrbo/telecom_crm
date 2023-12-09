package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.PlanService;
import com.telecom.telecomplus.service.PlanServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlanServiceController {
    private final PlanServiceService planServiceService;

    @Autowired
    public PlanServiceController(PlanServiceService planServiceService) {
        this.planServiceService = planServiceService;
    }

    @GetMapping("/planService/getAllPlanServices")
    public List<PlanService> getAllPlanServices(){
        return planServiceService.getAllPlanServices();
    }

    @GetMapping("/planService/getPlanServiceById/{id}")
    public Optional<PlanService> getPlanServiceById(@PathVariable Long id){
        return planServiceService.getPlanServiceById(id);
    }

    @PutMapping("/planService/updatePlanService/{id}")
    public PlanService updatePlanService(@RequestBody PlanService updatedPlanService, @PathVariable  Long id){
        return planServiceService.updatePlanService(id, updatedPlanService);
    }

    @PostMapping("/planService/createPlanService")
    public PlanService createPlanService(@RequestBody PlanService newPlanService){
        return planServiceService.createPlanService(newPlanService);
    }

    @DeleteMapping("/planService/deletePlanService/{id}")
    public String deletePlanService(@PathVariable Long id){
        return planServiceService.deletePlanServiceById(id);
    }
}
