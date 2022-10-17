package com.entregable_3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import com.entregable_3.model.Carrera;
import com.entregable_3.service.CarreraService;
import com.entregable_3.service.ICarreraService;

@RestController
public class CarreraController {

    @Autowired
    private CarreraService cs;

    @GetMapping("/")
    public String checkCarreraStatus() {
        return "OK Carrera 200!";
    }

    @GetMapping("/career/{id}")
    public Carrera getCareerById(@PathVariable Long id) {
    	return this.cs.getById(id);
    }

    @GetMapping("/career/{name}")
    public Carrera getCareerByName(@PathVariable String name) {
    	return this.cs.getByName(name);
    }

    @PostMapping("/career/new")
    public Carrera newCareer(@RequestBody Carrera c) {
        return this.cs.saveCarrera(c);
    }

    @GetMapping("/career")
    List<Carrera> getAllWithStudentsOrderByCantInscriptos() {
    	return this.cs.getAllWithStudentsOrderByCantInscriptos();
    }


}

