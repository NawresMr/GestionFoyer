package tn.esprit.gestionfoyermrabet.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionfoyermrabet.entities.Bloc;

public interface BlocRepository extends CrudRepository<Bloc,Long> {

    /*Créer un service permettant l’affichage des chambres non réservées ,par
    typeChambre , appartenant à un foyer donné par son nom, effectué durant
    l’année universitaire actuelle et exposer le en respectant la signature suivante :

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            String nomUniversite,TypeChambre type) ;*/

}
