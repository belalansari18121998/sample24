package com.NoBroker.service.impl;

import com.NoBroker.entity.TenantPlan;
import com.NoBroker.repository.TenantPlanRepository;
import com.NoBroker.service.TenantPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantPlanServiceImpl implements TenantPlanService {

    private  TenantPlanRepository tenantPlanRepository;

    @Autowired
    public TenantPlanServiceImpl(TenantPlanRepository tenantPlanRepository) {
        this.tenantPlanRepository = tenantPlanRepository;
    }

    @Override
    public List<TenantPlan> getAllTenantPlans() {
        return tenantPlanRepository.findAll();
    }

    @Override
    public TenantPlan getTenantPlanById(Long id) {
        Optional<TenantPlan> optionalTenantPlan = tenantPlanRepository.findById(id);
        return optionalTenantPlan.orElse(null);
    }

    @Override
    public TenantPlan createTenantPlan(TenantPlan tenantPlan) {
        return tenantPlanRepository.save(tenantPlan);
    }

    @Override
    public TenantPlan updateTenantPlan(Long id, TenantPlan updatedTenantPlan) {
        if (tenantPlanRepository.existsById(id)) {
            updatedTenantPlan.setId(id);
            return tenantPlanRepository.save(updatedTenantPlan);
        } else {
            return null; // Handle not found scenario
        }
    }

    @Override
    public void deleteTenantPlan(Long id) {
        tenantPlanRepository.deleteById(id);
    }
}

