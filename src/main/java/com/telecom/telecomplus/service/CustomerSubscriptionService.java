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

    public CustomerSubscription updateCustomerSubscription(Long customerSubscriptionId, CustomerSubscription updatedCustomerSubscription) {
        return customerSubscriptionRepository.findById(customerSubscriptionId)
                .map(customerSubscription -> {

                    if (updatedCustomerSubscription.getCustomer() != null) {
                        customerSubscription.setCustomer(updatedCustomerSubscription.getCustomer());
                    }
                    if (updatedCustomerSubscription.getPlan() != null) {
                        customerSubscription.setPlan(updatedCustomerSubscription.getPlan());
                    }
                    if (updatedCustomerSubscription.getCustomPlan() != null) {
                        customerSubscription.setCustomPlan(updatedCustomerSubscription.getCustomPlan());
                    }
                    if (updatedCustomerSubscription.getDeviceInfo() != null) {
                        customerSubscription.setDeviceInfo(updatedCustomerSubscription.getDeviceInfo());
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
