package tn.esprit.gestionfoyermrabet.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idUniversite;
    String nomUniversite;
    String adresse;

    //rel foyer et universite
    @OneToOne(mappedBy = "universite")
    Foyer foyer;
}
