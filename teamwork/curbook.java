import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class curbook{
	private String name;
	private String borrower;
	private String publish;
	private String author;
	private String borrow_date;
	private String retrieve_date;
	public curbook(String n, String p, String a, String bor){
		this.name = n;
		this.publish = p;
		this.author = a;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date borrow = new Date();
		Date retrieve;
		Calendar c = Calendar.getInstance();
		c.setTime(borrow);
		c.add(Calendar.DATE, 10);
		retrieve = c.getTime();
		this.retrieve_date = dateFormat.format(retrieve);
		this.borrow_date = dateFormat.format(borrow);
		this.borrower = bor;
	}
	public curbook(String n){
		this.name = n;
	}
	public String getname(){return name;}
	public String getpublish(){return publish;}
	public String getauthor(){return author;}
	public String getretrievedate(){return retrieve_date;}
	public String getborrower(){return borrower;}
	public void setname(String n){this.name = n;}
	public void setpublish(String p){this.publish = p;}
	public void setauthor(String a){this.author = a;}
	
}