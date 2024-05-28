package com.NoBroker.service;

import com.NoBroker.entity.TenantPlan;

import java.util.List;

public interface TenantPlanService {
    List<TenantPlan> getAllTenantPlans();
    TenantPlan getTenantPlanById(Long id);
    TenantPlan createTenantPlan(TenantPlan tenantPlan);
    TenantPlan updateTenantPlan(Long id, TenantPlan updatedTenantPlan);
    void deleteTenantPlan(Long id);
}

