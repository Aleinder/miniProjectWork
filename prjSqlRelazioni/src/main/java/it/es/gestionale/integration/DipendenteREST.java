package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.DipendenteService;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/dipendente")
@SessionAttributes("utente")
public class DipendenteREST {
   
    @Autowired
    DipendenteService service;

    @GetMapping
    public ResponseEntity<List<DipendenteEntity>> getImpiegati(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return ResponseEntity.ok(service.getDipendenti());
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/nome")
    public ResponseEntity<List<DipendenteEntity>> getImpiegatiByNome(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return ResponseEntity.ok(service.getDipendentiByNome(utente));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/cognome")
    public ResponseEntity<List<DipendenteEntity>> getImpiegatiByCognome(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return  ResponseEntity.ok(service.getDipendentiByCognome(utente));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/settore")
    public ResponseEntity<List<DipendenteEntity>> getImpiegatiBySettore(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return ResponseEntity.ok(service.getDipendentiBySettore(utente));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/stipendio/range/{min}/{max}")
    public ResponseEntity<List<DipendenteEntity>> getImpiegatiByStipendio(@PathVariable double min,@PathVariable double max,UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return ResponseEntity.ok(service.getDipendentiByStipendio(min,max,utente));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }


	
    @PostMapping("/addImpiegato")
    public ResponseEntity<DipendenteEntity> addImpiegato(@ModelAttribute DipendenteEntity impiegato , @ModelAttribute UtenteEntity utente ){
        if (utente.getRuolo().equals("supervisore")){
            service.addImpiegato(utente, impiegato);
            return ResponseEntity.ok(impiegato);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }


    @PostMapping("/editImpiegato")
    public ResponseEntity<DipendenteEntity> editImpiegato(@ModelAttribute DipendenteEntity impiegato,UtenteEntity utente){

        if (utente.getRuolo().equals("supervisore")){
            return   ResponseEntity.ok(service.editImpiegato(impiegato,utente));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }


}
