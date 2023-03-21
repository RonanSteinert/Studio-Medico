package com.studiomedico.controllers;

import com.studiomedico.entities.Secretary;
import com.studiomedico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    private SecretaryRepository secretaryRepository;

    @PostMapping("/newsecretary")
    public Secretary createDoctor(@RequestBody Secretary secretary){
        return secretaryRepository.saveAndFlush(secretary);
    }
    @GetMapping("/secretarybyid/{id}")
    public Optional<Secretary> getSecretaryById(@PathVariable Long id) {
        return secretaryRepository.findById(id);
    }
    @GetMapping("/allsecretary")
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.findAll();
    }

}
