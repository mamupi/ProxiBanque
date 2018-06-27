package domaine;

import java.util.Calendar;

public class ClientEntreprise extends Client
{
	//Attributs
	private String numSIRET;

	//Constructeurs
	public ClientEntreprise(String nom, String prenom, String adresse, String codePostal, String ville,
			String telephone, String listInvestissement, String numSIRET) {
		super(nom, prenom, adresse, codePostal, ville, telephone, listInvestissement);
		this.numSIRET = numSIRET;
	}

	//Gets and Sets
	public String getNum()
	{
		return numSIRET;
	}
	
	//ToString
	//@Override
	//public String toString()
	//{
	//	return "ClientEntreprise [numSIRET=" + numSIRET + "]";
	//}
}
