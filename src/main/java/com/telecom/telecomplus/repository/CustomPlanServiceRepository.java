package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomPlanService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPlanServiceRepository extends JpaRepository<CustomPlanService, Long> {
}
