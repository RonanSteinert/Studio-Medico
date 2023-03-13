package com.studiomedico.Studio.Medico.controllers;

import com.studiomedico.Studio.Medico.entities.Doctor;
import com.studiomedico.Studio.Medico.entities.Secretary;
import com.studiomedico.Studio.Medico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    private SecretaryRepository secretaryRepository;

    @PostMapping("/create")
    public Secretary createDoctor(@RequestBody Secretary secretary){
        return secretaryRepository.saveAndFlush(secretary);
    }
    @GetMapping("/get/{id}")
    public Optional<Secretary> getSecretaryById(@PathVariable Long id) {
        return secretaryRepository.findById(id);
    }
    @GetMapping("/getall")
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.findAll();
    }

}
