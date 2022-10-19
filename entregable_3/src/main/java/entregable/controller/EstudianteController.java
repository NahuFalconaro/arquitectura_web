package entregable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.*;
import org.springframework.web.bind.annotation.*;

import entregable.service.EstudianteService;
import entregable.service.IEstudianteService;
import entregable.model.Estudiante;



@RestController
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping("/student/new")
    public Estudiante newEstudent(@RequestBody Estudiante e) {
        return service.saveEstudiante(e);
    }
    
    @GetMapping("/student/orderbyname")
    public List<Estudiante> getOrdenadoByName(){
    	return service.getOrdenadoByNombre();
    }
    
    @GetMapping("/student/bygenre/{genre}")
    public List<Estudiante> getAllByGenero(@PathVariable String genre){
    	return service.getAllByGenero(genre);
    }
    
    @GetMapping("/student/bycarrera/{idCarrera}")
    public List<Estudiante> getAllByCarreraId(@PathVariable Long idCarrera){
    	return service.getAllByCarreraId(idCarrera);
    }
    
    @GetMapping("/student/{idCarrera}/{city}")
    public List<Estudiante> getAllByCarreraYCiudad(@PathVariable Long idCarrera, @PathVariable String city){
    	return service.getAllByCarreraYCiudad(idCarrera, city);
    }
    
    @GetMapping("/student/bylibreta/{uid}")
    public Estudiante getByUID(@PathVariable int uid){
    	return service.getByLibreta(uid);
    }
    
    @GetMapping("/student/{id}")
    public Estudiante getById(@PathVariable Long id){
    	return service.getById(id);
    }
}

