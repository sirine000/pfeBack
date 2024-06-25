package pfe.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*",originPatterns = "*")
@Entity
@Getter
@Setter
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

@Enumerated(EnumType.STRING)
    private  Role_name roleName;

    @JsonIgnore
@ManyToMany(mappedBy = "role" )
    private Set<utilisateurs>utilisateurs = new  HashSet<>();



}
