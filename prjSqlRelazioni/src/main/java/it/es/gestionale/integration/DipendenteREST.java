package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DipendenteEntity> getImpiegati(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return service.getDipendenti();
        }
        return null;
    }

    @GetMapping("/nome")
    public List<DipendenteEntity> getImpiegatiByNome(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return service.getDipendentiByNome(utente);
        }
        return null;
    }

    @GetMapping("/cognome")
    public List<DipendenteEntity> getImpiegatiByCognome(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return service.getDipendentiByCognome(utente);
        }
        return null;
    }

    @GetMapping("/settore")
    public List<DipendenteEntity> getImpiegatiBySettore(UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return service.getDipendentiBySettore(utente);
        }
        return null;
    }

    @GetMapping("/stipendio/range/{min}/{max}")
    public List<DipendenteEntity> getImpiegatiByStipendio(@PathVariable double min,@PathVariable double max,UtenteEntity utente){
        if (utente.getRuolo().equals("supervisore")){
            return service.getDipendentiByStipendio(min,max,utente);
        }
        return null;
    }


	
    @PostMapping("/addImpiegato")
    public DipendenteEntity addImpiegato(@ModelAttribute DipendenteEntity impiegato , @ModelAttribute UtenteEntity utente ){
        if (utente.getRuolo().equals("supervisore")){
            service.addImpiegato(utente, impiegato);
            return impiegato;
        }
        return null;
    }


    @PostMapping("/editImpiegato")
    public DipendenteEntity editImpiegato(@ModelAttribute DipendenteEntity impiegato,UtenteEntity utente){

        if (utente.getRuolo().equals("supervisore")){
            return   service.editImpiegato(impiegato,utente);
        }
        return null;
    }


}
