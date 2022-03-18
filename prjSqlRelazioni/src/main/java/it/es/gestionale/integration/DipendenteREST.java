package it.es.gestionale.integration;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

@RestController
@RequestMapping("/api/dipendente")
@SessionAttributes("utente_logged")
public class DipendenteREST {
   
    @Autowired
    DipendenteService service;

    @GetMapping("/nome")
    public List<DipendenteEntity> getImpiegatiByNome(){
        return service.getImpiegatiByNome();
    }

    @GetMapping("/cognome")
    public List<DipendenteEntity> getImpiegatiByCognome(){
        return service.getImpiegatiByCognome();
    }

    @GetMapping("/settore")
    public List<DipendenteEntity> getImpiegatiBySettore(){
        return service.getImpiegatiBySettore();
    }

    @GetMapping("/stipendio/range/{min}/{max}")
    public List<DipendenteEntity> getImpiegatiByStipendio(@PathVariable double min,@PathVariable double max){
        return service.getImpiegatiByStipendio(min,max);
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
