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
public class BuyerPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double basePrice;
    private Double gstPercentage;
    private Integer numberOfContacts;
    private Boolean legalAssistance;
    private Boolean freeLoanAssistance;
    private Boolean freeInteriorDesignConsultation;

}
