package com.NoBroker.service.impl;

import com.NoBroker.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentSeviceImpl implements PaymentService {
    @Value("${stripe.secretKey}")
    private String stripeSecretKey;

    @Override
    public String createPaymentIntent(double amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;

        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount((long)(amount * 100))
                .setCurrency("INR")
                .build();
        try {
            PaymentIntent paymentIntent = PaymentIntent.create(createParams);
            return paymentIntent.getId(); // Return the PaymentIntent object
        } catch (StripeException e) {
            throw new RuntimeException("Error creating payment intent");
        }
    }
}