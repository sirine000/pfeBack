package pfe.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.springboot.entities.cours;
import pfe.springboot.services.cours.coursInter;

@RestController
@RequestMapping(value="/cours")
@CrossOrigin(origins = "http://localhost:4200")

public class coursControl {
    @Autowired
    coursInter coursInter;
    @PostMapping(value="/postcours")
    public cours adddcours(@RequestBody cours Vcours){
        return coursInter.addcours(Vcours);
    }

}
