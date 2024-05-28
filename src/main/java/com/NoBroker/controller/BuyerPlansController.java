package com.NoBroker.controller;

import com.NoBroker.entity.BuyerPlans;
import com.NoBroker.service.BuyerPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyer-plans")
public class BuyerPlansController {

    private final BuyerPlansService buyerPlansService;

    @Autowired
    public BuyerPlansController(BuyerPlansService buyerPlansService) {
        this.buyerPlansService = buyerPlansService;
    }

    @GetMapping
    public ResponseEntity<List<BuyerPlans>> getAllBuyerPlans() {
        List<BuyerPlans> buyerPlans = buyerPlansService.getAllBuyerPlans();
        return new ResponseEntity<>(buyerPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyerPlans> getBuyerPlansById(@PathVariable Long id) {
        BuyerPlans buyerPlans = buyerPlansService.getBuyerPlansById(id);
        if (buyerPlans != null) {
            return new ResponseEntity<>(buyerPlans, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //http://localhost:8080/api/buyer-plans
    @PostMapping
    public ResponseEntity<BuyerPlans> createBuyerPlans(@RequestBody BuyerPlans buyerPlans) {
        BuyerPlans createdBuyerPlans = buyerPlansService.createBuyerPlans(buyerPlans);
        return new ResponseEntity<>(createdBuyerPlans, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuyerPlans> updateBuyerPlans(@PathVariable Long id, @RequestBody BuyerPlans updatedBuyerPlans) {
        BuyerPlans updatedPlan = buyerPlansService.updateBuyerPlans(id, updatedBuyerPlans);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerPlans(@PathVariable Long id) {
        buyerPlansService.deleteBuyerPlans(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

