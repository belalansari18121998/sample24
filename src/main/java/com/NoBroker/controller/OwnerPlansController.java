package com.NoBroker.controller;

import com.NoBroker.entity.OwnerPlans;
import com.NoBroker.service.OwnerPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner-plans")
public class OwnerPlansController {

    private final OwnerPlansService ownerPlansService;

    @Autowired
    public OwnerPlansController(OwnerPlansService ownerPlansService) {
        this.ownerPlansService = ownerPlansService;
    }
    //http://localhost:8080/api/owner-plans
    @GetMapping
    public ResponseEntity<List<OwnerPlans>> getAllOwnerPlans() {
        List<OwnerPlans> ownerPlans = ownerPlansService.getAllOwnerPlans();
        return new ResponseEntity<>(ownerPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerPlans> getOwnerPlansById(@PathVariable Long id) {
        OwnerPlans ownerPlans = ownerPlansService.getOwnerPlansById(id);
        if (ownerPlans != null) {
            return new ResponseEntity<>(ownerPlans, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  //http://localhost:8080/api/owner-plans
    @PostMapping
    public ResponseEntity<OwnerPlans> createOwnerPlans(@RequestBody OwnerPlans ownerPlans) {
        OwnerPlans createdOwnerPlans = ownerPlansService.createOwnerPlans(ownerPlans);
        return new ResponseEntity<>(createdOwnerPlans, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerPlans> updateOwnerPlans(@PathVariable Long id, @RequestBody OwnerPlans updatedOwnerPlans) {
        OwnerPlans updatedPlan = ownerPlansService.updateOwnerPlans(id, updatedOwnerPlans);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnerPlans(@PathVariable Long id) {
        ownerPlansService.deleteOwnerPlans(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

