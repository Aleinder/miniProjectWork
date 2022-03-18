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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.service.DipendenteService;

@RestController
@RequestMapping("/api/dipendente")
public class DipendenteREST {
	
	@Autowired
	private DipendenteService dServ;
	
	@GetMapping("/nome/{nome}")
	public List<DipendenteEntity> getClientiByNome(@PathVariable("nome")String nome){
		
		return dServ.getDipendentiByNome(nome);
	}
	
	@GetMapping("/cognome/{cognome}")
	public List<DipendenteEntity> getClientiByCognome(@PathVariable("cognome")String cognome){
		
		return dServ.getDipendentiByCognome(cognome);
	}
	
	@GetMapping("/stipendio/{min}&{max}")
	public List<DipendenteEntity> getClientiByTelefono(@PathVariable("min")Double min, @PathVariable("max")Double max){
		
		return dServ.getDipendentiByStipendio(min,max);
	}
	
    @GetMapping("/ruolo/{ruolo}")
	public List<DipendenteEntity> getDipendente(@PathVariable("ruolo") int ruolo) {
		
		return dServ.getDipendentiByRuolo(ruolo);
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
