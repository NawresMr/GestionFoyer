package tn.esprit.gestionfoyermrabet.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.gestionfoyermrabet.entities.enums.TypeChambre;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idChambre;
    long numChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    //rel uni entre chambre et res
    @OneToMany
    Set<Reservation> reservationSet;

    //rel bi entre chambre et bloc
    @ManyToOne
    Bloc bloc;
}
