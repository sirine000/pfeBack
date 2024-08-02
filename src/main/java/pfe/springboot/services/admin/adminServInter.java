package pfe.springboot.services.admin;

import pfe.springboot.entities.Admin;

public interface adminServInter {
     public Admin connecter(String email, String password);
     Admin updateAdmin(Long id_admin, Admin updateProf);

}
