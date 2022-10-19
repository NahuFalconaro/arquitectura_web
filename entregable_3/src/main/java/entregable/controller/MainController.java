package entregable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import entregable.service.IEstudianteService;

import entregable.model.Estudiante;



@RestController
public class MainController {

    @GetMapping("/")
    public String checkCarreraStatus() {
        return "OK!";
    }
    
}

