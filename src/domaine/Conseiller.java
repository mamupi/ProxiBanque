package domaine;

import java.util.ArrayList;

public class Conseiller implements IGestionClient
{
	//Attributs
	private String nom;
	private String prenom;
	private ArrayList<Client> listClients;
	
	//Constructeurs
	public Conseiller(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.listClients = new ArrayList<Client>();
	}
	
	public Conseiller(String nom, String prenom,ArrayList<Client> listClients)
	{
		this(nom, prenom);
		this.listClients = listClients;
	}
	
	//Gets and Sets
	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	public ArrayList<Client> getListClients()
	{
		return listClients;
	}

	public void setListClients(ArrayList<Client> listClients)
	{
		this.listClients = listClients;
	}
	
	//ToString
	//@Override
	//public String toString()
	//{
	//	return "Conseiller [nom=" + nom + ", prenom=" + prenom + "]";
	//}

	public void consulter()
	{
		System.out.println("Le conseiller " + this.getNom()+ " " + this.getPrenom() + " conseille les clients :");
		for(Client client : this.getListClients())
		{
			client.consulter();
		}
	}
	
	//Méthodes de l'interface IGestionClient
	//Enregistrer Client
	@Override
	public boolean enregistrerClient(domaine.Client client)
	{
		if(this.listClients.size() == 10)
		{
			return false;
		}
		client.ajouterCompteCourant(0);
		this.listClients.add(client);
		return true;
	}

	//Recherche de Client par numéro de compte
	@Override
	public void trouverClient(String num)
	{		
		for(Client client : this.listClients)
		{
			
			if(client.getNum().equals(num))
			{
				client.consulter();
			}
		}
	}
	
	//Virement banquaire
	public boolean faireVirement(String numCompte1, String numCompte2, double montant)
	{
		Compte compte1 = null;
		Compte compte2 = null;
		
		for(Client client : this.listClients)
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
		for(Client client : this.getListClients())
		{
			if(client.getNum().equals(num))
			{
				this.getListClients().remove(client);
			}
		}
	}
}
	