package tn.esprit.gestionfoyermrabet.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyermrabet.Repositories.FoyerRepository;
import tn.esprit.gestionfoyermrabet.Repositories.UniversiteRepository;
import tn.esprit.gestionfoyermrabet.entities.Foyer;
import tn.esprit.gestionfoyermrabet.entities.Universite;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IUniversiteServicesImp implements IUniversiteServices{

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return  universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite Universite = universiteRepository.findById(idFoyer).orElse(null);
        Foyer Foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite.setFoyer(Foyer);
        return Universite ;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite Universite = universiteRepository.findById(idUniversite).orElse(null);
        Foyer Foyer = foyerRepository.findById(idUniversite).orElse(null);
        Universite.setFoyer(null);
        return Universite;
    }
}
