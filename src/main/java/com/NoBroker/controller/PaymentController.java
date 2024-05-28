package com.NoBroker.controller;

import com.NoBroker.entity.*;
import com.NoBroker.repository.*;
import com.NoBroker.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PlanRepository planRepo;

    @Autowired
    private TenantPlanRepository tenantPlanRepository;

    @Autowired
    private OwnerPlansRepository ownerPlansRepository;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BuyerPlansRepository buyerPlansRepository;

    @Autowired
    private SellerPlansRepository sellerPlansRepository;


  //http://localhost:8080/api/payments/purchasePlan
    @PostMapping("/purchasePlan")
    public ResponseEntity<String> createPaymentIntent(@RequestParam Long id) {
        try {
            Plan plan = planRepo.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Plan with Id Not Found"));

            String paymentIntentId = paymentService.createPaymentIntent(plan.getPrice());
            return ResponseEntity.ok("PaymentId= " + paymentIntentId); // Return the PaymentIntent object directly
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Plan not found
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(e.getMessage()); // StripeException
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error"); // Other exceptions
        }
    }

    //http://localhost:8080/api/payments/tenantplan
    @PostMapping("/tenantplan")
    public ResponseEntity<String> createPayment(@RequestParam Long id) {
        try {
            TenantPlan tenantPlan = tenantPlanRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Plan with Id Not Found"));

            String paymentIntentId = paymentService.createPaymentIntent(tenantPlan.getBasePrice());
            return ResponseEntity.ok("PaymentId= " + paymentIntentId); // Return the PaymentIntent object directly
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Plan not found
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(e.getMessage()); // StripeException
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error"); // Other exceptions
        }
    }

    //http://localhost:8080/api/payments/ownerplan
    @PostMapping("/ownerplan")
    public ResponseEntity<String> createPaymentOwner(@RequestParam Long id) {
        try {
            OwnerPlans ownerPlans = ownerPlansRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Plan with Id Not Found"));

            String paymentIntentId = paymentService.createPaymentIntent(ownerPlans.getBasePrice());
            return ResponseEntity.ok("PaymentId= " + paymentIntentId); // Return the PaymentIntent object directly
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Plan not found
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(e.getMessage()); // StripeException
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error"); // Other exceptions
        }
    }

    //http://localhost:8080/api/payments/buyerplans
    @PostMapping("/buyerplans")
    public ResponseEntity<String> createPaymentBuyerPlans(@RequestParam Long id) {
        try {
            BuyerPlans buyerPlans = buyerPlansRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Plan with Id Not Found"));

            String paymentIntentId = paymentService.createPaymentIntent(buyerPlans.getBasePrice());
            return ResponseEntity.ok("PaymentId= " + paymentIntentId); // Return the PaymentIntent object directly
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Plan not found
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(e.getMessage()); // StripeException
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error"); // Other exceptions
        }
    }

    //http://localhost:8080/api/payments/sellerPlans
    @PostMapping("/sellerPlans")
    public ResponseEntity<String> createPaymentSellerPlans(@RequestParam Long id) {
        try {
            SellerPlans sellerPlans = sellerPlansRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Plan with Id Not Found"));

            String paymentIntentId = paymentService.createPaymentIntent(sellerPlans.getPrice());
            return ResponseEntity.ok("PaymentId= " + paymentIntentId); // Return the PaymentIntent object directly
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Plan not found
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(e.getMessage()); // StripeException
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error"); // Other exceptions
        }
    }
}
