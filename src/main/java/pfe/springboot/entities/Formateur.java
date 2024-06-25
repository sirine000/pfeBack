package pfe.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter

public class Formateur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formateur;

   private String nomEtPrenom;

    private String email;
    private String password;

    private String confPassword;
    private Integer Tel;

//    @OneToOne
//    @JoinColumn(name = "utilisateur_id")
//    private utilisateurs utilisateurs;

@JsonIgnore
    @OneToMany(mappedBy ="formateur",cascade = CascadeType.ALL)


    private Set<cycle> cycle =new HashSet<>();

//@OneToMany(mappedBy ="formateur",cascade = CascadeType.ALL)
//@JsonBackReference
//
//private Set<cycle> cycle =new HashSet<>();




//    public String getNomEtPrenom() {
//        return nomEtPrenom;
//    }

}
