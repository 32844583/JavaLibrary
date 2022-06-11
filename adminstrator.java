import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class adminstrator extends user{
	static ArrayList<book> books  = new ArrayList<book>();
	private ArrayList <book> allbook = new ArrayList <book>();
	public adminstrator(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
	}
	public void action(user u){
		account_manage acm = new account_manage();
		String login[] = {"登出","查看或編輯使用者","編輯或刪除書籍","新增書籍","查看所有書籍"};
		int select;
		do{
			select = JOptionPane.showOptionDialog(null,"管理員"+u.getname()+"你好，請問您要？",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
			switch (select){
         		case 1:
         			watchinfo();
         			break;
         		case 2:
         			edit(u);
         			break;
				case 3:
					addbook(u);
					break;
				case 4:
					watch_book();
   			}
		}while(select != -1 && select != 0);
		if(select == -1) {
			JOptionPane.showMessageDialog(null, "請重新操作");
		}
	}
	public void edit(user u){
		book adbook = new book("","","");
		search_books = new_search_gui();
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
		if(search_books.size() != 0){
			for (book b:search_books){
				myPanel.add(new JLabel("書名：" + b.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇要編輯的書籍");
			myPanel.add(label);
			
			
			for(book b : search_books){
			 comboBox.addItem(b.getname());
			}
			
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			
			int result = JOptionPane.showConfirmDialog(null, myPanel,"search",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == 0) {
				adbook = borrow_book_search(comboBox.getSelectedItem().toString());
				String login[] = {"編輯","刪除","退出"};
				int select;
				
				do{
					select = JOptionPane.showOptionDialog(null,"請問您要","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
					switch (select){
		         			case 0:
		            			revise(adbook);
		            			break;
		         			case 1:
		         				removebook(adbook, new userbook("","",""));
								JOptionPane.showMessageDialog(null, "刪除成功！","書籍編輯系統",1);
		            			break;
		   			}
				}while(select == 0 || select == 1);
			}
		}
			
		else {
			JOptionPane.showMessageDialog(null, "查無此書籍","書籍編輯系統",1);
		}
	}
	public void addbook(user u) {
	      JTextField xField = new JTextField(5);
	      JTextField yField = new JTextField(5);
	      JTextField zField = new JTextField(5);
	 
	      JPanel myPanel = new JPanel();
	      GridLayout experimentLayout = new GridLayout(0,3);
	      myPanel.setLayout(experimentLayout);
	      myPanel.add(new JLabel("書名："));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("作者："));
	      myPanel.add(yField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("出版社："));
	      myPanel.add(zField);

	      String add_button[] = {"確認增加", "取消"};
	      int result = JOptionPane.showOptionDialog(null, myPanel,"增加書籍", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, add_button,null);
	      if (result == JOptionPane.OK_OPTION) {
	    	  books.add(new book(xField.getText(), yField.getText(), zField.getText()));
	      }
	}
	public void removebook(book b, userbook ub) {
		books.remove(b);
	}
	public void watchinfo() {
		account_manage acc = new account_manage();
		acc.watch_user();
	}
	public void revise(book b){
			JTextField xField = new JTextField(b.getname());
      		JTextField yField = new JTextField(b.getauthor());
      		JTextField zField = new JTextField(b.getpublish());
 
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,2);
			myPanel.add(new JLabel("想修改哪一項呢？"));
			myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("書名："));
      		myPanel.add(xField);
      		myPanel.add(new JLabel("作者："));
      		myPanel.add(yField);
      		myPanel.add(new JLabel("出版社："));
      		myPanel.add(zField);

      		int result = JOptionPane.showConfirmDialog(null, myPanel,"revise", JOptionPane.OK_CANCEL_OPTION);
      		if (result == JOptionPane.OK_OPTION) {
      			int check = 0;
      			for(book bb : books) {
      				if(bb.getname().equals(xField.getText())) {
      					check = 1;
      				}
      			}
      			if(check == 0) {
      				b.setname(xField.getText());
      				b.setpublish(yField.getText());
      				b.setauthor(zField.getText());
      			}
      			else {
      				JOptionPane.showMessageDialog(null, "書籍名稱重複","書籍編輯系統",1);
      				revise(b);
      			}

      		}
	}
	   public void watch_book() {
			if (books.size() > 0) {
				JFrame jf = new JFrame();
				jf.setSize(500, 500);
				jf.setLocationRelativeTo(null);
				JPanel myPanel = new JPanel();
				GridLayout experimentLayout = new GridLayout(0, １);
				myPanel.setLayout(experimentLayout);
				myPanel.add(new JLabel("書名　　　" + "出版社　　　"+ "作者"));
				for (book b : books) {
					myPanel.add(new JLabel(b.getname() + "　　" + b.getpublish() +"　　　" + b.getauthor()));
				}
				myPanel.add(new JLabel("目前書籍數量：	" + books.size()));
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				JLabel label = new JLabel("請選擇編輯或是要刪除的書籍：");
				myPanel.add(label);
				for (book b : books) {
					comboBox.addItem(b.getname());
				}
				comboBox.setSelectedIndex(0);
				myPanel.add(comboBox);
				String retrieve_list[] = { "編輯", "刪除", "退出" };
				int select;
				do {
					book action_book = new book("", "", "");
					select = JOptionPane.showOptionDialog(null,myPanel, "所有借閱資料",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, retrieve_list, null);
					for (book b : books) {
						if (b.getname().equals(comboBox.getSelectedItem().toString())) {
							action_book = b;
						}
					}
					switch (select) {
					
						case 0:
							revise(action_book);
							break;
						case 1:
							removebook(action_book, new userbook("","",""));
							break;
					}
				} while (select == 0 && select == 1);
			}

	   }
	   public ArrayList new_search_gui() {
			JTextField xField = new JTextField(5);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0,3);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel("關鍵字搜尋："));
			myPanel.add(xField);

			int result = JOptionPane.showConfirmDialog(null, myPanel,"書籍搜尋系統", JOptionPane.OK_CANCEL_OPTION);
			if(result == 2) {
				JOptionPane.showMessageDialog(null, "取消搜尋","書籍查詢",1);
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
	   public void initialize_book(){
			books.add(new book("book1", "book1", "book1"));
			books.add(new book("book2", "book2", "book2"));
			books.add(new book("book3", "book3", "book3"));		
		}
	   public void add(book b) {
	   		books.add(b);
	   }
	   public String top3(){
			TreeMap<Integer, String> ht = new TreeMap<Integer, String>();
			for(book bk:books){
				ht.put(bk.getcount(), bk.getname());
			}
			String s = "";
			Set<Integer> keySet = ht.descendingKeySet();
			for (Integer key : keySet) {
	            // Print key:value of the TreeMap
	            s += ht.get(key)+",";
	        }
			return s; 
			
		}
		public book borrow_book_search(String bkname){
			book bk = new book("");
			for(book b : books){
				if(b.getname().equals(bkname)){
					bk = b;
				}
			}
			
			return bk;
		}
		public void user_retrieve(String bkname){
			for (book b:books){
				if(b.getname() == bkname){
					b.setsituation("available");
				}
			}
		}
		
}
