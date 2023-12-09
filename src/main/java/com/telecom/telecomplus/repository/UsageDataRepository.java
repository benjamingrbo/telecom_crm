package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.UsageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageDataRepository extends JpaRepository<UsageData, Long> {
}
