package com.entregable_3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.entregable_3.model.EstudianteCarrera;
import com.entregable_3.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiante")
@Api(value = "EstudianteController", description = "REST API Person description")
public class EstudianteController {

    @Qualifier("EstudianteRepository")
    @Autowired
    private final EstudianteRepository repository;

    public EstudianteController(@Qualifier("EstudianteRepository") EstudianteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<EstudianteCarrera> getEstudiante() {
       // return repository.findAll();
        return null;
    }

    @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/BySurname/{surname}")
    public Iterable<EstudianteCarrera> getPersonsBySurname(@PathVariable String surname) {
      //  return repository.findAllBySurname(surname);
    	return null;
    }

    @GetMapping("/ByName/{name}")
    public Iterable<EstudianteCarrera> getPersonsByName(@PathVariable String name) {
      //  return repository.findAllByName(name);
    	return null;
    }

    @PostMapping("/")
    public EstudianteCarrera newPerson(@RequestBody EstudianteCarrera p) {
        //return repository.save(p);
        return null;
    }

    @ApiOperation(value = "Get specific Person in the System ", response = EstudianteCarrera.class, tags = "getPerson")
    @RequestMapping(value = "/getPerson/{name}")
    public EstudianteCarrera getPerson(@PathVariable(value = "name") String name) {
        //return repository.findAllByName(name).get(0);
    	return null;
    }
    @GetMapping("/{id}")
    Optional<EstudianteCarrera> one(@PathVariable Long id) {
        //return repository.findById(id);
    	return null;
    }

    @PutMapping("/{id}")
    EstudianteCarrera replacePerson(@RequestBody EstudianteCarrera newPerson, @PathVariable Long id) {
    	return null;
//        return repository.findById(id)
//                .map(person -> {
//                    person.setName(newPerson.getName());
//                    person.setSurname(newPerson.getSurname());
//                    return repository.save(person);
//                })
//                .orElseGet(() -> {
//                    newPerson.setDni(id);
//                    return repository.save(newPerson);
//                });
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Long id) {
        //repository.deleteById(id);
    }
}

