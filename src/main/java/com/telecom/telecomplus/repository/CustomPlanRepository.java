package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPlanRepository extends JpaRepository<CustomPlan, Long> {
}
