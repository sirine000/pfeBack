package pfe.springboot.services.formateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pfe.springboot.entities.Formateur;
import pfe.springboot.entities.cycle;
import pfe.springboot.entities.role;
import pfe.springboot.entities.utilisateurs;
import pfe.springboot.repository.formateurRepository;
import pfe.springboot.repository.roleRepository;

import java.util.*;

@Service
public class formateurServiceImpl implements formateurserviceInter {
    @Autowired
    formateurRepository formateurRepository;


    @Override
    public Formateur addformateur(Formateur f) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(f.getPassword());
        f.setPassword(encryptedPassword);


        return formateurRepository.save(f);
    }

    @Override
    public String confirmdata(Formateur data)
    {
        String ch="";
        if(data.getPassword().equals(data.getConfPassword()) ) {
            formateurRepository.save(data);
            ch="enregistrement fait avec succès !";

        }else{ ch="vérifier le mot de passe !";}


        return ch ;

    }

    @Override
    public String confirmemail(Formateur email){
        String ch1 ="";
        if( formateurRepository.existsByEmail(email.getEmail())) {

            ch1 = "email exist!";
        }else {
            formateurRepository.save(email);
            ch1="enregistrement fait avec succées!";
    }
    return ch1 ;
}

    @Override
    public Formateur updateProf(Long id_formateur, Formateur updateProf) {
        Formateur ProfModifier= formateurRepository.findById(id_formateur ).get();
//        ProfModifier.setNomEtPrenom(updateProf.getNomEtPrenom());
        ProfModifier.setEmail(updateProf.getEmail());
        ProfModifier.setPassword(updateProf.getPassword());
        ProfModifier.setConfPassword(updateProf.getConfPassword());
        ProfModifier.setTel(updateProf.getTel());

        return formateurRepository.save(ProfModifier);
    }

  // @Override
    public ResponseEntity<Map> listprof() {
        Map map=new HashMap() ;
        List<Formateur> formateurs=formateurRepository.findAll();
       map.put("formateurmap" ,formateurs);
       map.put("message ","hello" );
        map.put("message2" ,12 );

        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    @Override
    public Formateur userid(Long id_formateur , Formateur prof) {
        return formateurRepository.findById(id_formateur ).orElse(null);
    }

    @Override
    public Formateur affichnp(String np) {
        return formateurRepository.findByNomEtPrenom(np);
    }

    @Override
    public List<Formateur> listesearch(String email) {
        return formateurRepository.userEmail(email);
    }

    @Override
    public List<Formateur>nomprof(String nomEtPrenom ) {
        return formateurRepository.findAll() ;   }



     @Override
    public List<String> getnoms() {
        List<String> nomsprof = new ArrayList<>();
        List<Formateur> formateurs = formateurRepository.findAll();
        for (Formateur formateur : formateurs) {
            nomsprof.add(formateur.getNomEtPrenom());
        }
        return nomsprof;
    }

    @Override
    public void deleteformateur(Long id_formateur ) {
        formateurRepository.deleteById(id_formateur );

    }

    @Override
    public ResponseEntity<Formateur> connecter(String nomEtPrenom, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
Formateur formateur=formateurRepository.findByNomEtPrenom(nomEtPrenom);
//if(formateur!=null && formateur.getPassword()==password)

        if(formateur!=null && passwordEncoder.matches(password,formateur.getPassword())){
            return ResponseEntity.ok(formateur); //message positif
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Override
    public Optional<cycle> getcycleid(Long idCycle) {
        return Optional.empty();
    }

}
