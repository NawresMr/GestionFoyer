package tn.esprit.gestionfoyermrabet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyermrabet.Services.IFoyerServices;
import tn.esprit.gestionfoyermrabet.entities.Foyer;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/foyer")
public class FoyerController {
    private final IFoyerServices     iFoyerServices;
    @PostMapping
    public void addFoyer(@RequestBody Foyer foyer){
        iFoyerServices.addFoyer(foyer);

    }
    @PutMapping
    public void updateFoyer(@RequestBody Foyer foyer){
        iFoyerServices.updateFoyer(foyer);
    }
    @GetMapping("/{idFoyer}")
    public Foyer findById(@PathVariable long idFoyer){
        return iFoyerServices.retrieveFoyer(idFoyer);
    }
    @DeleteMapping("/{idFoyer}")
    public void deleteById(@PathVariable long idFoyer){
        iFoyerServices.removeFoyer(idFoyer);
    }
    @GetMapping
    public void findAll(){
        iFoyerServices.retrieveAllFoyers();
    }
    @PostMapping("/{idUniversite}")
    public void ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite){
        iFoyerServices.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }


}
