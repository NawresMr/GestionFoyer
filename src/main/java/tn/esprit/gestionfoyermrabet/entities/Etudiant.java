package tn.esprit.gestionfoyermrabet.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idEtudiant;
    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    Date dateNaissance;

    //rel entre etudiant et reservation
    @ManyToMany
    Set<Reservation> reservationSet;

}
