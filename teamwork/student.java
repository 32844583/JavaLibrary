import javax.swing.*;
import java.awt.*;
import java.util.*;
public class student{
	static ArrayList <book> search_books = new ArrayList <book>();
	static ArrayList<userbook> userbooks = new ArrayList<userbook>();
	private String name;
	private String account;
	private String password;
	private String identification;
	private int lendup;
	public student(String n, String acc, String pass, String ident){
		this.name = n;
		this.account = acc;
		this.password = pass;
		this.identification = ident;
		this.lendup = 10;
	}
	public void action(){
		String login[] = {"登出","查詢個人資料","搜尋書籍"};
		int select = JOptionPane.showOptionDialog(null,"學生" + this.name+"您好:","student", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
		if (select !=0){
			switch (select){
         			case 1:
            				watchinfo();
            				break;
         			case 2:
            				borrow_book();
            				break;
       			}
			action();
		}
		
	}
	public void watchinfo(){
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
		for (userbook ub:userbooks){
				myPanel.add(new JLabel("書名:" + ub.getname() + (ub.getsituation()=="reserved"? "預約":"借閱至" + ub.getretrievedate())));
				myPanel.add(Box.createHorizontalStrut(15));

		}
		myPanel.add(new JLabel("目前借閱數量:" + userbooks.size()));
		final JComboBox<String> comboBox = new JComboBox<String>();
		JLabel label = new JLabel("請選擇歸還或要取消預約的書籍:");
		myPanel.add(label);
		for(userbook ub : userbooks){
			comboBox.addItem(ub.getname());
		}
        comboBox.setSelectedIndex(0);
        myPanel.add(comboBox);
		int result = JOptionPane.showConfirmDialog(null, myPanel,"retrieve",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			for(userbook ub:userbooks){
				if(ub.getname() == comboBox.getSelectedItem().toString()){
					if(ub.getsituation() == "reserved"){
						cancel_reserved(ub);
						JOptionPane.showMessageDialog(null, "取消預約!!");
					}
					else{
						retrieve(ub);
					}
					break;
				}
			}
			
		}
		
	}
	public void retrieve(userbook ub){
			book_manage bkm = new book_manage();
			bkm.user_retrieve(ub.getname());
			userbooks.remove(ub);
			JOptionPane.showMessageDialog(null, "歸還成功!!");
			watchinfo();
	}
	public void borrow_book(){
	userbook_manage ubm = new userbook_manage();
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
	
	for (book b:search_books){
		myPanel.add(new JLabel("書名:" + b.getname()));
		myPanel.add(Box.createHorizontalStrut(15));
	}
	
	final JComboBox<String> comboBox = new JComboBox<String>();
	JLabel label = new JLabel("請選擇要借閱的書籍");
	myPanel.add(label);
	
	
	for(book b : search_books){
		comboBox.addItem(b.getname());
	}
	comboBox.setSelectedIndex(0);
	myPanel.add(comboBox);
	int result = JOptionPane.showConfirmDialog(null, myPanel,"search",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
	if(result == JOptionPane.OK_OPTION){
		if(userbooks.size() >= this.lendup){
		JOptionPane.showMessageDialog(null, "超過借閱數量");
	}
	else{
		if(search_books.size() == 0){JOptionPane.showMessageDialog(null, "查無此書籍");}
		else{
			String response = "";
			response += "書名:" + adbook.getname() + "\n出版社:" + adbook.getpublish() + "\n作者:" + adbook.getauthor();
			if(adbook.getsituation() == "unavailable"){
				int you_borrow = 0;
				for(userbook ub : userbooks){
					if(ub.getname() == adbook.getname()){
						you_borrow = 1;
					}
				}
				System.out.println(adbook.getname());
				String r_date = ubm.retrieve_date(adbook.getname());
				if(you_borrow == 1){
					response += "\n你已借閱此書至" + r_date;
					JOptionPane.showMessageDialog(null, response);
				}
				else{
					response += "\n此書已被別人借閱至" + r_date;
					JOptionPane.showMessageDialog(null, response);
					String reserve[] = {"預約", "不預約"};
					int select = JOptionPane.showOptionDialog(null,"您要預約嗎?",null+"student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,reserve,null);
					if(select == 0){
						userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor(), "reserved");
						userbooks.add(ub);
					}
				}
				
			}
			else{
				response += "\n目前可借閱" ;
				String borrow[] = {"借閱", "不借閱"};
				int select = JOptionPane.showOptionDialog(null,response,null+"student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,borrow,null);
				if(select == 0){
					userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor());
					JOptionPane.showMessageDialog(null, "借閱至" + ub.getretrievedate());
					userbooks.add(ub);
					adbook.setsituation("unavailable");
					
				}
			}
			
		}
	}
	}
	
}
	public void cancel_reserved(userbook ub){
		userbooks.remove(ub);
	}
	public String really(String bkname){
		for(userbook ub : userbooks){
			if (ub.getname() == bkname){
				return ub.getretrievedate();
			}
		}
		return "";
	}
	public String getname(){return name;}
}