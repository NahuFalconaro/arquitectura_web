package com.entregable_3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.entregable_3.model.Carrera;
import com.entregable_3.repository.CarreraRepository;

@RestController
@RequestMapping("persons")
@Api(value = "PersonControllerJpa", description = "REST API Person description")
public class CarreraController {

    @Qualifier("EstudianteCarreraRepository")
    @Autowired
    private final CarreraRepository repository;

    public CarreraController(@Qualifier("CarreraRepository") CarreraRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String checkCarreraStatus() {
        return "OK Carrera 200!";
    }

    @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/BySurname/{surname}")
    public Iterable<Carrera> getPersonsBySurname(@PathVariable String surname) {
      //  return repository.findAllBySurname(surname);
    	return null;
    }

    @GetMapping("/ByName/{name}")
    public Iterable<Carrera> getPersonsByName(@PathVariable String name) {
      //  return repository.findAllByName(name);
    	return null;
    }

    @PostMapping("/")
    public Carrera newPerson(@RequestBody Carrera p) {
        //return repository.save(p);
        return null;
    }

    @ApiOperation(value = "Get specific Person in the System ", response = Carrera.class, tags = "getPerson")
    @RequestMapping(value = "/getPerson/{name}")
    public Carrera getPerson(@PathVariable(value = "name") String name) {
        //return repository.findAllByName(name).get(0);
    	return null;
    }
    @GetMapping("/{id}")
    Optional<Carrera> one(@PathVariable Long id) {
        //return repository.findById(id);
    	return null;
    }

    @PutMapping("/{id}")
    Carrera replacePerson(@RequestBody Carrera newPerson, @PathVariable Long id) {
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

