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
		String login[] = {"登出","查看或編輯使用者","編輯或刪除書籍","新增書籍"};
		int select;
		do{
<<<<<<< HEAD
			select = JOptionPane.showOptionDialog(null,"管理員"+u.getname()+"你好, 請問您要?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
=======
			select = JOptionPane.showOptionDialog(null,"�޲z��"+u.getname()+"�A�n�A�аݱz�n�H",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
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
			JOptionPane.showMessageDialog(null, "請重新操作");
		}
		else if(select == 0) {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "登出");
=======
			JOptionPane.showMessageDialog(null, "�n�X","���j�ϮѨt��",1);
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
				myPanel.add(new JLabel("書名:" + b.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇要編輯的書籍");
=======
				myPanel.add(new JLabel("�ѦW�G" + b.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("�п�ܭn�s�誺���y");
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
				String login[] = {"編輯","刪除","驗證"};
				int select = JOptionPane.showOptionDialog(null,"請問您要","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
=======
				String login[] = {"�s��","�R��","����"};
				int select = JOptionPane.showOptionDialog(null,"�аݱz�n","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
>>>>>>> 32cdc9c (java)
				
				if (select !=3){
					switch (select){
		         			case 0:
		            			revise(adbook);
		            			break;
		         			case 1:
		            			bm.remove(adbook);
<<<<<<< HEAD
								JOptionPane.showMessageDialog(null, "刪除成功!");
=======
								JOptionPane.showMessageDialog(null, "�R�����\�I","���y�s��t��",1);
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
			JOptionPane.showMessageDialog(null, "查無此書籍");
=======
			JOptionPane.showMessageDialog(null, "�d�L�����y","���y�s��t��",1);
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
			myPanel.add(new JLabel("想修改哪一項呢?"));
			myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("書名:"));
      		myPanel.add(xField);
      		myPanel.add(new JLabel("作者:"));
      		myPanel.add(yField);
      		myPanel.add(new JLabel("出版社:"));
=======
			myPanel.add(new JLabel("�Q�ק���@���O�H"));
			myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("�ѦW�G"));
      		myPanel.add(xField);
      		myPanel.add(new JLabel("�@�̡G"));
      		myPanel.add(yField);
      		myPanel.add(new JLabel("�X�����G"));
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