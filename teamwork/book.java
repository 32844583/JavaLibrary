public class book{
	private String name;
	private String publish;
	private String author;
	private String situation;
	private int count = 1;
	public book(String n, String p, String a){
		this.name = n;
		this.publish = p;
		this.author = a;
		setsituation("available");
	}
	public book(String n){
		this.name = n;
	}
	public String getname(){return name;}
	public String getpublish(){return publish;}
	public String getauthor(){return author;}
	public String getsituation(){return situation;}
	public void setname(String n){this.name = n;}
	public void setpublish(String p){this.publish = p;}
	public void setauthor(String a){this.author = a;}
	public void setsituation(String s){this.situation = s;}
	public void setcount(){this.count++;}
	public int getcount(){return count;}
}