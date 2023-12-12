package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomerSubscription;
import com.telecom.telecomplus.model.CustomerSubscriptionCustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerSubscriptionRepository extends JpaRepository<CustomerSubscription, Long> {
    @Query(value = "SELECT * FROM customersubscription cs WHERE cs.customer_id = ?1", nativeQuery = true)
    Optional<CustomerSubscription> findByCustomerId(Long customerId);

    @Query(value = "SELECT new com.telecom.telecomplus.model.CustomerSubscriptionCustomerDTO (cs.id, cs.customerId, cs.planId, cs.customPlanId, cs.deviceInfoId, cs.telephoneNumber, cs.contractLength, cs.startDate, c.firstName, c.lastName, c.address) FROM CustomerSubscription cs INNER JOIN Customer c ON cs.customerId = c.id")
    List<CustomerSubscriptionCustomerDTO> findCustomerSubscriptionsWithCustomers();
}
