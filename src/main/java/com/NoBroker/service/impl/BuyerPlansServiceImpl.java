package com.NoBroker.service.impl;

import com.NoBroker.entity.BuyerPlans;
import com.NoBroker.repository.BuyerPlansRepository;
import com.NoBroker.service.BuyerPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerPlansServiceImpl implements BuyerPlansService {

    private  BuyerPlansRepository buyerPlansRepository;

    @Autowired
    public BuyerPlansServiceImpl(BuyerPlansRepository buyerPlansRepository) {
        this.buyerPlansRepository = buyerPlansRepository;
    }

    @Override
    public List<BuyerPlans> getAllBuyerPlans() {
        return buyerPlansRepository.findAll();
    }

    @Override
    public BuyerPlans getBuyerPlansById(Long id) {
        Optional<BuyerPlans> optionalBuyerPlans = buyerPlansRepository.findById(id);
        return optionalBuyerPlans.orElse(null);
    }

    @Override
    public BuyerPlans createBuyerPlans(BuyerPlans buyerPlans) {
        return buyerPlansRepository.save(buyerPlans);
    }

    @Override
    public BuyerPlans updateBuyerPlans(Long id, BuyerPlans updatedBuyerPlans) {
        if (buyerPlansRepository.existsById(id)) {
            updatedBuyerPlans.setId(id);
            return buyerPlansRepository.save(updatedBuyerPlans);
        } else {
            return null; // Handle not found scenario
        }
    }

    @Override
    public void deleteBuyerPlans(Long id) {
        buyerPlansRepository.deleteById(id);
    }
}
