package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import domaine.Compte;
import domaine.CompteCourant;
import domaine.Conseiller;
import domaine.GerantAgence;
import domaine.ClientParticulier;
import domaine.Client;
import domaine.IGestionClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Ignore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class ProxiBanqueTest {
	
	GerantAgence gerant;
	@BeforeEach
	
	void init() {

		//Création gérant
		gerant = new GerantAgence("Mbiandou", "Roger");
		
		//Création conseillers
		gerant.enregistrerConseiller(new Conseiller("Dupont", "Dupont"));
		
		//Création de clients particuliers
		gerant.getListConseillers().get(0).enregistrerClient(new ClientParticulier("Munoz", "Maria", "rue llldld", "31500", "Toulouse", "0622556677",null,"1111111111111"));
		
		//Ajouter un compte courant
		gerant.getListConseillers().get(0).getListClients().get(0).ajouterCompteCourant(1500);
	}
    
    @Test
    void testFaireVirement() {
    	boolean testResultatVirement = gerant.faireVirement("11111111111110","11111111111111",100);
    	System.out.println(testResultatVirement);
    	assertTrue(testResultatVirement);
       // fail ("Echec virement entre comptes");
    }
    
    @Test
    void testCompteDecouvertAutorise() {
    	boolean testResultatDecouvert = gerant.faireVirement("11111111111110","11111111111111",100);
    	System.out.println(testResultatDecouvert);
    	assertTrue(testResultatDecouvert);
    	System.out.println(gerant.getListConseillers().get(0).getListClients().get(0).getListComptes().get(0).getSolde());
    	System.out.println(gerant.getListConseillers().get(0).getListClients().get(0).getListComptes().get(1).getSolde());
       // fail ("Echec virement entre comptes");
    }
}
