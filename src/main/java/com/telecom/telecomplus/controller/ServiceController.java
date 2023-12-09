package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Service;
import com.telecom.telecomplus.model.UsageData;
import com.telecom.telecomplus.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/service/getAllServices")
    public List<Service> getAllServices(){
        return serviceService.getAllServices();
    }

    @GetMapping("/service/getServiceById/{id}")
    public Optional<Service> getServiceById(@PathVariable Long id){
        return serviceService.getServiceById(id);
    }

    @PutMapping("/service/updateService/{id}")
    public Service updateService(@RequestBody Service updatedService, @PathVariable  Long id){
        return serviceService.updateService(id, updatedService);
    }

    @PostMapping("/service/createService")
    public Service createService(@RequestBody Service newService){
        return serviceService.createService(newService);
    }

    @DeleteMapping("/service/deleteService/{id}")
    public String deleteService(@PathVariable Long id){
        return serviceService.deleteServiceById(id);
    }
}
