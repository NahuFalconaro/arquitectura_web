package entregable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import entregable.model.Carrera;

import entregable.service.ICarreraService;

import io.swagger.annotations.Api;


@RestController
public class CarreraController {

    @Autowired
    private ICarreraService service;

    @GetMapping("/")
    public String checkCarreraStatus() {
        return "OK Carrera 200!";
    }

    @GetMapping("/career/{id}")
    public Carrera getCareerById(@PathVariable Long id) {
    	return service.getById(id);
    }

    @GetMapping("/career/{name}")
    public Carrera getCareerByName(@PathVariable String name) {
    	return service.getByName(name);
    }

    @PostMapping("/career/new")
    public Carrera newCareer(@RequestBody Carrera c) {
        return service.saveCarrera(c);
    }

    @GetMapping("/career")
    List<Carrera> getAllWithStudentsOrderByCantInscriptos() {
    	return service.getAllWithStudentsOrderByCantInscriptos();
    }


}

