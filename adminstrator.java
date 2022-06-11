import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class adminstrator extends user{
	static ArrayList <book> search_books = new ArrayList <book>();
	private String name;
	private String account;
	private String password;
	private String identification;
	public adminstrator(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
	}
	public void action(user u){
		book_manage b = new book_manage();
		account_manage acm = new account_manage();
		String login[] = {"ÁôªÂá∫","Êü•ÁúãÊàñÁ∑®ËºØ‰ΩøÁî®ËÄÖ","Á∑®ËºØÊàñÂà™Èô§Êõ∏Á±ç","Êñ∞Â¢ûÊõ∏Á±ç"};
		int select;
		do{
<<<<<<< HEAD
			select = JOptionPane.showOptionDialog(null,"ÁÆ°ÁêÜÂì°"+u.getname()+"‰Ω†Â•Ω, Ë´ãÂïèÊÇ®Ë¶Å?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
=======
			select = JOptionPane.showOptionDialog(null,"∫ﬁ≤z≠˚"+u.getname()+"ßA¶n°AΩ–∞›±z≠n°H",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
>>>>>>> 32cdc9c (java)
			switch (select){
         		case 1:
         			acm.watch_user(u);
         			break;
         		case 2:
         			edit(u);
         			break;
				case 3:
					b.add();
					break;
   			}
		}while(select != -1 && select != 0);
		if(select == -1) {
			JOptionPane.showMessageDialog(null, "Ë´ãÈáçÊñ∞Êìç‰Ωú");
		}
		else if(select == 0) {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "ÁôªÂá∫");
=======
			JOptionPane.showMessageDialog(null, "µn•X","§§§jπœÆ—®t≤Œ",1);
>>>>>>> 32cdc9c (java)
		}
		
		
	}
	
	
	public void edit(user u){
		book_manage bm = new book_manage();
		book adbook = new book("","","");
		search_books = bm.new_search_gui();
		for(book b : search_books){
		 System.out.println(b.getname());
		}
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
		if(search_books.size() != 0){
			for (book b:search_books){
<<<<<<< HEAD
				myPanel.add(new JLabel("Êõ∏Âêç:" + b.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("Ë´ãÈÅ∏ÊìáË¶ÅÁ∑®ËºØÁöÑÊõ∏Á±ç");
=======
				myPanel.add(new JLabel("Æ—¶W°G" + b.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("Ω–øÔæ‹≠nΩsøË™∫Æ—ƒy");
>>>>>>> 32cdc9c (java)
			myPanel.add(label);
			
			
			for(book b : search_books){
			 comboBox.addItem(b.getname());
			}
			
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			
			int result = JOptionPane.showConfirmDialog(null, myPanel,"search",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == 0) {
				adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
<<<<<<< HEAD
				String login[] = {"Á∑®ËºØ","Âà™Èô§","È©óË≠â"};
				int select = JOptionPane.showOptionDialog(null,"Ë´ãÂïèÊÇ®Ë¶Å","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
=======
				String login[] = {"ΩsøË","ßR∞£","≈Á√“"};
				int select = JOptionPane.showOptionDialog(null,"Ω–∞›±z≠n","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
>>>>>>> 32cdc9c (java)
				
				if (select !=3){
					switch (select){
		         			case 0:
		            			revise(adbook);
		            			break;
		         			case 1:
		            			bm.remove(adbook);
<<<<<<< HEAD
								JOptionPane.showMessageDialog(null, "Âà™Èô§ÊàêÂäü!");
=======
								JOptionPane.showMessageDialog(null, "ßR∞£¶®•\°I","Æ—ƒyΩsøË®t≤Œ",1);
>>>>>>> 32cdc9c (java)
		            			break;
		         			case 2:
								bm.show();
								break;
		   			}
					
					action(u);
				}
			}
		}
			
		else {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "Êü•ÁÑ°Ê≠§Êõ∏Á±ç");
=======
			JOptionPane.showMessageDialog(null, "¨dµL¶πÆ—ƒy","Æ—ƒyΩsøË®t≤Œ",1);
>>>>>>> 32cdc9c (java)
		}
	}
	public void revise(book b){
			JTextField xField = new JTextField(b.getname());
      		JTextField yField = new JTextField(b.getauthor());
      		JTextField zField = new JTextField(b.getpublish());
 
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,2);
<<<<<<< HEAD
			myPanel.add(new JLabel("ÊÉ≥‰øÆÊîπÂì™‰∏ÄÈ†ÖÂë¢?"));
			myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("Êõ∏Âêç:"));
      		myPanel.add(xField);
      		myPanel.add(new JLabel("‰ΩúËÄÖ:"));
      		myPanel.add(yField);
      		myPanel.add(new JLabel("Âá∫ÁâàÁ§æ:"));
=======
			myPanel.add(new JLabel("∑Q≠◊ßÔ≠˛§@∂µ©O°H"));
			myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("Æ—¶W°G"));
      		myPanel.add(xField);
      		myPanel.add(new JLabel("ß@™Ã°G"));
      		myPanel.add(yField);
      		myPanel.add(new JLabel("•X™©™¿°G"));
>>>>>>> 32cdc9c (java)
      		myPanel.add(zField);

      		int result = JOptionPane.showConfirmDialog(null, myPanel,"revise", JOptionPane.OK_CANCEL_OPTION);
      		if (result == JOptionPane.OK_OPTION) {
			b.setname(xField.getText());
			b.setpublish(yField.getText());
			b.setauthor(zField.getText());
      		}
	}
}