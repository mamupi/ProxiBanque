package domaine;

import java.util.Date;

public class CompteEpargne extends Compte
{
	//Attributs
	private float tauxRemuneration;
	
	//Constructeurs
	public CompteEpargne(String numCompte, double solde, Date dateOuverture, String carteBancaire, float tauxRemuneration)
	{
		super(numCompte, solde, dateOuverture, carteBancaire);
		this.tauxRemuneration = tauxRemuneration;
	}
	
	//Gets and Sets
	public float getTauxRemuneration()
	{
		return tauxRemuneration;
	}

	public void setTauxRemuneration(float tauxRemuneration)
	{
		this.tauxRemuneration = tauxRemuneration;
	}
	
	//ToString
	//@Override
	//public String toString()
	//{
	//	return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + "]";
	//}
}
