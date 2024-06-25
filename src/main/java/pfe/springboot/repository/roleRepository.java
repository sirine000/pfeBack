package pfe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.springboot.entities.role;

@Repository
public interface roleRepository extends JpaRepository<role, Long> {
}
