package it.es.gestionale.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.repository.DipendenteDB;
import it.es.gestionale.repository.UtenteDB;

@Service
@SessionAttributes("utente")
public class DipendenteService {
    
    @Autowired
    DipendenteDB dipDB;
    @Autowired
    UtenteDB uDB;

    DipendenteEntity dipendente;

    public List<DipendenteEntity> getDipendenti(){
        return dipDB.findAll();
    }

    public List<DipendenteEntity> getDipendentiByNome(UtenteEntity ut){

        if (ut.getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByNome();
        }

        return null;
        
    }

    public List<DipendenteEntity> getDipendentiByCognome(UtenteEntity ut){
        if (ut.getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByCognome();
        }
        return null;
    }

    public List<DipendenteEntity> getDipendentiBySettore(UtenteEntity ut){
        if (ut.getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderBySettore();
        }
        return null;
    }


    public List<DipendenteEntity> getDipendentiByStipendio(double min,double max,UtenteEntity ut){
        if (ut.getRuolo().equals("supervisore")){
            return dipDB.findByStipendioBetween(min,max);
        }
        

        return null;
    }

    public DipendenteEntity addImpiegato(UtenteEntity utente , DipendenteEntity impiegato){
        if (utente.getRuolo().equals("supervisore")){
            uDB.save(utente);
          return dipDB.save(impiegato);
        }
        return null;
            
    }

    public DipendenteEntity editImpiegato(DipendenteEntity impiegato,UtenteEntity ut){
        if (ut.getRuolo().equals("supervisore")){
          return dipDB.save(impiegato);
        }
        return null;
            
    }

}
