import javax.swing.JOptionPane;
import java.util.*;
public class userbook_manage{
	static ArrayList<curbook> curbooks  = new ArrayList<curbook>();
	public void add(book ad, user u){
		curbook cb = new curbook(ad.getname(), ad.getpublish(), ad.getauthor(), u.getname());
		curbooks.add(cb);
	}
	public void remove(curbook b){
		curbooks.removeIf(curbook -> curbook.getname() == b.getname());
	}
	public int count(user u){
		int total = 0;
		for(curbook cb:curbooks){
			if(cb.getborrower() == u.getname()){ 
				total += 1;
			}
		}
		return total;
	}
	
}