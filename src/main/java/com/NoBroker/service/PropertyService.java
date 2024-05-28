package com.NoBroker.service;

import com.NoBroker.entity.Property;
import com.NoBroker.payload.PropertyDTO;

public interface PropertyService {
    Property saveProperty(PropertyDTO propertyDTO);

    Property updatePropertyStatus(Long propertyId, String newStatus);
    Property getPropertyById(Long propertyId);
}

