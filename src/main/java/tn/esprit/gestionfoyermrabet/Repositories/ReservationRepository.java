package tn.esprit.gestionfoyermrabet.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionfoyermrabet.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
// existsBy = tjrs retourne un boolean (true or false)
boolean existsByEtudiantSetCinAndAnneeUniversitaireBetween(long etudiantSet_cin, LocalDate anneeUniversitaire, LocalDate anneeUniversitaire2);

    List<Reservation> findAllByEstValide(boolean estValide);
    @Query("SELECT r FROM Reservation r JOIN r.etudiantSet e WHERE e.idEtudiant = :idEtudiant AND r.anneeUniversitaire <= :currentDate")
    Reservation getCurrentReservationByEtudiantId(Long idEtudiant, LocalDate currentDate);
}
