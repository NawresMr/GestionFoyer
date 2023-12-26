package tn.esprit.gestionfoyermrabet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyermrabet.Services.IBlocServices;
import tn.esprit.gestionfoyermrabet.entities.Bloc;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/bloc")
public class BlocController {
    private final IBlocServices iBlocServices   ;


    @PostMapping
    public void addBloc(@RequestBody Bloc bloc){
        iBlocServices.addBloc(bloc);
    }
    @PutMapping
    public void updateBloc(@RequestBody Bloc bloc){
        iBlocServices.updateBloc(bloc);
    }
    @GetMapping("/{idBloc}")
    public Bloc findById(@PathVariable long idBloc){
        return iBlocServices.retrieveBloc(idBloc);
    }
    @DeleteMapping("/{idBloc}")
    public void deleteById(@PathVariable long idBloc){
        iBlocServices.removeBloc(idBloc);
    }
    @GetMapping
    public void findAll(){
        iBlocServices.retrieveBlocs();
    }


    @PutMapping("affecterchambre/{idBloc}/{idChambre}")
    public void affecterChambreABloc(@PathVariable long idBloc, @PathVariable List <Long> idChambre){
        iBlocServices.affecterChambresABloc(idChambre,idBloc);
    }

    @PutMapping("/affecterBlocFoyer/{idBloc}/{idFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return iBlocServices.affecterBlocAFoyer(idBloc, idFoyer);
    }
}
