package com.NoBroker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String benefits;
    private Boolean guaranteedBuyersOrMoneyback;
    private Boolean personalFieldAssistant;
    private Boolean propertyPromotionOnSite;
    private Boolean relationshipManager;
    private Boolean facebookMarketingOfProperty;
    private Boolean privacyOfPhoneNumber;
    private Boolean showingPropertyOnYourBehalf;
    private Boolean photoshootOfProperty;
    private String planValidity;
}

