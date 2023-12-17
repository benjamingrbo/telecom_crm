package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Customer;
import com.telecom.telecomplus.model.CustomerDTO;
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

    public Optional<CustomerDTO> getCustomerById(Long customerId) {
        return customerRepository.getAAA(customerId);
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
                    if (updatedCustomer.getLocationId() != null) {
                        customer.setLocationId(updatedCustomer.getLocationId());
                    }
                    if (updatedCustomer.getGenderId() != null) {
                        customer.setGenderId(updatedCustomer.getGenderId());
                    }
                    if (updatedCustomer.getOccupationId() != null) {
                        customer.setOccupationId(updatedCustomer.getOccupationId());
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
