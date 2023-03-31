package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.SecretaryRequestDTO;
import com.studiomedico.controllers.DTO.SecretaryResponseDTO;
import com.studiomedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    private SecretaryService secretaryService;

    @PostMapping("/new")
    public SecretaryResponseDTO postSecretary(@RequestBody SecretaryRequestDTO secretaryRequestDTO){
        return secretaryService.postSecretary(secretaryRequestDTO);
    }


}
