package tn.esprit.gestionfoyermrabet.Services;

import tn.esprit.gestionfoyermrabet.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    List<Etudiant> retrieveAllEtudiants();

    List<Etudiant> addEtudiants (List<Etudiant> etudiants);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);
}
