package pfe.springboot.services.cours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.springboot.entities.cours;
import pfe.springboot.repository.coursRepo;
@Service
public class coursImpl implements coursInter{
    @Autowired
    coursRepo coursRepo;
    @Override
    public cours addcours(cours Vcours){
        return coursRepo.save(Vcours);
    }
}
