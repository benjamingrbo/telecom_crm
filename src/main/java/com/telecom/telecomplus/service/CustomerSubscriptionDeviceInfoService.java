package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.CustomerSubscriptionDeviceInfo;
import com.telecom.telecomplus.repository.CustomerSubscriptionDeviceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSubscriptionDeviceInfoService {

    private final CustomerSubscriptionDeviceInfoRepository customerSubscriptionDeviceInfoRepository;

    @Autowired
    public CustomerSubscriptionDeviceInfoService(CustomerSubscriptionDeviceInfoRepository customerSubscriptionDeviceInfoRepository) {
        this.customerSubscriptionDeviceInfoRepository = customerSubscriptionDeviceInfoRepository;
    }

    public List<CustomerSubscriptionDeviceInfo> getAllCustomerSubscriptionDeviceInfos() {
        return customerSubscriptionDeviceInfoRepository.findAll();
    }

    public Optional<CustomerSubscriptionDeviceInfo> getCustomerSubscriptionDeviceInfoById(Long customerSubscriptionDeviceInfoId) {
        return customerSubscriptionDeviceInfoRepository.findById(customerSubscriptionDeviceInfoId);
    }

    public CustomerSubscriptionDeviceInfo updateCustomerSubscriptionDeviceInfo(Long customerSubscriptionDeviceInfoId, CustomerSubscriptionDeviceInfo updatedCustomerSubscriptionDeviceInfo) {
        return customerSubscriptionDeviceInfoRepository.findById(customerSubscriptionDeviceInfoId)
                .map(customerSubscriptionDeviceInfo -> {

                    if (updatedCustomerSubscriptionDeviceInfo.getDevice() != null) {
                        customerSubscriptionDeviceInfo.setDevice(updatedCustomerSubscriptionDeviceInfo.getDevice());
                    }
                    if (updatedCustomerSubscriptionDeviceInfo.getOnNumberOfMonths() != null) {
                        customerSubscriptionDeviceInfo.setOnNumberOfMonths(updatedCustomerSubscriptionDeviceInfo.getOnNumberOfMonths());
                    }
                    if (updatedCustomerSubscriptionDeviceInfo.getIsActive() != null) {
                        customerSubscriptionDeviceInfo.setIsActive(updatedCustomerSubscriptionDeviceInfo.getIsActive());
                    }

                    return customerSubscriptionDeviceInfoRepository.save(customerSubscriptionDeviceInfo);
                })
                .orElse(null);
    }

    public CustomerSubscriptionDeviceInfo createCustomerSubscriptionDeviceInfo(CustomerSubscriptionDeviceInfo newCustomerSubscriptionDeviceInfo) {
        return customerSubscriptionDeviceInfoRepository.save(newCustomerSubscriptionDeviceInfo);
    }


    public String deleteCustomerSubscriptionDeviceInfoById(Long customerSubscriptionDeviceInfoId) {
        customerSubscriptionDeviceInfoRepository.deleteById(customerSubscriptionDeviceInfoId);
        return "CustomerSubscriptionDeviceInfo with id: " + customerSubscriptionDeviceInfoId + " has been deleted.";
    }
}
