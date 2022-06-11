public abstract class user{
	private String name;
	private String account;
	private String password;
	private String identification;
	public user(String n, String acc, String pass, String ident){
		setname(n);
		setaccount(acc);
		setpassword(pass);
		setidentification(ident);
	}


	public String getname(){return name;}
	public String getaccount(){return account;}
	public String getpassword(){return password;}
	public String getidentification(){return identification;}
	public void setname(String n){this.name = n;}
	public void setaccount(String acc){this.account = acc;}
	public void setpassword(String pass){this.password = pass;}
	public void setidentification(String ident) {this.identification = ident;}
}