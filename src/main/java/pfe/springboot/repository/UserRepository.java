package pfe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.springboot.entities.participant;

public interface UserRepository extends JpaRepository<participant, Long> {
}
