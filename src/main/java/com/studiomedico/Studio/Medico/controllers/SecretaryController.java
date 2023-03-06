package com.studiomedico.Studio.Medico.controllers;

import com.studiomedico.Studio.Medico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    private SecretaryRepository secretaryRepository;

}
