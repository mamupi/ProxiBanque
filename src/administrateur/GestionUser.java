package administrateur;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionUser
{
	private ArrayList<User> listUsers;
	private Scanner sc;
	private User activ;
	
	public GestionUser()
	{
		this.listUsers = new ArrayList<User>();
		this.sc = new Scanner(System.in);
		this.activ = null;
	}
	
	public User getActiv()
	{
		return this.activ;
	}
	
	public void setActiv(User user)
	{
		this.activ = user;
	}
	
	public ArrayList<User> getListUsers()
	{
		return this.listUsers;
	}
	
	public boolean connection()
	{
		System.out.println("Bonjour, veuillez entrer votre nom utilisateur :");
		String id = sc.nextLine();
		
		for(User user1 : this.listUsers)
		{
			if(id.equals(user1.getId()))
			{
				System.out.println("Quel est votre mot de passe ?");
				String password = sc.nextLine();
				for(User user2 : this.listUsers)
				{
					if(password.equals(user2.getPassword()))
					{
						this.activ=user2;
						return true;
					}
				}
			}
		}
		return false;
	}
	
}


