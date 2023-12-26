package tn.esprit.gestionfoyermrabet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyermrabet.Services.IUniversiteServices;
import tn.esprit.gestionfoyermrabet.entities.Universite;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/universite")
public class UniversiteController {
    private final IUniversiteServices iUniversiteServices;
    @PostMapping
    public void addUniversite(@RequestBody Universite universite){
        iUniversiteServices.addUniversite(universite);
    }
    @PutMapping
    public void updateUniversite(@RequestBody Universite universite){
        iUniversiteServices.updateUniversite(universite);
    }

    @GetMapping
    public List<Universite> findAll(){
        return (List<Universite>) iUniversiteServices.retrieveAllUniversities();

    }
    @GetMapping("/{idUniversite}")
    public Universite findById(@PathVariable long idUniversite){
        return iUniversiteServices.retrieveUniversite(idUniversite);
    }

    @PutMapping("/affecter/{nomUniversite}/{idFoyer}")
    public Universite assignUniversityToFoyer(@PathVariable String nomUniversite, @PathVariable Long idFoyer) {
        return iUniversiteServices.affecterFoyerAUniversite( idFoyer,nomUniversite);
    }

    @PutMapping("/desaffecter/{idUniversite}")
    public Universite unassignUniversityToFoyer(@PathVariable long idUniversite) {
        return iUniversiteServices.desaffecterFoyerAUniversite(idUniversite);
    }
}
