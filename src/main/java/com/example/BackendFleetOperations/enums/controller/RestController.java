package com.example.BackendFleetOperations.enums.controller;

import com.example.BackendFleetOperations.enums.response.EnumDTO;
import com.example.BackendFleetOperations.enums.service.EnumService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;

@org.springframework.web.bind.annotation.RestController
@RequestMapping( "/api" )
@RequiredArgsConstructor( onConstructor = @__(@Autowired) )
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class RestController {

    private final EnumService enumService;

    @PostMapping( "/enum" )
    public ResponseEntity<?> getEnumList(
            @RequestBody Object enumName,
            HttpServletRequest httpServletRequest
    ) throws Exception {

        List<EnumDTO> enumDTOList = enumService.getEnumList( enumName.toString() );

        return new ResponseEntity<>(enumDTOList, ACCEPTED);
    }
}
