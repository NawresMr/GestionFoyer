package tn.esprit.gestionfoyermrabet.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyermrabet.Repositories.EtudiantRepository;
import tn.esprit.gestionfoyermrabet.entities.Etudiant;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IEtudiantServicesImp implements IEtudiantServices {
    private final EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant>) etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
         etudiantRepository.deleteById(idEtudiant);
    }
}
