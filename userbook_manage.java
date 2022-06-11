import javax.swing.JOptionPane;
import java.util.*;
public class userbook_manage{
	static ArrayList<student> students = new ArrayList<student>();
	static ArrayList<staff> staffs = new ArrayList<staff>();
	static ArrayList<teacher> teachers = new ArrayList<teacher>();
	public void addstu(student s){students.add(s);}
	public void addsta(staff f){staffs.add(f);}
	public void addtea(teacher t){teachers.add(t);}

	public String retrieve_date(String bkname){
		for(student s : students){
			if(s.support_retrieve_date(bkname) != ""){
				return s.support_retrieve_date(bkname);
			}
		}
		return "0";
	}

	
}