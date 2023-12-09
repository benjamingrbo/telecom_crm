package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.UsageData;
import com.telecom.telecomplus.service.UsageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsageDataController {
    private final UsageDataService usageDataService;

    @Autowired
    public UsageDataController(UsageDataService usageDataService) {
        this.usageDataService = usageDataService;
    }

    @GetMapping("/usageData/getAllUsageData")
    public List<UsageData> getAllUsageData(){
        return usageDataService.getAllUsageData();
    }

    @GetMapping("/usageData/getUsageDataById/{id}")
    public Optional<UsageData> getUsageDataById(@PathVariable Long id){
        return usageDataService.getUsageDataById(id);
    }

    @PutMapping("/usageData/updateUsageData/{id}")
    public UsageData updateUsageData(@RequestBody UsageData updatedUsageData, @PathVariable  Long id){
        return usageDataService.updateUsageData(id, updatedUsageData);
    }

    @PostMapping("/usageData/createUsageData")
    public UsageData createUsageData(@RequestBody UsageData newUsageData){
        return usageDataService.createUsageData(newUsageData);
    }

    @DeleteMapping("/usageData/deleteUsageData/{id}")
    public String deleteUsageData(@PathVariable Long id){
        return usageDataService.deleteUsageDataById(id);
    }
}
