package tn.esprit.gestionfoyermrabet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Reservation {
    @Id
    @Setter(AccessLevel.NONE)
    String idReservation;
    LocalDate anneeUniversitaire;
    boolean estValide;
 //win mapped by n7ot jsonignore khtr heka howa parent li ygere fi rel

    @JsonIgnore
    //rel entre etudiant et reservation
   @ManyToMany(mappedBy = "reservationSet")
    Set<Etudiant> etudiantSet;
}
