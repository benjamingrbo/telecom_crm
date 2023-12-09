package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomerSubscriptionDeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSubscriptionDeviceInfoRepository extends JpaRepository<CustomerSubscriptionDeviceInfo, Long> {
}
