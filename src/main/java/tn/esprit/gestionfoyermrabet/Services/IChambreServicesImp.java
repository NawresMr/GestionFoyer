package tn.esprit.gestionfoyermrabet.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyermrabet.Repositories.ChambreRepository;
import tn.esprit.gestionfoyermrabet.entities.Chambre;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IChambreServicesImp implements IChambreServices{
    private final ChambreRepository chambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();

    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
            return  chambreRepository.findById(idChambre).orElse(null);
    }


}
