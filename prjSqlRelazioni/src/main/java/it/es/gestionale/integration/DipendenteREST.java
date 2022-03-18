package it.es.gestionale.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.service.DipendenteService;

@RestController
@RequestMapping("/api/dipendente")
public class DipendenteREST {
   
    @Autowired
    DipendenteService service;

    public String getImpiegati(){
        
        

        return null;  
    }

}
