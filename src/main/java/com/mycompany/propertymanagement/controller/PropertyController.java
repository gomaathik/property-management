package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.service.PropertyService;
import jakarta.servlet.ServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("$(pms.dummy)")
    private String dummy;

    @Autowired
      private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        System.out.println(dummy);
        return "Hello";
    }

    @PostMapping("/properties") //postmapping is used not only pass the request also for the response return, so after the converter
                                //created it come here.

    //public PropertyDto saveProperty(@RequestBody PropertyDto propertyDto){
        //propertyService.saveProperty(propertyDto);
       // System.out.println(propertyDto);
        //return propertyDto;

    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto){ //if we r create the method then we have to create same method in service too., like saveProperty
        System.out.println(dummy);
        propertyDto = propertyService.saveProperty(propertyDto); //changing this line because after propertydto save we are transfer the entity data in it., so creating the same obj
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperty(){ //create it in service too,
        System.out.println(dummy);
        List<PropertyDto> propertyList = propertyService.getAllProperty();  //we have taking it from service.,now from service-implement to repository connection has to made
            ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK); //what ever we r creating in this line will be method return type to.., example :: ResponseEntity<List<PropertyDto>>3
            return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public PropertyDto updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId){
        //propertyDto = propertyService.updateProperty(propertyDto,propertyId);
        return propertyService.updateProperty(propertyDto,propertyId); //instead of using response entity in the seperate variable, its returning directly
    }

    @PatchMapping("/properties/update-desc/{propertyId}")
    public PropertyDto updatePropertyDesc(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId){
       return propertyService.updatePropertyDesc(propertyDto,propertyId);
    }

    @DeleteMapping("/properties/{propertyId}")
    public void deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
    }
}
