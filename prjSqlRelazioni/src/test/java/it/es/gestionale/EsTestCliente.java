package it.es.gestionale;


import java.util.List;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.repository.DipendenteDB;
import it.es.gestionale.repository.OrdineDB;
import it.es.gestionale.repository.UtenteDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class EsTestCliente {
	@Autowired
	DipendenteDB db;

	@Autowired
	UtenteDB dbUt;

	@Test
	@Transactional
	void findUtenti() {

		List<UtenteEntity> utenti =  dbUt.findAll();
		
		System.out.println("--------------");
		for(UtenteEntity utente : utenti){

			if(utente.getRuolo().equals("supervisore")){
				System.out.println(db.findAll());
			}else{
				System.out.println("--------------");
				System.out.println("no");
				System.out.println("--------------");
			}
		}
		System.out.println("--------------");

	}
}
