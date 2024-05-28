package com.NoBroker.service;

import com.NoBroker.entity.BuyerPlans;

import java.util.List;

public interface BuyerPlansService {
    List<BuyerPlans> getAllBuyerPlans();

    BuyerPlans getBuyerPlansById(Long id);

    BuyerPlans createBuyerPlans(BuyerPlans buyerPlans);

    BuyerPlans updateBuyerPlans(Long id, BuyerPlans updatedBuyerPlans);

    void deleteBuyerPlans(Long id);
}
