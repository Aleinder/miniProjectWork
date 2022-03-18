package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.DipendenteService;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/dipendente")
public class DipendenteREST {
   
    @Autowired
    DipendenteService service;

    @GetMapping
    public List<DipendenteEntity> getImpiegati(){
        return service.getDipendenti();
    }

    @GetMapping("/nome")
    public List<DipendenteEntity> getImpiegatiByNome(){
        return service.getDipendentiByNome();
    }

    @GetMapping("/cognome")
    public List<DipendenteEntity> getImpiegatiByCognome(){
        return service.getDipendentiByCognome();
    }

    @GetMapping("/settore")
    public List<DipendenteEntity> getImpiegatiBySettore(){
        return service.getDipendentiBySettore();
    }

    @GetMapping("/stipendio/range/{min}/{max}")
    public List<DipendenteEntity> getImpiegatiByStipendio(@PathVariable("min") double min,@PathVariable("max") double max){
        return service.getDipendentiByStipendio(min,max);
    }


	
    @PostMapping("/addImpiegato")
    public DipendenteEntity addImpiegato(@ModelAttribute DipendenteEntity impiegato , @ModelAttribute UtenteEntity utente ){
        service.addImpiegato(utente, impiegato);
        return impiegato;
    }


    @PostMapping("/editImpiegato")
    public DipendenteEntity editImpiegato(@ModelAttribute DipendenteEntity impiegato){

        return   service.editImpiegato(impiegato);
       
    }


}
