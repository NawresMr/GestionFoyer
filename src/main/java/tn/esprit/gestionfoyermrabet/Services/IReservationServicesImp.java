package tn.esprit.gestionfoyermrabet.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.esprit.gestionfoyermrabet.Repositories.ChambreRepository;
import tn.esprit.gestionfoyermrabet.Repositories.EtudiantRepository;
import tn.esprit.gestionfoyermrabet.Repositories.ReservationRepository;
import tn.esprit.gestionfoyermrabet.entities.Chambre;
import tn.esprit.gestionfoyermrabet.entities.Etudiant;
import tn.esprit.gestionfoyermrabet.entities.Reservation;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IReservationServicesImp implements IReservationServices{
    private final ReservationRepository reservationRepository;
    private final EtudiantRepository etudiantRepository;
    private  final ChambreRepository chambreRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll()  ;
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }




   /* public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant).orElse(null);
        if (chambre.getReservationSet() != null && chambreRepository.findByReservationSetEstValide(true) != null) {

            int capacity = 0;
            if (chambre.getTypeC().equals("Sample")){
                capacity =1;
            } else if (chambre.getTypeC().equals("Double")){
                capacity =2;
            } else if (chambre.getTypeC().equals("Triple")){
                capacity =3;
            }
            if (chambre.getReservationSet().size() >= capacity) {
                System.out.println("Chambre is full");
                chambreRepository.findByReservationSetEstValide(false);
            }
            if ((chambre.getReservationSet().size()< capacity)&& !(etudiantRepository.findByReservationSetanneeUniversitaire(String reservationSet_anneeUniversitaire).equals(LocalDate.now().getYear()))){
               etudiant.setReservationSet();
            }


           else {
               Reservation reservation = new Reservation();
                Assert.notNull(chambre, "Chambre not found");
                Assert.notNull(etudiant, "Etudiant not found");



            }

        }
        return reservation;
    }*/

   /* @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant)
                .orElseThrow(()-> new IllegalArgumentException("Etudiant not found"));
        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(()-> new IllegalArgumentException("Chambre not found"));

        // String id =chambre.getNumChambre()+chambre.getBloc().
        //Assert.isTrue(); => bech nthabet est ce que reservation valide ( tant que encore valide maaneha mazelet fama place


        //hedhy ligne li ta7t :kn reservation jetny mil base ma ysir hata chyy ,kn jdid tjiny null point exception khtr ma aandich liste taa etudiant heka aaleh zedna etudiantset(new hashset<())
        //resrevation.getEtudiantset().add(etudiant); bech nzid etudiant lil liste des etudaints l9dima eli fi reservation
        //khtr ynajem ykoun aana etudiant deja feha


        //
        return null;


    }*/
    @Override
    @Transactional
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

     //il faut que l'etudiant ne dispose pas de res au cours de l'année courante
      Assert.isTrue(!reservationRepository.existsByEtudiantSetCinAndAnneeUniversitaireBetween(cinEtudiant
                             ,LocalDate.of(LocalDate.now().getYear(),1,1)
                             ,LocalDate.of(LocalDate.now().getYear(),12,31))
                             ,"l'etudiant dispose deja d'une reservation");

        Chambre chambre = chambreRepository.findById(idChambre).orElseThrow(() -> new IllegalArgumentException("chambre n'existe pas"));

       String id=chambre.getNumChambre()+'-'+chambre.getBloc().getNomBloc()+'-'+LocalDate.now().getYear();
        Reservation reservation =reservationRepository.findById(id)
                .orElse(
                        Reservation.builder()
                                .idReservation(id)
                                .anneeUniversitaire(LocalDate.now())
                                .etudiantSet(new HashSet<>())
                                .estValide(true)
                                .build());


     //si la reservation n'est pas valide , il va lancer une exception Assert.isTrue(reservation.isEstValide(),"la chambre est saturée");//si la reservation est valide , on va ajouter l'etudiant au set des Etudiants dans reservation reservation.getEtudiantSet().add(etudiant);

     //si la reservation est nouvelle
     if(!chambre.getReservationSet().contains(reservation))
        {
     //enregistrer la nouvelle reservation et l'affecter à l'ancienne reservation(bch twali l'objet reservation managed entity et les modifications d'après s'effectueront à travers transactional)
      // --->recuperer le retour de .save w nraj3ou f l'objet reservation eli nekhdem alih
     reservation=reservationRepository.save(reservation);
    //l'ajouter au set des reservations au niveau de la chambre
        chambre.getReservationSet().add(reservation);
        }
     //on va modifier l'attribut isValid selon le type de la chambre et size du set Etudiant
      switch (chambre.getTypeC())
        {
            case SIMPLE -> reservation.setEstValide(false);
            case DOUBLE -> {if (reservation.getEtudiantSet().size()==2) {reservation.setEstValide(false);}}
            case TRIPLE -> {if (reservation.getEtudiantSet().size()==3) {reservation.setEstValide(false);}}
        }
        return reservation;


    }


    @Override
    @Transactional
    public Reservation annulerReservation(Long cinEtudiant) {
        // Trouver l'étudiant et sa réservation
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        // Supposition: chaque étudiant a au maximum une réservation valide
        Reservation reservation = etudiant.getReservationSet().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant
        reservation.getEtudiantSet().remove(etudiant);

        // Désaffecter la chambre associée et mettre à jour sa capacité
        Chambre chambreAssociee = chambreRepository.findByReservationsContains(reservation);
        if (chambreAssociee != null) {
            chambreAssociee.getReservationSet().remove(reservation);
            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return reservationRepository.save(reservation);
    }


    @Transactional
    @Scheduled(cron = "0 0 0 2 6 *") // À minuit, le 2 juin de chaque année
    public void annulerToutesLesReservationsAutomatiquement() {
        List<Reservation> reservationsValides = reservationRepository.findAllByEstValide(true);

        for (Reservation reservation : reservationsValides) {
            reservation.setEstValide(false); // Marquer la réservation comme invalide

            // Désaffecter les étudiants de la réservation
            for (Etudiant etudiant : reservation.getEtudiantSet()) {
                etudiant.getReservationSet().remove(reservation);
            }
            reservation.getEtudiantSet().clear();

            // Désaffecter la chambre associée et mettre à jour sa capacité
            Chambre chambreAssociee = chambreRepository.findByReservationsContains(reservation);
            if (chambreAssociee != null) {
                chambreAssociee.getReservationSet().remove(reservation);
                chambreRepository.save(chambreAssociee);
            }

            // Sauvegarder la réservation modifiée
            reservationRepository.save(reservation);
        }
    }



}
