package pfe.springboot.services;

import pfe.springboot.entities.participant;

import java.util.List;

public interface userServicesinter {

    participant addUser(participant user );
    void deleteuser(Long id);
    void  deleteuser(participant user);
    List<participant> getAllUser();


}
