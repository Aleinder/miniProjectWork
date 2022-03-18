package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.repository.DipendenteDB;

@Service
public class DipendenteService {
    
    @Autowired
    DipendenteDB dipDB;

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

    public List<DipendenteEntity> getImpiegatiBySettore(){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findImpiegatoBySettore();
        }
        

        return null;
    }

    public List<DipendenteEntity> getImpiegatiByStipendio(double min,double max){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findImpiegatoByStipendioBetween(min,max);
        }
        

        return null;
    }
}
