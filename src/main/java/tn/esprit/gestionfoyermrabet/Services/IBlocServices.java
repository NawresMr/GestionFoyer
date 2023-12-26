package tn.esprit.gestionfoyermrabet.Services;

import tn.esprit.gestionfoyermrabet.entities.Bloc;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, long
            idBloc) ;
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) ;
    void listerNbreChambresParBloc();
}
