package tn.esprit.gestionfoyermrabet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idBloc;
    String nomBloc;
    long capaciteBloc;

    //rel entre bloc et chambre
    @OneToMany(mappedBy = "bloc")
    Set<Chambre> chambreSet;

    //hne 7atina jsonignore khtr Est7a9ineha
   @JsonIgnore
    //rel entre bloc et foyer
    @ManyToOne
    Foyer foyer;
}
