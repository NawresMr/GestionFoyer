package tn.esprit.gestionfoyermrabet.Services;

import tn.esprit.gestionfoyermrabet.entities.Reservation;

import java.util.List;

public interface IReservationServices {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);

    Reservation retrieveReservation (String idReservation);
    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    Reservation annulerReservation (Long cinEtudiant) ;
}
