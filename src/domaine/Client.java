package domaine;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Client
{	
	//Attributs
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private ArrayList<String> listInvestissement;
	private ArrayList<Compte> listComptes;
	
	//Constructeurs
	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,	String listInvestissement)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.listInvestissement = new ArrayList<String>();
		this.listComptes = new ArrayList<Compte>();
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

	public String getAdresse()
	{
		return adresse;
	}

	public String getCodePostal()
	{
		return codePostal;
	}

	public String getVille()
	{
		return ville;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public ArrayList<String> getListInvestissement()
	{
		return this.listInvestissement;
	}

	public ArrayList<Compte> getListComptes()
	{
		return this.listComptes;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}

	public void setCodePostal(String codePostal)
	{
		this.codePostal = codePostal;
	}

	public void setVille(String ville)
	{
		this.ville = ville;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public void setListInvestissement(ArrayList<String> listInvestissement)
	{
		this.listInvestissement = listInvestissement;
	}

	public void setListCompte(ArrayList<Compte> listComptes)
	{
		this.listComptes = listComptes;
	}
	
	public abstract String getNum();

	//ToString
	//@Override
	//public String toString()
	//{
	//	return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
	//			+ ", ville=" + ville + ", telephone=" + telephone + ", listInvestissement=" + listInvestissement
	//			+ ", listComptes=" + listComptes + "]";
	//}
	
	// Methodes Metier
	// Ajouter un compte pour un client
	public boolean ajouterCompteCourant(double solde)
	{
		this.getListComptes().add(new CompteCourant(this.getNum() + this.getListComptes().size(), solde, Calendar.getInstance().getTime(), null,1000));
		return true;
	}
	
	// Consulter un client
	public void consulter()
	{
		System.out.println("Le client " + this.getNom() + " " + this.getPrenom() + " (" + this.getNum() + ") possede les comptes :");
		for(Compte compte : this.getListComptes())
		{
			compte.consulter();
		}
	}
	
	// Gerer le patrimoine en faisant des placements non toxiques
	public boolean gererPatrimoine(String numCompte, String bourse, double quantite)
	{
		for(Compte compte : this.getListComptes())
		{
			if(compte.getNumCompte().equals(numCompte))
			{
				if(compte.getSolde() <= 500000)
				{
					return false;
				}
				
				compte.setSolde(compte.getSolde() - quantite);
				this.listInvestissement.add(quantite + " investi � la bourse de " + bourse + ".");
				return true;
			}
		}
		return false;
	}
	
	// Simuler un credit de consommation
	public boolean simulerCreditConsommation()
	{
		double soldeTotal = 0;
		double montantPret = 0;
		float tauxPretConsommation = 0;
		int dureeMois = 0;
		for(Compte compte : this.getListComptes())
		{
			soldeTotal += compte.getSolde();
		}
			if (soldeTotal <= 5000)
			{
				tauxPretConsommation = 6;
				dureeMois = 36;	
				montantPret = 500;		
			}
			else if (soldeTotal <= 10000)
			{
				tauxPretConsommation = 5;
				dureeMois = 36;	
				montantPret = 2000;	
			}
			else 
			{
				tauxPretConsommation = 4;
				dureeMois = 24;	
				montantPret = 5000;	
			}
			System.out.println(this.nom + " " + this.prenom + " " + " votre agence ProxiBanque est en mesure de vous faire un pret à " + tauxPretConsommation + "% " +  "de jusqu'a " + montantPret + " € " + "a rendre en " + dureeMois + " mois");
			System.out.println("Le montant total à rendre est de " + montantPret * (100 + tauxPretConsommation) / 100 + "€ ");
		return true;
	}
	// Simuler un cr�dit immobilier
	public boolean simulerCreditImmobilier()
	{
		double soldeTotal = 0;
		double montantPret = 0;
		float tauxPretImmobilier = 0;
		int dureeMois = 0;
		for(Compte compte : this.getListComptes())
		{
			soldeTotal += compte.getSolde();
		}
			if (soldeTotal <= 50000)
			{
				tauxPretImmobilier = 2;
				dureeMois = 240;	
				montantPret = 100000;		
			}
			else if (soldeTotal <= 100000)
			{
				tauxPretImmobilier = 2;
				dureeMois = 300;	
				montantPret = 200000;	
			}
			else 
			{
				tauxPretImmobilier = 1;
				dureeMois = 240;	
				montantPret = 400000;	
			}
			System.out.println(this.nom + " " + this.prenom + " " + " votre agence ProxiBanque est en mesure de vous faire un pret à " + tauxPretImmobilier + "% " +  "de jusqu'à " + montantPret + " € " + "à rendre en " + dureeMois + " mois");
			System.out.println("Le montant total à rendre est de " + montantPret * (100 + tauxPretImmobilier) / 100 + "€ ");
		return true;
	}
}
