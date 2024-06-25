package pfe.springboot.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cycle")
    private Long id_cycle;
  
private String nom_cycle_de_formation ;

    private String description;
    private Long prix;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFin;

//
@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_formateur")


  private  Formateur formateur;
//private String nomEtPrenom;


//    @Override
//    public String getNomEtPrenom() {
//        return super.getNomEtPrenom();
//    }

//    private Boolean present;


}
