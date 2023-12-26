package tn.esprit.gestionfoyermrabet.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyermrabet.Repositories.BlocRepository;
import tn.esprit.gestionfoyermrabet.Repositories.ChambreRepository;
import tn.esprit.gestionfoyermrabet.Repositories.FoyerRepository;
import tn.esprit.gestionfoyermrabet.entities.Bloc;
import tn.esprit.gestionfoyermrabet.entities.Chambre;
import tn.esprit.gestionfoyermrabet.entities.Foyer;

import java.util.HashSet;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class IBlocServicesImp implements IBlocServices{
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;
    private final FoyerRepository foyerRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll() ;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        for(Long id:numChambre){
            Chambre chambre = chambreRepository.findById(id).orElse(null);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }

        return blocRepository.save(bloc);
    }





    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

        bloc.setFoyer(foyer);
        blocRepository.save(bloc);

        return bloc;
    }

    @Scheduled(fixedDelay = 60000)
    @Override
    public void listerNbreChambresParBloc() {
        List<Bloc> blocList = (List<Bloc>) blocRepository.findAll();
        for (Bloc bloc : blocList) {
            log.info("Le bloc " + bloc.getNomBloc() + " contient "
                    +chambreRepository.countByBlocIdBloc(bloc.getIdBloc()) + " chambres");
        }
    }



}
