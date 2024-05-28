package com.NoBroker.service.impl;

import com.NoBroker.entity.SellerPlans;
import com.NoBroker.repository.SellerPlansRepository;
import com.NoBroker.service.SellerPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerPlansServiceImpl implements SellerPlansService {

    private final SellerPlansRepository sellerPlansRepository;

    @Autowired
    public SellerPlansServiceImpl(SellerPlansRepository sellerPlansRepository) {
        this.sellerPlansRepository = sellerPlansRepository;
    }

    @Override
    public List<SellerPlans> getAllSellerPlans() {
        return sellerPlansRepository.findAll();
    }

    @Override
    public SellerPlans getSellerPlansById(Long id) {
        Optional<SellerPlans> optionalSellerPlans = sellerPlansRepository.findById(id);
        return optionalSellerPlans.orElse(null);
    }

    @Override
    public SellerPlans createSellerPlans(SellerPlans sellerPlans) {
        return sellerPlansRepository.save(sellerPlans);
    }

    @Override
    public SellerPlans updateSellerPlans(Long id, SellerPlans updatedSellerPlans) {
        if (sellerPlansRepository.existsById(id)) {
            updatedSellerPlans.setId(id);
            return sellerPlansRepository.save(updatedSellerPlans);
        } else {
            return null; // Handle not found scenario
        }
    }

    @Override
    public void deleteSellerPlans(Long id) {
        sellerPlansRepository.deleteById(id);
    }
}

