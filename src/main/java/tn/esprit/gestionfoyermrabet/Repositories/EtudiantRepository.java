package tn.esprit.gestionfoyermrabet.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionfoyermrabet.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {

    //List<Etudiant> findByReservationSetanneeUniversitaire(String reservationSet_anneeUniversitaire);



    Etudiant findByCin(Long cin);
}
