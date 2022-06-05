
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class book_manage{
	static ArrayList<book> books  = new ArrayList<book>();
	private ArrayList <book> allbook = new ArrayList <book>();
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
	public void user_retrieve(String bkname){
		for (book b:books){
			if(b.getname() == bkname){
				b.setsituation("available");
			}
		}
	}
	public void initialize_book(){
		books.add(new book("book1", "book1", "book1"));
		books.add(new book("book2", "book2", "book2"));
	}
	public book borrow_book_search(String bkname){
		book bk = new book("");
		for(book b : books){
			if(b.getname() == bkname){
				bk = b;
			}
		}
		
		return bk;
	}
	public ArrayList new_search_gui() {
	JTextField xField = new JTextField(5);
	JPanel myPanel = new JPanel();
	GridLayout experimentLayout = new GridLayout(0,3);
	myPanel.setLayout(experimentLayout);
	myPanel.add(new JLabel("ÃöÁä¦r·j´M:"));
	myPanel.add(xField);

	int result = JOptionPane.showConfirmDialog(null, myPanel,"Search", JOptionPane.OK_CANCEL_OPTION);
	System.out.println(result);
	if(result == 2) {
		JOptionPane.showMessageDialog(null, "¨ú®ø·j´M");
	}
	else {
		for(book b : books){
			if (b.getname().contains(xField.getText())){ allbook.add(b);}
			else if(b.getpublish().contains(xField.getText())){ allbook.add(b);}
			else if(b.getauthor().contains(xField.getText())){ allbook.add(b);}
		}
	}
	return allbook;
	}
}