package entregable .controller;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import entregable.model.EstudianteCarrera;


import entregable.model.Carrera;
import entregable.model.Estudiante;
import entregable.service.EstudianteCarreraService;
import entregable.service.IEstudianteCarreraService;

@RestController
public class EstudianteCarreraController {

    @Autowired
    private EstudianteCarreraService service;

    @PostMapping("/studentcarrer/new")
    public EstudianteCarrera newCareer(@RequestBody EstudianteCarrera ec) {
        return service.saveEstudianteCarrera(ec);
    }
    
    @GetMapping("/studentcarrer/report")
    TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport() {
    	return service.getReport();
    }
}

