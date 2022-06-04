public class staff extends user{
	private int lendup;
	public staff (String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
		this.lendup = 10;
	}
}