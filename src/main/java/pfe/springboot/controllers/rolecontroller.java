package pfe.springboot.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.springboot.entities.role;
import pfe.springboot.services.role.roleServiceInter;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:4200")

public class rolecontroller {
    @Autowired
    roleServiceInter  roleServiceInter;

    @PostMapping( "/roleadd")
    public role ajouterrole(@RequestBody role roles){
        return  roleServiceInter.ajouterRole(roles);
    }
}
