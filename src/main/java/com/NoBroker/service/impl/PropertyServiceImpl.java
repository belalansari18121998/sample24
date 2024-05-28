package com.NoBroker.service.impl;

import com.NoBroker.entity.Property;
import com.NoBroker.payload.PropertyDTO;
import com.NoBroker.repository.PropertyRepository;
import com.NoBroker.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PropertyServiceImpl implements PropertyService {

    private  PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property saveProperty(PropertyDTO propertyDTO) {
        Property property = mapToEntity(propertyDTO);
        property.setStatus("pending");
        return propertyRepository.save(property);
    }


   public Property mapToEntity(PropertyDTO propertyDTO){
       Property property = modelMapper.map(propertyDTO, Property.class);
       return property;
   }

    @Override
    public Property updatePropertyStatus(Long propertyId, String newStatus) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new EntityNotFoundException("Property not found with id: " + propertyId));

        property.setStatus(newStatus);
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId)
                .orElseThrow(() -> new EntityNotFoundException("Property not found with id: " + propertyId));
    }
}

