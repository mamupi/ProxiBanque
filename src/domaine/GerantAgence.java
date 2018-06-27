package domaine;

import java.util.ArrayList;
import java.util.Calendar;

public class GerantAgence implements IGestionClient
{
	//Attributs
	private String nom;
	private String prenom;
	private ArrayList<Conseiller> listConseillers;
	
	//Constructeurs
	public GerantAgence(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.listConseillers = new ArrayList<Conseiller>();
	}
	
	public GerantAgence(String nom, String prenom, ArrayList<Conseiller> listConseillers)
	{
		this(nom, prenom);
		this.listConseillers = new ArrayList<Conseiller>();
	}
	
	//Gets and Sets
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<Conseiller> getListConseillers() {
		return listConseillers;
	}

	public void setListConseillers(ArrayList<Conseiller> listConseillers) {
		this.listConseillers = listConseillers;
	}

	//ToString
	//@Override
	//public String toString() {
	//	return "GerantAgence [nom=" + nom + ", prenom=" + prenom + ", listConseillers=" + listConseillers + "]";
	//}
	
	//Méthodes Métier	
	//Ajouter un conseiller à l'agence
	public boolean enregistrerConseiller(domaine.Conseiller conseiller)
	{
		this.listConseillers.add(conseiller);
		return true;
	}
	
	//Consulter les details de toutes son agence (Conseiller, Clients, Comptes)
		public void consulter ()
		{
			for (Conseiller conseiller : this.listConseillers)
			{
				conseiller.consulter();
			}
		}
		
		//Auditer tous les comptes de tous les clients de l'agence
		public void auditer()
		{
			boolean warningClient = false;
			for(Conseiller conseiller : this.listConseillers)
			{
				for(Client client : conseiller.getListClients())
				{
					for(Compte compte : client.getListComptes())
					{
						if((client instanceof ClientParticulier) && (compte.getSolde() <= -5000))
						{
							System.out.println("Le compte particulier " + compte.getNumCompte() + " de " + client.getNom() + " " + client.getPrenom() + " debite de plus de 5000 Euro");
							warningClient = true;
						}
						else if((client instanceof ClientEntreprise) && (compte.getSolde() <= -50000))
						{
							System.out.println("Le compte entreprise " + compte.getNumCompte() + " de " + client.getNom() + " " + client.getPrenom() + " debite de plus de 50000 Euro");
							warningClient = true;
						}
					}
				}
			}

			if(!warningClient)
			{
				System.out.println("L'auditorie a fini sans trouver aucun compte a signaler.");
			}
		}
	
	//Méthodes de l'interface IGestionClient
	//Enregistrer Client
	@Override
	public boolean enregistrerClient(domaine.Client client)
	{
		for (Conseiller conseiller : this.listConseillers)
		{
			if(conseiller.getListClients().size() < 10)
			{
				
				client.ajouterCompteCourant(0);
				conseiller.enregistrerClient(client);
				return true;
			}
		}
		return false;
	}
	
	//Recherche de Client par numï¿½ro de compte
	@Override
	public void trouverClient(String num)
	{
		for (Conseiller conseiller : this.listConseillers)
		{
			for(Client client : conseiller.getListClients())
			{
				if(client.getNum().equals(num))
				{
					client.consulter();
				}
			}
		}
	}
		
		//Virement banquaire
		@Override
	public boolean faireVirement(String numCompte1, String numCompte2, double montant)
	{
		Compte compte1 = null;
		Compte compte2 = null;
		
		for (Conseiller conseiller : this.listConseillers)
		{
			for(Client client : conseiller.getListClients())
			{
				for(Compte compte : client.getListComptes())
				{
					if(compte.getNumCompte().equals(numCompte1))
					{
						compte1=compte;
					}
						
					if(compte.getNumCompte().equals(numCompte2))
					{
						compte2=compte;
					}
				}
			}
		}
		if(compte1 == null||compte2 == null)
		{
			return false;
		}
			
		compte1.setSolde(compte1.getSolde()-montant);
		compte2.setSolde(compte2.getSolde()+montant);
			
		return true;		
	}
	
	//Supprimer client
	public void supprimerClient(String num)
	{
		for(Conseiller conseiller : this.getListConseillers())
		{
			conseiller.supprimerClient(num);
		}
	}
}
