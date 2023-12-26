package tn.esprit.gestionfoyermrabet.Services;

import tn.esprit.gestionfoyermrabet.entities.Foyer;

import java.util.List;

public interface IFoyerServices {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (long idFoyer);

    void removeFoyer (long idFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;

}
