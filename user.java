import java.util.ArrayList;

public abstract class user{
	private String name;
	private String account;
	private String password;
	private String identification;
	public ArrayList<book> search_books = new ArrayList<book>();
	public user(String n, String acc, String pass, String ident){
		setname(n);
		setaccount(acc);
		setpassword(pass);
		setidentification(ident);

	}

	public abstract void watchinfo();
	public abstract void addbook(user u);
	public abstract void removebook(book b, userbook ub);
	public String getname(){return name;}
	public String getaccount(){return account;}
	public String getpassword(){return password;}
	public String getidentification(){return identification;}

	public void setname(String n){this.name = n;}
	public void setaccount(String acc){this.account = acc;}
	public void setpassword(String pass){this.password = pass;}
	public void setidentification(String ident) {this.identification = ident;}

}