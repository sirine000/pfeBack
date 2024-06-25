package pfe.springboot.services.formateur;

import org.springframework.http.ResponseEntity;
import pfe.springboot.entities.Formateur;
import pfe.springboot.entities.cycle;

import java.util.List;
import java.util.Optional;

public interface formateurserviceInter {
    Formateur addformateur(Formateur f);

    String confirmdata(Formateur data);

    String confirmemail(Formateur email);



    Formateur updateProf(Long id_formateur, Formateur updateProf);

    //List<Formateur> listprof();

    Formateur userid(Long id_formateur, Formateur prof);

    Formateur affichnp(String np);

    List<Formateur> listesearch(String email);

    List<Formateur> nomprof(String nomEtPrenom);


    List<String> getnoms();

    void deleteformateur(Long id_formateur);

    ResponseEntity<Formateur> connecter(String nomEtPrenom, String password);

    Optional<cycle> getcycleid(Long idCycle);
}
