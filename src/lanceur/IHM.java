package lanceur;

import java.util.Scanner;

import domaine.ClientParticulier;

import administrateur.GestionUser;
import administrateur.User;
import domaine.Conseiller;
import domaine.GerantAgence;

public class IHM
{
	//Début de dévellopement d'une interface utilisateur. Celle ci n'est pas totalement implémenté et nous n'avons pas eu le temps de tout débuggé.
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		char sortie = ' ';
		
		GestionUser adminUser = new GestionUser();
		
		adminUser.getListUsers().add(new User("Gerant","1234","Gerant"));
		GerantAgence gerant = new GerantAgence("Gerant", "Agance", null);
		
		boolean session = true;
		while(true)
		{
			while(adminUser.getActiv() == null)
			{
				if(adminUser.connection())
				{
					System.out.println("Bienvenu " + adminUser.getActiv().getId());
				}
				else
				{
					System.out.println("Tentative de connection echoue.");
				}
			}
				
			while(session)
			{
				sortie = ' ';
				System.out.println("\nQue souhaitez vous faire ?");
				
				if(adminUser.getActiv().getRole().equals("Gerant"))
				{
					while(sortie != '1' && sortie != '2' && sortie != '3' && sortie != '4')
					{
						System.out.println("1 : Ajouter un Conseiller.\n2 : Ajouter un nouveau Client.\n3 : Chercher un client.\n4 : Quitter l'outil.");
						sortie = sc.nextLine().charAt(0);
					}
				}
				else
				{
					while(sortie != '2' && sortie != '3' && sortie != '4')
					{
						System.out.println("2 : Ajouter un nouveau Client.\n3 : Chercher un client.\n4 : Quitter l'outil.");
						sortie = sc.nextLine().charAt(0);
					}			
				}
				
				if(sortie == '1')
				{
					String nom;
					String prenom;
					String idConseiller;
					String mdp;
					
					System.out.println("Veuillez saisir le nom du conseiller.");
					nom = sc.nextLine();
					
					System.out.println("Veuillez saisir le prenom du conseiller.");
					prenom = sc.nextLine();
					
					System.out.println("Veuillez saisir l'identifiant du conseiller.");
					idConseiller = sc.nextLine();
					
					System.out.println("Veuillez saisir le mot de passe du conseiller.");
					mdp = sc.nextLine();
					
					User user = new User(nom, prenom);
					adminUser.getListUsers().add(user);
					user.setNum(adminUser.getListUsers().size()-2);
					gerant.enregistrerConseiller(new Conseiller(idConseiller, mdp));
				}
				else if(sortie == '2')
				{
					System.out.println("Quel type de client ?");
					do
					{
						System.out.println("1 : Particulier.\n2 : Professionnel.");
						sortie = sc.nextLine().charAt(0);
					}
					while(sortie != '1' && sortie != '2');
					
					String nom;
					String prenom;
					String adresse;
					String codePostal;
					String ville;
					String telephone;
					String num;
					
					System.out.println("Veuillez saisir le nom du client.");
					nom = sc.nextLine();
					
					System.out.println("Veuillez saisir le prenom du client.");
					prenom = sc.nextLine();
		
					System.out.println("Veuillez saisir l'adresse du client.");
					adresse = sc.nextLine();
					
					System.out.println("Veuillez saisir le codePostal du client.");
					codePostal = sc.nextLine();
					
					System.out.println("Veuillez saisir la ville du client.");
					ville = sc.nextLine();
					
					System.out.println("Veuillez saisir le telephone du client.");
					telephone = sc.nextLine();
					
					if(sortie == '1')
					{
						System.out.println("Veuillez saisir le numero de securite social du client.");
						
					}
					else if(sortie == '2')
					{
						System.out.println("Veuillez saisir le numero SIRET du client.");
					}
					
					num = sc.nextLine();
					
					if(adminUser.getActiv().getRole().equals("Gerant"))
					{
						gerant.enregistrerClient(new ClientParticulier(nom, prenom, adresse, codePostal, ville, telephone, "",num));
					}
					else
					{
						gerant.getListConseillers().get(adminUser.getActiv().getNum()).enregistrerClient(new ClientParticulier(nom, prenom, adresse, codePostal, ville, telephone, "",num));
					}
				}
				else if(sortie == '3')
				{
					System.out.println("Veuillez saisir l'identifiant du client.");
					String num = sc.nextLine();
					
					if(adminUser.getActiv().getRole().equals("Gerant"))
					{
						gerant.trouverClient(num);
					}
					else
					{
						gerant.getListConseillers().get(adminUser.getActiv().getNum()).trouverClient(num);
					}
				}
				else if(sortie == '4')
				{
					System.out.println("\nVoici l'etat de l'agence :\n");
					gerant.consulter();
					
					System.out.println("FIN DE PROGRAMME");
					
					sc.close();
					System.exit(0);
				}
			}
		}
	}
}
