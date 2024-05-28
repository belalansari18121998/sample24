package com.NoBroker.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long propertyId;
    private String apartmentType;
    private String bhkType;
    private int floor;
    private int totalFloor;
    private int propertyAge;
    private String facing;
    private double builtUpArea;
    private String status;
}

