package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.CustomerSubscription;
import com.telecom.telecomplus.service.CustomerSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerSubscriptionController {

    private final CustomerSubscriptionService customerSubscriptionService;

    @Autowired
    public CustomerSubscriptionController(CustomerSubscriptionService customerSubscriptionService) {
        this.customerSubscriptionService = customerSubscriptionService;
    }

    @GetMapping("/customerSubscription/getAllCustomerSubscriptions")
    public List<CustomerSubscription> getAllCustomerSubscriptions(){
        return customerSubscriptionService.getAllCustomerSubscriptions();
    }

    @GetMapping("/customerSubscription/getCustomerSubscriptionById/{id}")
    public Optional<CustomerSubscription> getCustomerSubscriptionById(@PathVariable Long id){
        return customerSubscriptionService.getCustomerSubscriptionById(id);
    }

    @PutMapping("/customerSubscription/updateCustomerSubscription/{id}")
    public CustomerSubscription updateCustomerSubscription(@RequestBody CustomerSubscription updatedCustomerSubscription, @PathVariable  Long id){
        return customerSubscriptionService.updateCustomerSubscription(id, updatedCustomerSubscription);
    }

    @PostMapping("/customerSubscription/createCustomerSubscription")
    public CustomerSubscription createCustomerSubscription(@RequestBody CustomerSubscription newCustomerSubscription){
        return customerSubscriptionService.createCustomerSubscription(newCustomerSubscription);
    }

    @DeleteMapping("/customerSubscription/deleteCustomerSubscription/{id}")
    public String deleteCustomerSubscription(@PathVariable Long id){
        return customerSubscriptionService.deleteCustomerSubscriptionById(id);
    }
}
