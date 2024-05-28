package com.NoBroker.service;

import com.NoBroker.entity.OwnerPlans;

import java.util.List;

public interface OwnerPlansService {
    List<OwnerPlans> getAllOwnerPlans();

    OwnerPlans getOwnerPlansById(Long id);

    OwnerPlans createOwnerPlans(OwnerPlans ownerPlans);

    OwnerPlans updateOwnerPlans(Long id, OwnerPlans updatedOwnerPlans);

    void deleteOwnerPlans(Long id);
}
