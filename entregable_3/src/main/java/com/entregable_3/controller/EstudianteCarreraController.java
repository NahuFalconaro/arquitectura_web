package com.entregable_3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;
import com.entregable_3.model.EstudianteCarrera;
import com.entregable_3.service.EstudianteCarreraService;
import com.entregable_3.service.IEstudianteCarreraService;

@RestController
public class EstudianteCarreraController {

    @Autowired
    private EstudianteCarreraService ecs;

    @PostMapping("/studentcarrer/new")
    public EstudianteCarrera newCareer(@RequestBody EstudianteCarrera ec) {
        return this.ecs.saveEstudianteCarrera(ec);
    }
    
    @GetMapping("/studentcarrer/report")
    TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport() {
    	return this.ecs.getReport();
    }
}

