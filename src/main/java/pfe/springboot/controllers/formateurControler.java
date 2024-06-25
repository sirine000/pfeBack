package pfe.springboot.controllers;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.springboot.entities.Formateur;
import pfe.springboot.entities.cycle;
import pfe.springboot.services.formateur.formateurServiceImpl;
import pfe.springboot.services.formateur.formateurserviceInter;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/formateur")
public class formateurControler {
    @Autowired
    formateurserviceInter formateurServiceInter;

    @PostMapping(value = "/ajouterformateur")
    public Formateur addformateur(@RequestBody Formateur F) {
        return formateurServiceInter.addformateur(F);

    }


    @GetMapping("/seconnecter")
    public ResponseEntity<Formateur> connecter(@RequestParam String nomEtPrenom,@RequestParam String password){
        return  formateurServiceInter.connecter(nomEtPrenom,password);
    }



    @PostMapping(value = "/confirmdata")
    public String confirmdata(@RequestBody Formateur data) {
        return formateurServiceInter.confirmdata(data);

    }

    @PostMapping(value = "/confirmemail")
    public String emailConf(@RequestBody Formateur email) {
        return formateurServiceInter.confirmemail(email);
    }

    @PutMapping(value = "/updateEmail/{id_formateur}")
    public Formateur updateFormateur(@PathVariable Long id_formateur, @RequestBody Formateur updateProf) {
        return formateurServiceInter.updateProf(id_formateur, updateProf);
    }
@Autowired
formateurServiceImpl formateurservice;
    @GetMapping(value = "/listeFormateur")
    public ResponseEntity<Map> Affichlist(Formateur ProfList) {
        return formateurservice.listprof();
    }

    @GetMapping(value = "/userid/{id_formateur}")
    public Formateur userid(@PathVariable Long id_formateur, Formateur Prof) {
        return formateurServiceInter.userid(id_formateur, Prof);


    }


    @GetMapping(value = "/nomPrenom/{np}")
    public Formateur AffichNP(@PathVariable String np) {
        return formateurServiceInter.affichnp(np);
    }

    @GetMapping(value = "/search/{email}")
    public List<Formateur> listesearch(@PathVariable String email) {
        return formateurServiceInter.listesearch(email);
    }


    /*  @GetMapping(value = "/listenomprof")
      public List<Formateur> Affichliste(String nomEtPrenom) {
          return formateurServiceInter.listprof();
      }*/
    @GetMapping(value = "/listenomprof")
    public List<String> Affichliste() {
        return formateurServiceInter.getnoms();
    }

    @DeleteMapping(value = "/del/{id_formateur}")
    public void deleteformateur(@PathVariable Long id_formateur) {
        formateurServiceInter.deleteformateur(id_formateur);
    }


    @PutMapping(value = "/modifierformateur/{id_formateur}")
    public Formateur updateprof(@PathVariable Long id_formateur, @RequestBody Formateur formateurmodifier) {
       return formateurServiceInter.updateProf(id_formateur, formateurmodifier);
    }
    @GetMapping(value="/getcycleid/{id_cycle}")
    public Optional<cycle> getformateurteurbid(@PathVariable Long id_cycle){
        return formateurServiceInter.getcycleid(id_cycle);
    }




}

