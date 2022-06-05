import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class userbook{
	private String name;
	private String publish;
	private String author;
	private String borrow_date;
	private String retrieve_date;
	private Date borrow;
	private Date retrieve;
	private String situation;
	//­É¾\
	public userbook(String n, String p, String a){
		setname(n);
		setpublish(p);
		setauthor(a);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date borrow = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(borrow);
		c.add(Calendar.DATE, 10);
		this.retrieve = c.getTime();
		this.retrieve_date = dateFormat.format(retrieve);
		this.borrow_date = dateFormat.format(borrow);
		
	}
	//¹w¬ù
	public userbook(String n, String p, String a, String s){
		setname(n);
		setpublish(p);
		setauthor(a);
		setsituation(s);
	}
	
	public userbook(String n){
		this.name = n;
	}
	public String getname(){return name;}
	public String getpublish(){return publish;}
	public String getauthor(){return author;}
	public String getretrievedate(){return retrieve_date;}
	public String getborrowdate(){return borrow_date;}
	public String getsituation(){return situation;}
	public Date getretrievedate2(){return retrieve;}
	public void setname(String n){this.name = n;}
	public void setpublish(String p){this.publish = p;}
	public void setauthor(String a){this.author = a;}
	public void setsituation(String s){this.situation = s;}
}