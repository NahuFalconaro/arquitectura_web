package entregable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import entregable.service.IEstudianteService;

import entregable.model.Estudiante;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @PostMapping("/student/new")
    public Estudiante newEstudent(@RequestBody Estudiante e) {
        return service.saveEstudiante(e);
    }
    
    @GetMapping("/students/{column}")
    public List<Estudiante> getOrdenadoByColumna(@PathVariable String column){
    	return service.getOrdenadoByColumna(column);
    }
    
    @GetMapping("/students/{genre}")
    public List<Estudiante> getAllByGenero(@PathVariable String genre){
    	return service.getAllByGenero(genre);
    }
    
    @GetMapping("/students/{idCarrera}")
    public List<Estudiante> getAllByCarreraId(@PathVariable Long idCarrera){
    	return service.getAllByCarreraId(idCarrera);
    }
    
    @GetMapping("/students/{idCarrera}/{city}")
    public List<Estudiante> getAllByCarreraYCiudad(@PathVariable Long idCarrera, @PathVariable String city){
    	return service.getAllByCarreraYCiudad(idCarrera, city);
    }
    
    @GetMapping("/students/{uid}")
    public Estudiante getByUID(@PathVariable int uid){
    	return service.getByLibreta(uid);
    }
    
    @GetMapping("/student/{id}")
    public Estudiante getById(@PathVariable Long id){
    	return service.getById(id);
    }
}

