package com.entregable_3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.entregable_3.model.Estudiante;
import com.entregable_3.service.EstudianteService;
import com.entregable_3.service.IEstudianteService;

@RestController
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping("/student/new")
    public Estudiante newEstudent(@RequestBody Estudiante e) {
        return this.service.saveEstudiante(e);
    }
    
    @GetMapping("/students/{column}")
    public List<Estudiante> getOrdenadoByColumna(@PathVariable String column){
    	return this.service.getOrdenadoByColumna(column);
    }
    
    @GetMapping("/students/{genre}")
    public List<Estudiante> getAllByGenero(@PathVariable String genre){
    	return this.service.getAllByGenero(genre);
    }
    
    @GetMapping("/students/{idCarrera}")
    public List<Estudiante> getAllByCarreraId(@PathVariable Long idCarrera){
    	return this.service.getAllByCarreraId(idCarrera);
    }
    
    @GetMapping("/students/{idCarrera}/{city}")
    public List<Estudiante> getAllByCarreraYCiudad(@PathVariable Long idCarrera, @PathVariable String city){
    	return this.service.getAllByCarreraYCiudad(idCarrera, city);
    }
    
    @GetMapping("/students/{uid}")
    public Estudiante getByUID(@PathVariable int uid){
    	return this.service.getByLibreta(uid);
    }
    
    @GetMapping("/student/{id}")
    public Estudiante getById(@PathVariable Long id){
    	return this.service.getById(id);
    }
}

