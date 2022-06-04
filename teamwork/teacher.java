public class teacher extends user{
	private int lendup;
	public teacher (String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
		this.lendup = 10;
	}
}