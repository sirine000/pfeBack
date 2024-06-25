package pfe.springboot.services.utilisateurs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pfe.springboot.entities.role;
import pfe.springboot.entities.utilisateurs;
import pfe.springboot.repository.roleRepository;
import pfe.springboot.repository.utilisateursRepository;

@Service
public class utilisateursServiceImpl implements utilisateursServiceInter{
    @Autowired
    utilisateursRepository utilisateursRepository;
    @Autowired
    roleRepository roleRepository;
    @Override
    public utilisateurs addutilisateurs(utilisateurs utilisateurs) {
        role role= roleRepository.findById(1L).orElse(null);
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(utilisateurs.getPassword());
        utilisateurs.setPassword(encryptedPassword);

        utilisateurs.getRole().add(role);

        return utilisateursRepository.save(utilisateurs);
    }
}
