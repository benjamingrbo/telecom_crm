package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.UsageData;
import com.telecom.telecomplus.repository.UsageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsageDataService {

    private final UsageDataRepository usageDataRepository;

    @Autowired
    public UsageDataService(UsageDataRepository usageDataRepository) {
        this.usageDataRepository = usageDataRepository;
    }

    public List<UsageData> getAllUsageData() {
        return usageDataRepository.findAll();
    }

    public Optional<UsageData> getUsageDataById(Long userId) {
        return usageDataRepository.findById(userId);
    }

    public UsageData updateUsageData(Long userId, UsageData updatedUsageData) {
        return usageDataRepository.findById(userId)
                .map(usageData -> {

                    if (updatedUsageData.getCustomerId() != null) {
                        usageData.setCustomerId(updatedUsageData.getCustomerId());
                    }
                    if(updatedUsageData.getDataUsage() != null) {
                        usageData.setDataUsage(updatedUsageData.getDataUsage());
                    }
                    if(updatedUsageData.getCallMinutes() != null) {
                        usageData.setCallMinutes(updatedUsageData.getCallMinutes());
                    }
                    if(updatedUsageData.getContactedNumber() != null){
                        usageData.setContactedNumber(updatedUsageData.getContactedNumber());
                    }
                    if(updatedUsageData.getTimeStamp() != null){
                        usageData.setTimeStamp(updatedUsageData.getTimeStamp());
                    }

                    return usageDataRepository.save(usageData);
                })
                .orElse(null);
    }

    public UsageData createUsageData(UsageData newUsageData) {
        return usageDataRepository.save(newUsageData);
    }


    public String deleteUsageDataById(Long usageDataId) {
        usageDataRepository.deleteById(usageDataId);
        return "UsageData with id: " + usageDataId + " has been deleted.";
    }
}


