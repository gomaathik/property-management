package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDto;

import java.util.List;

public interface PropertyService {

   // public PropertyDto saveProperty(PropertyDto propertyDto); //from controller to here.., this is one way of creating
    PropertyDto saveProperty(PropertyDto propertyDto); //this way is also do
    List<PropertyDto> getAllProperty(); //after this goes to service implement., there it will ask to create a method for getAllProperty
    PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId);

    PropertyDto updatePropertyDesc(PropertyDto propertyDto, Long propertyId);

    void deleteProperty(Long propertyId);
}
