import java.util.*;
import java.awt.*;
import javax.swing.*;
public class book_manage{
	static ArrayList<book> books  = new ArrayList<book>();
	private ArrayList <book> allbook = new ArrayList <book>();
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
		books.add(new book("book3", "book3", "book3"));		
	}
	public book borrow_book_search(String bkname){
		book bk = new book("");
		for(book b : books){
			if(b.getname().equals(bkname)){
				bk = b;
				System.out.println("find");
			}
		}
		
		return bk;
	}
	public ArrayList new_search_gui() {
	JTextField xField = new JTextField(5);
	JPanel myPanel = new JPanel();
	GridLayout experimentLayout = new GridLayout(0,3);
	myPanel.setLayout(experimentLayout);
<<<<<<< HEAD
	myPanel.add(new JLabel("ÃƒÃ¶ÃÃ¤Â¦rÂ·jÂ´M:"));
=======
	myPanel.add(new JLabel("ÃöÁä¦r·j´M¡G"));
>>>>>>> 32cdc9c (java)
	myPanel.add(xField);

	int result = JOptionPane.showConfirmDialog(null, myPanel,"®ÑÄy·j´M¨t²Î", JOptionPane.OK_CANCEL_OPTION);
	System.out.println(result);
	if(result == 2) {
<<<<<<< HEAD
		JOptionPane.showMessageDialog(null, "Â¨ÃºÂ®Ã¸Â·jÂ´M");
=======
		JOptionPane.showMessageDialog(null, "¨ú®ø·j´M","®ÑÄy¬d¸ß",1);
>>>>>>> 32cdc9c (java)
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
	public String top3(){
		TreeMap<Integer, String> ht = new TreeMap<Integer, String>();
		for(book bk:books){
			ht.put(bk.getcount(), bk.getname());
			System.out.println("success");
		}
		String s = "";
		Set<Integer> keySet = ht.descendingKeySet();
		for (Integer key : keySet) {
            // Print key:value of the TreeMap
            s += ht.get(key)+",";
        }
		System.out.println("the sequence is" + s);
		return s; 
		
	}
	public void show(){
		for(book b : books){
			System.out.println(b.getname());
		}
	}
   public void add() {
	      JTextField xField = new JTextField(5);
	      JTextField yField = new JTextField(5);
	      JTextField zField = new JTextField(5);
	 
	      JPanel myPanel = new JPanel();
	      GridLayout experimentLayout = new GridLayout(0,3);
	      myPanel.setLayout(experimentLayout);
<<<<<<< HEAD
	      myPanel.add(new JLabel("æ›¸åï¼š"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("ä½œè€…ï¼š"));
	      myPanel.add(yField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("å‡ºç‰ˆç¤¾ï¼š"));
	      myPanel.add(zField);

	      String add_button[] = {"ç¢ºèªå¢žåŠ ", "å–æ¶ˆ"};
	      int result = JOptionPane.showOptionDialog(null, myPanel,"å¢žåŠ æ›¸ç±", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, add_button,null);
=======
	      myPanel.add(new JLabel("®Ñ¦W¡G"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("§@ªÌ¡G"));
	      myPanel.add(yField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("¥Xª©ªÀ¡G"));
	      myPanel.add(zField);

	      String add_button[] = {"½T»{¼W¥[", "¨ú®ø"};
	      int result = JOptionPane.showOptionDialog(null, myPanel,"¼W¥[®ÑÄy", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, add_button,null);
>>>>>>> 32cdc9c (java)
	      if (result == JOptionPane.OK_OPTION) {
	    	  books.add(new book(xField.getText(), yField.getText(), zField.getText()));
	      }
	   }
}