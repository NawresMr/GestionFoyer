package tn.esprit.gestionfoyermrabet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyermrabet.Services.IChambreServices;
import tn.esprit.gestionfoyermrabet.entities.Chambre;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chambre")

public class ChambreController {
    private final IChambreServices iChambreServices;
    @PostMapping
    public void addChambre(@RequestBody Chambre c){
        iChambreServices.addChambre( c);
    }

    @PutMapping
    public void updateChambre(@RequestBody Chambre c){
        iChambreServices.updateChambre(c);
    }

    @GetMapping("/{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre){
        return iChambreServices.retrieveChambre(idChambre);
    }
    @GetMapping
    public void retrieveAllChambres(){
        iChambreServices.retrieveAllChambres();
    }

}
