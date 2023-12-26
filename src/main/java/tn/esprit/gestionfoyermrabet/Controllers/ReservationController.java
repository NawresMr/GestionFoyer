package tn.esprit.gestionfoyermrabet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyermrabet.Services.IReservationServices;
import tn.esprit.gestionfoyermrabet.entities.Reservation;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reservation")
public class ReservationController {
    private final IReservationServices iReservationServices;

   @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return iReservationServices.updateReservation(reservation);
    }
    @GetMapping("/{idReservation}")
    public Reservation findById(@PathVariable String idReservation){
        return iReservationServices.retrieveReservation(idReservation);
    }
  @GetMapping
    public Reservation findAll(){
        return (Reservation) iReservationServices.retrieveAllReservation();
    }
     @PostMapping("/{idChambre}/{cinEtudiant}")
     public Reservation ajouterReservation (@PathVariable long idChambre,@PathVariable long cinEtudiant) {
        	 return iReservationServices.ajouterReservation(idChambre, cinEtudiant);
     }



    @PutMapping("/annulerReservation/{cin}")
    public Reservation annulerReservation(@PathVariable Long cin) {
        return iReservationServices.annulerReservation(cin);
    }


}
