package com.NoBroker.repository;

import com.NoBroker.entity.OwnerPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPlansRepository extends JpaRepository<OwnerPlans, Long> {
    // You can add custom query methods if needed
}

