package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomerSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerSubscriptionRepository extends JpaRepository<CustomerSubscription, Long> {

    @Query(value = "SELECT * FROM customersubscription cs WHERE cs.customer_id = ?1", nativeQuery = true)
    Optional<CustomerSubscription> findByCustomerId(Long customerId);
}
