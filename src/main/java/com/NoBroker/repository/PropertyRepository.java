package com.NoBroker.repository;


import com.NoBroker.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByApartmentType(String apartmentType);

    List<Property> findByBhkTypeAndStatus(String bhkType, String status);

}