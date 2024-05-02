package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDto propertyDto){

        PropertyEntity pe = new PropertyEntity();
        pe.setId(propertyDto.getId());
        pe.setTitle(propertyDto.getTitle());
        pe.setAddress(propertyDto.getAddress());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());
        pe.setDescription(propertyDto.getDescription());
        pe.setPrice(propertyDto.getPrice());

        return pe;
    }

    public PropertyDto converterEntityToDTO(PropertyEntity propertyEntity){

        PropertyDto dto = new PropertyDto();
        dto.setId(propertyEntity.getId());
        dto.setTitle(propertyEntity.getTitle());
        dto.setAddress(propertyEntity.getAddress());
        dto.setOwnerName(propertyEntity.getOwnerName());
        dto.setOwnerEmail(propertyEntity.getOwnerEmail());
        dto.setDescription(propertyEntity.getDescription());
        dto.setPrice(propertyEntity.getPrice());

        return dto;
    }

}

