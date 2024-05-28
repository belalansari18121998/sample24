package com.NoBroker.repository;

import com.NoBroker.entity.SellerPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerPlansRepository extends JpaRepository<SellerPlans, Long> {
    // You can add custom query methods if needed
}
