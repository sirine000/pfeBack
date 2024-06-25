package pfe.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.springboot.entities.Formateur;
import pfe.springboot.entities.cycle;
import pfe.springboot.services.cycleservices.cycleServImpl;
import pfe.springboot.services.cycleservices.cycleServInter;
import pfe.springboot.services.formateur.formateurServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cycle")
public class cycleControl {
    @Autowired
    cycleServInter cycleServInter;
@Autowired
cycleServImpl cycleServiceimpl ;
    @PostMapping(value = "/ajoutercycle")
    public cycle addcycle(@RequestBody cycle c) {
        return cycleServInter.ajoutercycle(c);
    }

    @DeleteMapping(value = "/deletecycle/{id_cycle}")
    public void delete(@PathVariable Long id_cycle) {
        cycleServInter.delete(id_cycle);
    }

@PostMapping(value = "/addlist")
 public List<cycle> addListCycle(@RequestBody List<cycle> CY){
        return cycleServInter.addListCycle(CY);
}


    @GetMapping(value = "listecycle")
    public List<cycle> listecycle(){
        return cycleServInter.listecycle();    }

    @Autowired
    formateurServiceImpl formateurServiceInter;

    @GetMapping(value = "/listenomprof")
    public List<String> Affichliste() {

        return formateurServiceInter.getnoms();
    }
/*@DeleteMapping(value = "suppCycle")
    public void cycle(){
        this.cycleServInter.supprimercycle();
    }*/

    @PostMapping("/ajouterbyid/{id_formateur}")
    public cycle creercycle_formateur(@PathVariable Long id_formateur, @RequestBody cycle cycle ){
        return cycleServInter.creercycle_formateurtessst(id_formateur,cycle);
    }

    @GetMapping("/getlistecycleid")
    public List<cycle> listecycleid(){
        return cycleServInter.listecycleid();
    }

//    @GetMapping("/getlistecycleid/{id_formateur}")
//    public List<cycle> listecycleidformateur(@PathVariable Long id_formateur){
//        return cycleServInter.listecycleidformateur(id_formateur);
//    }

    @PutMapping(value = "/modifiercycle/{id_cycle}")
    public cycle modifiercycle(@PathVariable Long id_cycle, @RequestBody cycle cyclemodifier) {
        return cycleServInter.modifiercycle(id_cycle, cyclemodifier);
    }


    @GetMapping(value="/getcycleid/{id_cycle}")
    public Optional<cycle> getcycleid(@PathVariable Long id_cycle){
        return cycleServInter.getcycleid(id_cycle);
    }


//    @GetMapping("/cycles/{idCycle}")
//    public ResponseEntity<cycle> getCycleById(@PathVariable Long idCycle) {
//        cycle cycle = cycleServiceimpl.getCycleById(idCycle);
//        if (cycle != null) {
//            return ResponseEntity.ok(cycle);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }




//
//    @GetMapping("/formateurs")
//    public List<Object[]> getCycleAndFormateurNames() {
//        return cycleServiceimpl.getCycleAndFormateurNames();
//    }


//    @GetMapping("/formateurstest")
//    public List<Object[]> getCycleAndFormateurNames() {
//        return cycleServiceimpl.getCycleformateur();
//    }
//
//    @PostMapping("/creer/{id_formateur}")
//    public cycle creerCycleFormateur(@PathVariable Long id_formateur, @RequestBody cycle cycle) {
//        return cycleServiceimpl.creercycle_formateur(id_formateur, cycle);
//    }

}
