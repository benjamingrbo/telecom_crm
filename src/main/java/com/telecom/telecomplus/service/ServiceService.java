package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.UsageData;
import com.telecom.telecomplus.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.telecom.telecomplus.model.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<com.telecom.telecomplus.model.Service> getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId);
    }

    public com.telecom.telecomplus.model.Service updateService(Long serviceId, com.telecom.telecomplus.model.Service updatedService) {
        return serviceRepository.findById(serviceId)
                .map(service -> {

                    if (updatedService.getServiceName() != null) {
                        service.setServiceName(updatedService.getServiceName());
                    }
                    if(updatedService.getDescription() != null) {
                        service.setDescription(updatedService.getDescription());
                    }
                    if(updatedService.getCostPerMonth() != null) {
                        updatedService.setCostPerMonth(updatedService.getCostPerMonth());
                    }

                    return serviceRepository.save(service);
                })
                .orElse(null);
    }

    public com.telecom.telecomplus.model.Service createService(com.telecom.telecomplus.model.Service newService) {
        return serviceRepository.save(newService);
    }


    public String deleteServiceById(Long serviceId) {
        serviceRepository.deleteById(serviceId);
        return "Service with id: " + serviceId + " has been deleted.";
    }
}
