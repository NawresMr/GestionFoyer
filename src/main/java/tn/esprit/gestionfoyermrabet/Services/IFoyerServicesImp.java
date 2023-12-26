package tn.esprit.gestionfoyermrabet.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.gestionfoyermrabet.Repositories.BlocRepository;
import tn.esprit.gestionfoyermrabet.Repositories.FoyerRepository;
import tn.esprit.gestionfoyermrabet.Repositories.UniversiteRepository;
import tn.esprit.gestionfoyermrabet.entities.Bloc;
import tn.esprit.gestionfoyermrabet.entities.Foyer;
import tn.esprit.gestionfoyermrabet.entities.Universite;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IFoyerServicesImp implements IFoyerServices {
    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;
    private final BlocRepository blocRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
       foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite Universite = universiteRepository.findById(idUniversite).orElse(null);
        foyerRepository.save(foyer);
        Bloc bloc = foyer.getBlocSet()
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No bloc found"));

        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
        foyer.setUniversite(Universite);

        return foyer;
    }
}
