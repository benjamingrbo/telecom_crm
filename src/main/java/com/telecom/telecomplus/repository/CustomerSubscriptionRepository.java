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

    @Query(value = "SELECT new com.telecom.telecomplus.model.CustomerSubscriptionCustomerDTO (cs.id, cs.customerId, cs.planId, cs.customPlanId, cs.deviceInfoId, cs.telephoneNumber, cs.contractLength, cs.startDate, c.firstName, c.lastName, c.address, csd.onNumberOfMonths) FROM CustomerSubscription cs INNER JOIN Customer c ON cs.customerId = c.id INNER JOIN CustomerSubscriptionDeviceInfo csd on cs.deviceInfoId = csd.id")
    List<CustomerSubscriptionCustomerDTO> findCustomerSubscriptionsWithCustomers();

    @Query(value = "SELECT new com.telecom.telecomplus.model.CustomerSubscriptionCustomerDTO (cs.id, cs.customerId, cs.planId, cs.customPlanId, cs.deviceInfoId, cs.telephoneNumber, cs.contractLength, cs.startDate, c.firstName, c.lastName, c.address, csd.onNumberOfMonths) FROM CustomerSubscription cs INNER JOIN Customer c ON cs.customerId = c.id INNER JOIN CustomerSubscriptionDeviceInfo csd on cs.deviceInfoId = csd.id WHERE cs.customerId = ?1")
    CustomerSubscriptionCustomerDTO findCustomerSubscriptionWithCustomerByCustomerId(Long customerId);
}
