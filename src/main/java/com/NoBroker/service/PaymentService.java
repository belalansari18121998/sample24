package com.NoBroker.service;

import com.stripe.exception.StripeException;

public interface PaymentService {
    public String createPaymentIntent(double amount) throws StripeException;
}
