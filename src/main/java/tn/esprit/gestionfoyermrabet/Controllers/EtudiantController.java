package tn.esprit.gestionfoyermrabet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyermrabet.Services.IEtudiantServices;
import tn.esprit.gestionfoyermrabet.entities.Etudiant;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/etudiant")
public class EtudiantController {
    private final IEtudiantServices iEtudiantServices;

    @PostMapping
    public List<Etudiant> addEtudiant(@RequestBody List < Etudiant > etudiants){
        return iEtudiantServices.addEtudiants(etudiants);
    }
    @PutMapping
    public void updateEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.updateEtudiant(etudiant);
    }
    @GetMapping("/{idEtudiant}")
    public Etudiant findById(@PathVariable long idEtudiant){
        return iEtudiantServices.retrieveEtudiant(idEtudiant);
    }
    @GetMapping
    public List<Etudiant>  findAll(){
        return (List<Etudiant>) iEtudiantServices.retrieveAllEtudiants();
    }
    @DeleteMapping("/{idEtudiant}")
    public void deleteById(@PathVariable long idEtudiant){
        iEtudiantServices.removeEtudiant(idEtudiant);
    }
}
