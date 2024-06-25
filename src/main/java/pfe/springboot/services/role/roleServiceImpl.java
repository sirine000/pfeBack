package pfe.springboot.services.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.springboot.entities.role;
import pfe.springboot.entities.utilisateurs;
import pfe.springboot.repository.roleRepository;

@Service
public class roleServiceImpl implements roleServiceInter{
@Autowired
    roleRepository roleRepository;


    @Override
    public role ajouterRole(role roles) {

        return roleRepository.save(roles);
    }
}
