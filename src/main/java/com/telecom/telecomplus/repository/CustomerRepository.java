package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.Customer;
import com.telecom.telecomplus.model.CustomerDTO;
import com.telecom.telecomplus.model.CustomerSubscriptionCustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT new com.telecom.telecomplus.model.CustomerDTO (c.id, c.firstName, c.lastName, c.address,c.genderId, c.locationId, c.occupationId, l.city, l.district, g.gender, o.occupationName) FROM Customer c INNER JOIN Location l ON c.locationId = l.id INNER JOIN Gender g on c.genderId = g.id INNER JOIN Occupation o on c.occupationId = o.id WHERE c.id = ?1")
    Optional<CustomerDTO> getAAA(Long id);
}
