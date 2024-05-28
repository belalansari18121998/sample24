package com.NoBroker.controller;

import com.NoBroker.entity.Plan;
import com.NoBroker.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    private PlanService planService;


 //http://localhost:8080/api/plans/create
    @PostMapping("/create")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        try {
            Plan createdPlan = planService.createPlan(plan);
            return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //http://localhost:8080/api/plans/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Plan>> getAllPlans() {
        try {
            List<Plan> plans = planService.getAllPlans();
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{planId}")
    public ResponseEntity<?> getPlanById(@PathVariable long planId) {
        try {
            Plan plan = planService.getPlanById(planId);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Plan not found with id: " + planId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{planId}")
    public ResponseEntity<?> updatePlan(@PathVariable long planId, @RequestBody Plan updatedPlan) {
        try {
            Plan plan = planService.updatePlan(planId, updatedPlan);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Plan not found with id: " + planId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable long planId) {
        try {
            planService.deletePlan(planId);
            return new ResponseEntity<>("Plan deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Plan not found with id: " + planId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

