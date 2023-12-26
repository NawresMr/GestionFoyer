package tn.esprit.gestionfoyermrabet.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionfoyermrabet.entities.Chambre;
import tn.esprit.gestionfoyermrabet.entities.Reservation;

import java.util.List;

public interface ChambreRepository extends CrudRepository<Chambre,Long> {
   // List<Chambre> findByReservationSetEstValide(boolean reservationSet_estValide);
   Chambre findByReservationsContains(Reservation reservation);
  int countByBlocIdBloc(long idBloc);
}
