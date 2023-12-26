package tn.esprit.gestionfoyermrabet.Services;

import tn.esprit.gestionfoyermrabet.entities.Chambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);
}
