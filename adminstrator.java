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
		String login[] = {"�n�X","�d�ݩνs��ϥΪ�","�s��ΧR�����y","�s�W���y"};
		int select;
		do{
			select = JOptionPane.showOptionDialog(null,"�޲z��"+u.getname()+"�A�n�A�аݱz�n�H",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
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
			JOptionPane.showMessageDialog(null, "�Э��s�ާ@");
		}
		else if(select == 0) {
			JOptionPane.showMessageDialog(null, "�n�X","���j�ϮѨt��",1);
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
				myPanel.add(new JLabel("�ѦW�G" + b.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("�п�ܭn�s�誺���y");
			myPanel.add(label);
			
			
			for(book b : search_books){
			 comboBox.addItem(b.getname());
			}
			
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			
			int result = JOptionPane.showConfirmDialog(null, myPanel,"search",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == 0) {
				adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
				String login[] = {"�s��","�R��","����"};
				int select = JOptionPane.showOptionDialog(null,"�аݱz�n","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
				
				if (select !=3){
					switch (select){
		         			case 0:
		            			revise(adbook);
		            			break;
		         			case 1:
		            			bm.remove(adbook);
								JOptionPane.showMessageDialog(null, "�R�����\�I","���y�s��t��",1);
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
			JOptionPane.showMessageDialog(null, "�d�L�����y","���y�s��t��",1);
		}
	}
	public void revise(book b){
			JTextField xField = new JTextField(b.getname());
      		JTextField yField = new JTextField(b.getauthor());
      		JTextField zField = new JTextField(b.getpublish());
 
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,2);
			myPanel.add(new JLabel("�Q�ק���@���O�H"));
			myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("�ѦW�G"));
      		myPanel.add(xField);
      		myPanel.add(new JLabel("�@�̡G"));
      		myPanel.add(yField);
      		myPanel.add(new JLabel("�X�����G"));
      		myPanel.add(zField);

      		int result = JOptionPane.showConfirmDialog(null, myPanel,"revise", JOptionPane.OK_CANCEL_OPTION);
      		if (result == JOptionPane.OK_OPTION) {
			b.setname(xField.getText());
			b.setpublish(yField.getText());
			b.setauthor(zField.getText());
      		}
	}
}