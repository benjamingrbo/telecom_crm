package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.CustomerSubscription;
import com.telecom.telecomplus.repository.CustomerSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSubscriptionService {

    private final CustomerSubscriptionRepository customerSubscriptionRepository;

    @Autowired
    public CustomerSubscriptionService(CustomerSubscriptionRepository customerSubscriptionRepository) {
        this.customerSubscriptionRepository = customerSubscriptionRepository;
    }

    public List<CustomerSubscription> getAllCustomerSubscriptions() {
        return customerSubscriptionRepository.findAll();
    }

    public Optional<CustomerSubscription> getCustomerSubscriptionById(Long customerSubscriptionId) {
        return customerSubscriptionRepository.findById(customerSubscriptionId);
    }

    public Optional<CustomerSubscription> getCustomerSubscriptionByCustomerId(Long customerId){
        return customerSubscriptionRepository.findByCustomerId(customerId);
    }

    public CustomerSubscription updateCustomerSubscription(Long customerSubscriptionId, CustomerSubscription updatedCustomerSubscription) {
        return customerSubscriptionRepository.findById(customerSubscriptionId)
                .map(customerSubscription -> {

                    if (updatedCustomerSubscription.getCustomerId() != null) {
                        customerSubscription.setCustomerId(updatedCustomerSubscription.getCustomerId());
                    }
                    if (updatedCustomerSubscription.getPlanId() != null) {
                        customerSubscription.setPlanId(updatedCustomerSubscription.getPlanId());
                    }
                    if (updatedCustomerSubscription.getCustomPlanId() != null) {
                        customerSubscription.setCustomPlanId(updatedCustomerSubscription.getCustomPlanId());
                    }
                    if (updatedCustomerSubscription.getDeviceInfoId() != null) {
                        customerSubscription.setDeviceInfoId(updatedCustomerSubscription.getDeviceInfoId());
                    }
                    if (updatedCustomerSubscription.getTelephoneNumber() != null) {
                        customerSubscription.setTelephoneNumber(updatedCustomerSubscription.getTelephoneNumber());
                    }
                    if (updatedCustomerSubscription.getContractLength() != null) {
                        customerSubscription.setContractLength(updatedCustomerSubscription.getContractLength());
                    }
                    if (updatedCustomerSubscription.getStartDate() != null) {
                        customerSubscription.setStartDate(updatedCustomerSubscription.getStartDate());
                    }

                    return customerSubscriptionRepository.save(customerSubscription);
                })
                .orElse(null);
    }

    public CustomerSubscription createCustomerSubscription(CustomerSubscription newCustomerSubscription) {
        return customerSubscriptionRepository.save(newCustomerSubscription);
    }


    public String deleteCustomerSubscriptionById(Long customerSubscriptionId) {
        customerSubscriptionRepository.deleteById(customerSubscriptionId);
        return "CustomerSubscription with id: " + customerSubscriptionId + " has been deleted.";
    }
}
