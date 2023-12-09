package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Customer;
import com.telecom.telecomplus.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        return customerRepository.findById(customerId)
                .map(customer -> {

                    if (updatedCustomer.getFirstName() != null) {
                        customer.setFirstName(updatedCustomer.getFirstName());
                    }
                    if (updatedCustomer.getLastName() != null) {
                        customer.setLastName(updatedCustomer.getLastName());
                    }
                    if (updatedCustomer.getAddress() != null) {
                        customer.setAddress(updatedCustomer.getAddress());
                    }
                    if (updatedCustomer.getLocation() != null) {
                        customer.setLocation(updatedCustomer.getLocation());
                    }
                    if (updatedCustomer.getGender() != null) {
                        customer.setGender(updatedCustomer.getGender());
                    }
                    if (updatedCustomer.getOccupation() != null) {
                        customer.setOccupation(updatedCustomer.getOccupation());
                    }

                    return customerRepository.save(customer);
                })
                .orElse(null);
    }

    public Customer createCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }


    public String deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
        return "Customer with id: " + customerId + " has been deleted.";
    }
}