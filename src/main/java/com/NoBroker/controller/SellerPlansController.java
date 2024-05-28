package com.NoBroker.controller;

import com.NoBroker.entity.SellerPlans;
import com.NoBroker.service.SellerPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller-plans")
public class SellerPlansController {

    private final SellerPlansService sellerPlansService;

    @Autowired
    public SellerPlansController(SellerPlansService sellerPlansService) {
        this.sellerPlansService = sellerPlansService;
    }

    @GetMapping
    public ResponseEntity<List<SellerPlans>> getAllSellerPlans() {
        List<SellerPlans> sellerPlans = sellerPlansService.getAllSellerPlans();
        return new ResponseEntity<>(sellerPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerPlans> getSellerPlansById(@PathVariable Long id) {
        SellerPlans sellerPlans = sellerPlansService.getSellerPlansById(id);
        if (sellerPlans != null) {
            return new ResponseEntity<>(sellerPlans, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   //http://localhost:8080/api/seller-plans
    @PostMapping
    public ResponseEntity<SellerPlans> createSellerPlans(@RequestBody SellerPlans sellerPlans) {
        SellerPlans createdSellerPlans = sellerPlansService.createSellerPlans(sellerPlans);
        return new ResponseEntity<>(createdSellerPlans, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellerPlans> updateSellerPlans(@PathVariable Long id, @RequestBody SellerPlans updatedSellerPlans) {
        SellerPlans updatedPlan = sellerPlansService.updateSellerPlans(id, updatedSellerPlans);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSellerPlans(@PathVariable Long id) {
        sellerPlansService.deleteSellerPlans(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

