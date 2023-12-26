package tn.esprit.gestionfoyermrabet.Services;

import tn.esprit.gestionfoyermrabet.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (long idUniversite);
    public Universite affecterFoyerAUniversite (long idFoyer, String
            nomUniversite);
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
