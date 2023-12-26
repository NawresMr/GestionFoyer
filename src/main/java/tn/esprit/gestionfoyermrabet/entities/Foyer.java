package tn.esprit.gestionfoyermrabet.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;


    //rel foyer et bloc
    @OneToMany(mappedBy = "foyer")
    Set<Bloc> blocSet;

    //rel foyer et universite
    @OneToOne
    Universite universite;
}
