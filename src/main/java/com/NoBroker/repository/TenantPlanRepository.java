package com.NoBroker.repository;

import com.NoBroker.entity.TenantPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantPlanRepository extends JpaRepository<TenantPlan, Long> {
}

