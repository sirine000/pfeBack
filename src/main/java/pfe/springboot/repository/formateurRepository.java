package pfe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pfe.springboot.entities.Formateur;
import pfe.springboot.entities.cycle;

import java.util.List;
import java.util.Optional;

@Repository
public interface formateurRepository extends JpaRepository<Formateur,Long> {


    boolean existsByEmail(String email);


    Formateur findByNomEtPrenom(String nomEtPrenom);


   @Query(value = "select * from Formateur fé  where f.email like :cle%",nativeQuery = true)
 List<Formateur> userEmail(@Param("cle") String email);


   // Optional<Formateur> findByn(String nomEtPrenom);
}