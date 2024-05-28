package com.NoBroker.service;

import com.NoBroker.entity.SellerPlans;

import java.util.List;

public interface SellerPlansService {
    List<SellerPlans> getAllSellerPlans();

    SellerPlans getSellerPlansById(Long id);

    SellerPlans createSellerPlans(SellerPlans sellerPlans);

    SellerPlans updateSellerPlans(Long id, SellerPlans updatedSellerPlans);

    void deleteSellerPlans(Long id);
}

