package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.propertymanagement.service.PropertyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
   public PropertyDto saveProperty(PropertyDto propertyDto) {

       /* PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDto.getTitle());
        pe.setAddress(propertyDto.getAddress());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());
        pe.setDescription(propertyDto.getDescription());
        we can use this getter and setter, but to make it more structural we are going to use converter for this changing purpose
        like the data is changing from dto to entity
        */

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDto);
        propertyRepository.save(pe); //we need entity to save the data., but now its in dto.., so take values from dto and store it in entity

        propertyDto = propertyConverter.converterEntityToDTO(pe);
        return propertyDto;
    }

    @Override
    public List<PropertyDto> getAllProperty() {

        List<PropertyEntity> listOfProps=  (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDto> dtoList = new ArrayList<>();

        for (PropertyEntity pe : listOfProps){
            PropertyDto dto = propertyConverter.converterEntityToDTO(pe);
            dtoList.add(dto); // create a obj for entity to pass into method., create obj for dto to store the method value.., but here
            //everthing is in list so converting obj to list and add into the list and return the list

        }
        return dtoList;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setTitle(propertyDto.getTitle());
            pe.setAddress(propertyDto.getAddress());
            pe.setOwnerName(propertyDto.getOwnerName());
            pe.setOwnerEmail(propertyDto.getOwnerEmail());
            pe.setDescription(propertyDto.getDescription());
            pe.setPrice(propertyDto.getPrice());
            dto = propertyConverter.converterEntityToDTO(pe);
            propertyRepository.save(pe);


        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyDesc(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setDescription(propertyDto.getDescription());
            dto = propertyConverter.converterEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
