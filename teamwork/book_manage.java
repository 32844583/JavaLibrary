import javax.swing.JOptionPane;
import java.util.*;
public class book_manage{
	static ArrayList<book> books  = new ArrayList<book>();
	public void add(){
		addbook a = new addbook();
		String information;
		information = a.gui();
		String[] info_part = information.split("-");
		// System.out.print(a.getname() + getpublish() + getauthor());
		books.add(new book(info_part [0], info_part [2], info_part [1]));
	}
	public void remove(book b){
		books.removeIf(book -> book.getname() == b.getname());
	}
	public book sea(){
		search se = new search();
		return se.search_gui();
	}
	public book usersea(){
		search se = new search();
		return se.search_gui();
	}
	public void show(){
		String respon="" ;
		for (book b:books){
		respon += "�ѦW:" + b.getname() + "\n"+ "�X����" + b.getpublish() + "\n" +"�@��:" + b.getauthor() + "\n";}
		JOptionPane.showMessageDialog(null,"\n�ثe���y�ƶq" + books.size() + "\n"+ respon );
	}
	
}