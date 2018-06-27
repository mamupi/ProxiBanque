package lanceur;

import domaine.ClientEntreprise;
import domaine.ClientParticulier;
import domaine.Conseiller;
import domaine.GerantAgence;

/**
 * @author NathanDubot/MariaMunoz
 * @version 1.0
 *
 */

public class Demo
{
	public static void main(String[] args)
	{
		//Création gérant
		GerantAgence gerant = new GerantAgence("Mbiandou", "Roger");
		
		//Création conseillers
		gerant.enregistrerConseiller(new Conseiller("Dupont", "Dupont"));
		gerant.enregistrerConseiller(new Conseiller("Lupont", "Lupont"));
		
		//Création de clients particuliers
		gerant.getListConseillers().get(0).enregistrerClient(new ClientParticulier("Munoz", "Maria", "rue llldld", "31500", "Toulouse", "0622556677",null,"1111111111111"));
		gerant.getListConseillers().get(1).enregistrerClient(new ClientParticulier("Dubot", "Nathan", "rue lggdgd", "31200", "Toulouse", "0622547877",null,"2222222222222"));
		gerant.enregistrerClient(new ClientParticulier("Romieux", "Estele", "rue lddddld", "31130", "Tournefeuille", "0625456677",null,"4444444444444"));
		
		//Création de clients entreprises
		gerant.getListConseillers().get(0).enregistrerClient(new ClientEntreprise("Capgemini", "", "rue gggggggg", "31500", "Toulouse", "0561784527",null,"111111"));
		gerant.getListConseillers().get(1).enregistrerClient(new ClientEntreprise("Sogeti", "", "rue gddddggg", "31200", "Toulouse", "0566262527",null,"222222"));
		gerant.enregistrerClient(new ClientEntreprise("Accenture", "", "rukkkkkgggg", "31400", "Toulouse", "0554784527",null,"444444"));
		
		//Modification des Clients
		gerant.getListConseillers().get(0).getListClients().get(0).setTelephone("0687491536");
		gerant.getListConseillers().get(1).getListClients().get(1).setCodePostal("31820");
		
		//Ajouter un compte courant
		gerant.getListConseillers().get(0).getListClients().get(0).ajouterCompteCourant(1500);
		
		//Ajouter un compte epargne
		((ClientParticulier) gerant.getListConseillers().get(0).getListClients().get(1)).ajouterCompteEpargne(500);
		
		//Consulter un client
		gerant.trouverClient("1111111111111");
		gerant.getListConseillers().get(1).trouverClient("2222222222222");
		
		//Supprimer un client
		gerant.getListConseillers().get(1).getListClients().remove(1);
		
		gerant.getListConseillers().get(1).supprimerClient("222222");
		
		//Faire virement
		gerant.getListConseillers().get(0).faireVirement("11111111111110", "22222222222220", 5341);
		gerant.faireVirement("22222222222220", "11111111111110", 5341);
		
		//Simuler un credit consommation
		gerant.getListConseillers().get(0).getListClients().get(1).simulerCreditConsommation();
		
		//Simuler un credit immobilier
		gerant.getListConseillers().get(1).getListClients().get(0).simulerCreditImmobilier();
		
		//Gestion de patrimoine
		if(!gerant.getListConseillers().get(0).getListClients().get(1).gererPatrimoine("22222222222220", "New York", 2000))
		{
			System.out.println("Gestion de patrimoine impossible.");
		}
		else
		{
			System.out.println("Investissement réussi.");
		}

		//Auditer l'agence
		gerant.auditer();
	}

}
