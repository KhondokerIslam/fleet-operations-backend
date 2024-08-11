package com.example.BackendFleetOperations.enums.service;

import com.example.BackendFleetOperations.enums.response.EnumDTO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnumService {


    public List<EnumDTO> getEnumList(String enumName) throws Exception {

        List<EnumDTO> enumList = new ArrayList<>();

        String enumClass = "com.example.BackendFleetOperations.enums." + enumName;

        Class<?> className = Class.forName( enumClass );

        for( Object obj : className.getEnumConstants() ){

            EnumDTO enumDTO = new EnumDTO();

            Field valueField = obj.getClass().getDeclaredField("value");

            valueField.setAccessible(true);
            Object value = valueField.get(obj);

            enumDTO.setValue( (Integer) value );

            Field labelClass = obj.getClass().getDeclaredField( "label" );
            labelClass.setAccessible( true );
            Object label = labelClass.get(obj);

            enumDTO.setLabel( (String) label );

            enumList.add(enumDTO);
        }

        return enumList;
    }
}
