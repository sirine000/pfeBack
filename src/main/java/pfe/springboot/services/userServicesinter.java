package pfe.springboot.services;

import pfe.springboot.entities.participant;

import java.util.List;
import java.util.Optional;

public interface userServicesinter {

    participant addUser(participant user );
    void deleteuser(Long id);
    void  deleteuser(participant user);
    List<participant> getAllUser();
    Optional<participant> findByEmail(String email);

}
