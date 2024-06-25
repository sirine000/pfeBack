package pfe.springboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class utilisateurs {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_utilisateur;

        private String nom_Prenom;

        private String email;
        private String password;
        private String confPassword;
        private Integer Tel;

      //  @OneToOne(mappedBy = "utilisateur")
     //   private Formateur formateur;

        //@OneToOne(mappedBy = "utilisateur")
       // private Participant participant;


        @ManyToMany
        @JoinTable (name="utilisateurEtRole" ,joinColumns = @JoinColumn(name="id_utilisateur"),inverseJoinColumns=@JoinColumn(name = "id_role"))
        private Set<role> role=new HashSet<>();
    }



