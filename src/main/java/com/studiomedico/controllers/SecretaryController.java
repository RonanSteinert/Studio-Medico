package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.SecretaryRequestDTO;
import com.studiomedico.controllers.DTO.SecretaryResponseDTO;
import com.studiomedico.entities.Secretary;
import com.studiomedico.repositories.SecretaryRepository;
import com.studiomedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
