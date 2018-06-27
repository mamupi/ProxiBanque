package administrateur;

public class User
{
	private String id;
	private String password;
	private String role;
	private int num;
	
	public User(String id, String password)
	{
		this.id = id;
		this.password = password;
		this.role = "Conseiller";
	}
	
	public User(String id, String password, String role)
	{
		this(id, password);
		this.role = role;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
}

