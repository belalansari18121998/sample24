package com.NoBroker.controller;

import com.NoBroker.entity.Property;
import com.NoBroker.payload.PropertyDTO;
import com.NoBroker.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private  PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    //http://localhost:8080/api/properties/add

    @PostMapping("/add")
    public ResponseEntity<Property> addProperty(@RequestBody PropertyDTO propertyDTO) {
        try {
            Property savedProperty = propertyService.saveProperty(propertyDTO);
            return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  //PATCH http://localhost:8080/api/properties/updateStatus/1?newStatus=Approved
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/updateStatus/{propertyId}")
    public ResponseEntity<Property> updatePropertyStatus(
            @PathVariable Long propertyId,
            @RequestParam String newStatus) {
        try {
            Property updatedProperty = propertyService.updatePropertyStatus(propertyId, newStatus);
            return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/api/properties/propertyId
    @GetMapping("/{propertyId}")
    public ResponseEntity<Object> getPropertyById(@PathVariable Long propertyId) {
        try {
            Property property = propertyService.getPropertyById(propertyId);

            // Check if the status is "Approved" before returning the property data
            if ("Approved".equals(property.getStatus())) {
                return new ResponseEntity<>(property, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Access denied. Property status must be Approved", HttpStatus.FORBIDDEN);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Property not found with id: " + propertyId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
