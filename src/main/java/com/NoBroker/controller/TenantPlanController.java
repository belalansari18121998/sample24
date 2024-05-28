package com.NoBroker.controller;

import com.NoBroker.entity.TenantPlan;
import com.NoBroker.service.TenantPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenant-plans")
public class TenantPlanController {

    private TenantPlanService tenantPlanService;

    @Autowired
    public TenantPlanController(TenantPlanService tenantPlanService) {
        this.tenantPlanService = tenantPlanService;
    }
  //http://localhost:8080/api/tenant-plans
    @GetMapping
    public ResponseEntity<List<TenantPlan>> getAllTenantPlans() {
        List<TenantPlan> tenantPlans = tenantPlanService.getAllTenantPlans();
        return new ResponseEntity<>(tenantPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantPlan> getTenantPlanById(@PathVariable Long id) {
        TenantPlan tenantPlan = tenantPlanService.getTenantPlanById(id);
        if (tenantPlan != null) {
            return new ResponseEntity<>(tenantPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  //http://localhost:8080/api/tenant-plans
    @PostMapping
    public ResponseEntity<TenantPlan> createTenantPlan(@RequestBody TenantPlan tenantPlan) {
        TenantPlan createdTenantPlan = tenantPlanService.createTenantPlan(tenantPlan);
        return new ResponseEntity<>(createdTenantPlan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TenantPlan> updateTenantPlan(@PathVariable Long id, @RequestBody TenantPlan updatedTenantPlan) {
        TenantPlan updatedPlan = tenantPlanService.updateTenantPlan(id, updatedTenantPlan);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTenantPlan(@PathVariable Long id) {
        tenantPlanService.deleteTenantPlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

