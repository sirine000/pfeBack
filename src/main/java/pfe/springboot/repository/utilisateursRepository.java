package pfe.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.springboot.entities.utilisateurs;
@Repository
public interface utilisateursRepository extends JpaRepository<utilisateurs,Long> {
}