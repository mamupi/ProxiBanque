package domaine;

import java.util.Calendar;

public class ClientParticulier extends Client
{
	//Attributs
	private String numSecu;

	//Constructeurs
	public ClientParticulier(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, String listInvestissement, String numSecu)
	{
		super(nom, prenom, adresse, codePostal, ville, telephone, listInvestissement);
		this.numSecu = numSecu;
	}

	//Gets and Sets
	public String getNum()
	{
		return numSecu;
	}
	
	public boolean ajouterCompteEpargne(double solde)
	{
		this.getListComptes().add(new CompteEpargne(this.getNum() + this.getListComptes().size(), solde, Calendar.getInstance().getTime(), null,1000));
		return true;
	}
		
	//@Override

	
	//ToString
	//@Override
	//public String toString()
	//{
	//	return "ClientParticulier [numSecu=" + numSecu + "]";
	//}
}