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

    public List<DipendenteEntity> getDipendenti(){
        return dipDB.findAll();
    }

    public List<DipendenteEntity> getDipendentiByNome(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByNome();
        }

        return null;
        
    }

    public List<DipendenteEntity> getDipendentiByCognome(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByCognome();
        }
        return null;
    }

    public List<DipendenteEntity> getDipendentiBySettore(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderBySettore();
        }
        return null;
    }


    public List<DipendenteEntity> getDipendentiByStipendio(double min,double max){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findByStipendioBetween(min,max);
        }
        

        return null;
    }

    public DipendenteEntity addImpiegato(UtenteEntity utente , DipendenteEntity impiegato){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            uDB.save(utente);
          return dipDB.save(impiegato);
        }
        return null;
            
    }

    public DipendenteEntity editImpiegato(DipendenteEntity impiegato){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
          return dipDB.save(impiegato);
        }
        return null;
            
    }

}
