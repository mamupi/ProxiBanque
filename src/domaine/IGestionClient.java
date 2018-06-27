package domaine;

public interface IGestionClient
{
	//M�thodes de travail
	
	//Ajoute un nouveau client
	public boolean enregistrerClient(Client client);
	
	//Recherche et affichage de client
	public void trouverClient(String numSecu);
	
	//R�aliser un transfert de solde entre comptes
	public boolean faireVirement(String numCompte1, String numCompte2, double montant);
	
	//Supprime un client
	public void supprimerClient(String num);
}
