package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Customer;
import com.telecom.telecomplus.model.CustomerDTO;
import com.telecom.telecomplus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/getCustomerById/{id}")
    public Optional<CustomerDTO> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PutMapping("/customer/updateCustomer/{id}")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable  Long id){
        return customerService.updateCustomer(id, updatedCustomer);
    }

    @PostMapping("/customer/createCustomer")
    public Customer createCustomer(@RequestBody Customer newCustomer){
        return customerService.createCustomer(newCustomer);
    }

    @DeleteMapping("/customer/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomerById(id);
    }
}
