package pfe.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.springboot.entities.participant;
import pfe.springboot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class participantsserviceImpl implements userServicesinter {
    @Autowired
    UserRepository userRepository;


    @Override
    public participant addUser(participant user) {

         return userRepository.save(user);


    }

    @Override
    public void deleteuser(Long id) {
   userRepository.deleteById(id);
    }

    @Override
    public void deleteuser(participant user) {
         userRepository.delete(user);

    }

    @Override
    public List<participant> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<participant> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}


