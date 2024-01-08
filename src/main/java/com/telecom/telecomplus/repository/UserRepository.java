package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.InvoiceWithCustomerSubscriptionCustomerUsageDataDTO;
import com.telecom.telecomplus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
