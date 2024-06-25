package pfe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.springboot.entities.cours;

@Repository
public interface coursRepo extends JpaRepository<cours, Long > {
}
