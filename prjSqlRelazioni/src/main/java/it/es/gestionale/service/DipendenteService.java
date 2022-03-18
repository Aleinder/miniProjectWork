package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.repository.DipendenteDB;
import it.es.gestionale.repository.UtenteDB;

@Service
public class DipendenteService {
    
    @Autowired
    DipendenteDB dipDB;

    @Autowired
    UtenteDB uDB;

    DipendenteEntity dipente;

    public List<DipendenteEntity> getImpiegatiByNome(){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findImpiegatoByNome();
        }

        return null;
        
    }

    public List<DipendenteEntity> getImpiegatiByCognome(){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findImpiegatoByCognome();
        }
        return null;
    }

    public List<DipendenteEntity> getImpiegatiByRuolo(){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findImpiegatoByRuolo();
        }
        

        return null;
    }

    public List<DipendenteEntity> getImpiegatiByStipendio(double min,double max){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findImpiegatoByStipendioBetween(min,max);
        }
        

        return null;
    }

    public DipendenteEntity addImpiegato(UtenteEntity utente , DipendenteEntity impiegato){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            uDB.save(utente);
          return dipDB.save(impiegato);
        }
        return null;
            
    }

    public DipendenteEntity editImpiegato(DipendenteEntity impiegato){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
          return dipDB.save(impiegato);
        }
        return null;
            
    }
}
