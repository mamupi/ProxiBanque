package domaine;

import java.util.Date;

public class CompteCourant extends Compte
{
	//Attributs
	private double decouvertMax;
	
	//Constructeurs
	public CompteCourant(String numCompte, double solde, Date dateOuverture, String carteBancaire, double decouvertMax)
	{
		super(numCompte, solde, dateOuverture, carteBancaire);
		this.decouvertMax = decouvertMax;
	}
	
	//Gets and Sets
	public double getDecouvertMax()
	{
		return decouvertMax;
	}
	
	public void setDecouvertMax(double decouvertMax)
	{
		this.decouvertMax = decouvertMax;
	}

	
	//ToString
	//@Override
	//public String toString() {
	//	return "CompteCourant [decouvertMax=" + decouvertMax + "]";
	//}	
}
