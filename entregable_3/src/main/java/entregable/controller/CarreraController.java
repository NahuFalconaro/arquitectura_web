package entregable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import entregable.model.CareerWithInscripts;
import entregable.model.Carrera;
import entregable.service.CarreraService;
import entregable.service.ICarreraService;



@RestController
public class CarreraController {

    @Autowired
    private CarreraService service;

    @GetMapping("/career/{id}")
    public Carrera getCareerById(@PathVariable Long id) {
    	return service.getById(id);
    }

    @GetMapping("/career/search/{name}")
    public Carrera getCareerByName(@PathVariable String name) {
    	return service.getByName(name);
    }

    @PostMapping("/career/new")
    public Carrera newCareer(@RequestBody Carrera c) {
        return service.saveCarrera(c);
    }

    @GetMapping("/career")
    List<CareerWithInscripts> getAllWithStudentsOrderByCantInscriptos() {
    	return service.getAllWithStudentsOrderByCantInscriptos();
    }


}

