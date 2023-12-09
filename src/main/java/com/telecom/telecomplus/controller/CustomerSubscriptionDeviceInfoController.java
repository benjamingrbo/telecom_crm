package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.CustomerSubscriptionDeviceInfo;
import com.telecom.telecomplus.service.CustomerSubscriptionDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerSubscriptionDeviceInfoController {

    private final CustomerSubscriptionDeviceInfoService customerSubscriptionDeviceInfoService;

    @Autowired
    public CustomerSubscriptionDeviceInfoController(CustomerSubscriptionDeviceInfoService customerSubscriptionDeviceInfoService) {
        this.customerSubscriptionDeviceInfoService = customerSubscriptionDeviceInfoService;
    }

    @GetMapping("/customerSubscriptionDeviceInfo/getAllCustomerSubscriptionDeviceInfos")
    public List<CustomerSubscriptionDeviceInfo> getAllCustomerSubscriptionDeviceInfos(){
        return customerSubscriptionDeviceInfoService.getAllCustomerSubscriptionDeviceInfos();
    }

    @GetMapping("/customerSubscriptionDeviceInfo/getCustomerSubscriptionDeviceInfoById/{id}")
    public Optional<CustomerSubscriptionDeviceInfo> getCustomerSubscriptionDeviceInfoById(@PathVariable Long id){
        return customerSubscriptionDeviceInfoService.getCustomerSubscriptionDeviceInfoById(id);
    }

    @PutMapping("/customerSubscriptionDeviceInfo/updateCustomerSubscriptionDeviceInfo/{id}")
    public CustomerSubscriptionDeviceInfo updateCustomerSubscriptionDeviceInfo(@RequestBody CustomerSubscriptionDeviceInfo updatedCustomerSubscriptionDeviceInfo, @PathVariable  Long id){
        return customerSubscriptionDeviceInfoService.updateCustomerSubscriptionDeviceInfo(id, updatedCustomerSubscriptionDeviceInfo);
    }

    @PostMapping("/customerSubscriptionDeviceInfo/createCustomerSubscriptionDeviceInfo")
    public CustomerSubscriptionDeviceInfo createCustomerSubscriptionDeviceInfo(@RequestBody CustomerSubscriptionDeviceInfo newCustomerSubscriptionDeviceInfo){
        return customerSubscriptionDeviceInfoService.createCustomerSubscriptionDeviceInfo(newCustomerSubscriptionDeviceInfo);
    }

    @DeleteMapping("/customerSubscriptionDeviceInfo/deleteCustomerSubscriptionDeviceInfo/{id}")
    public String deleteCustomerSubscriptionDeviceInfo(@PathVariable Long id){
        return customerSubscriptionDeviceInfoService.deleteCustomerSubscriptionDeviceInfoById(id);
    }
}
