package com.NoBroker.service;

import com.NoBroker.entity.Plan;

import java.util.List;

public interface PlanService {

    Plan createPlan(Plan plan);

    List<Plan> getAllPlans();

    Plan getPlanById(long planId);

    Plan updatePlan(long planId, Plan updatedPlan);

    void deletePlan(long planId);
}
