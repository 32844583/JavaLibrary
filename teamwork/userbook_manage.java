import javax.swing.JOptionPane;
import java.util.*;
public class userbook_manage{
	static ArrayList<student> students = new ArrayList<student>();
	public void addstu(student s){students.add(s);}
	
	public String retrieve_date(String bkname){
		for(student s : students){
			if(s.really(bkname) != ""){
				return s.really(bkname);
			}
		}
		return "0";
	}
	
}