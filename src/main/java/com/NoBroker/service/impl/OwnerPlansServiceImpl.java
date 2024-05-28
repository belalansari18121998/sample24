package com.NoBroker.service.impl;

import com.NoBroker.entity.OwnerPlans;
import com.NoBroker.repository.OwnerPlansRepository;
import com.NoBroker.service.OwnerPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerPlansServiceImpl implements OwnerPlansService {

    private final OwnerPlansRepository ownerPlansRepository;

    @Autowired
    public OwnerPlansServiceImpl(OwnerPlansRepository ownerPlansRepository) {
        this.ownerPlansRepository = ownerPlansRepository;
    }

    @Override
    public List<OwnerPlans> getAllOwnerPlans() {
        return ownerPlansRepository.findAll();
    }

    @Override
    public OwnerPlans getOwnerPlansById(Long id) {
        Optional<OwnerPlans> optionalOwnerPlans = ownerPlansRepository.findById(id);
        return optionalOwnerPlans.orElse(null);
    }

    @Override
    public OwnerPlans createOwnerPlans(OwnerPlans ownerPlans) {
        return ownerPlansRepository.save(ownerPlans);
    }

    @Override
    public OwnerPlans updateOwnerPlans(Long id, OwnerPlans updatedOwnerPlans) {
        if (ownerPlansRepository.existsById(id)) {
            updatedOwnerPlans.setId(id);
            return ownerPlansRepository.save(updatedOwnerPlans);
        } else {
            return null; // Handle not found scenario
        }
    }

    @Override
    public void deleteOwnerPlans(Long id) {
        ownerPlansRepository.deleteById(id);
    }
}
