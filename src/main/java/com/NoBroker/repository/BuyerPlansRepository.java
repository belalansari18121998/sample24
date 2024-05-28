package com.NoBroker.repository;

import com.NoBroker.entity.BuyerPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerPlansRepository extends JpaRepository<BuyerPlans, Long> {
    // You can add custom query methods if needed
}
