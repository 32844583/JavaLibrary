public class user{
	private String name;
	private String account;
	private String password;
	private String identification;
	public user(String n, String acc, String pass, String ident){
		this.name = n;
		this.account = acc;
		this.password = pass;
		this.identification = ident;
	}
	public book searchbook(){
		book_manage b = new book_manage();
		return b.sea();
	}
	public String getname(){return name;}
	public String getaccount(){return account;}
	public String getpassword(){return password;}
	public String getidentification(){return identification;}
}