package pfe.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.springboot.entities.participant;
import pfe.springboot.services.userServicesinter;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class participantControler {
    @Autowired
    userServicesinter userServicesinter;


    @PostMapping(value = "/add")
    public participant addUser(@RequestBody participant user) {
        return userServicesinter.addUser(user);
    }


    @GetMapping(value = "/listeParticipant")
    public List<participant> getAllUser(){
            List<participant> liste =userServicesinter.getAllUser();
            return liste ;
    }
    /*@DeleteMapping(value = "/deleteuser")
    public void deleteuser(){
        userServicesinter.deleteuser(user );
    }*/


}