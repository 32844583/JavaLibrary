import javax.swing.*;
import java.awt.*;
import java.util.*;
public class student{
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
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
		for (userbook ub:userbooks){
				myPanel.add(new JLabel("書名:" + ub.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
		}
		myPanel.add(new JLabel("目前借閱數量:" + userbooks.size()));
		myPanel.add(new JLabel("請輸入歸還書名"));
		JTextField xField = new JTextField(5);
		myPanel.add(xField);
		int result = JOptionPane.showConfirmDialog(null, myPanel,"retrieve", JOptionPane.OK_CANCEL_OPTION);
     		if (result == JOptionPane.OK_OPTION) {
			retrieve(xField.getText());
      		}
	}
	public void retrieve(String bkname){
		userbook retrieve_book= new userbook("","","","");
		int check = 0;
		for (userbook ub: userbooks){
			if (ub.getname().equals(bkname)){
				retrieve_book = ub;
			}
		}
		if (retrieve_book.getname() != ""){
			book_manage bkm = new book_manage();
			bkm.user_retrieve(retrieve_book.getname());
			userbooks.remove(retrieve_book);
			JOptionPane.showMessageDialog(null, "歸還成功!!");
			watchinfo();
		}
		else{JOptionPane.showMessageDialog(null, "您無借閱此書籍!");}
	}
     	public void borrow_book(){
		userbook_manage ubm = new userbook_manage();
		book_manage bm = new book_manage();
		book adbook = bm.usersea();
		if(adbook.getname() == "no this book"){JOptionPane.showMessageDialog(null, "查無此書籍");}
		else{
			String response = "";
			response += "書名:" + adbook.getname() + "\n出版社:" + adbook.getpublish() + "\n作者:" + adbook.getauthor();

			if(adbook.getsituation() == "unavailable"){
				String r_date = ubm.retrieve_date(adbook.getname());
				response += "\n此書已被借閱至" + r_date;
				JOptionPane.showMessageDialog(null, response);
			}
			else{
				response += "\n目前可借閱" ;
				String borrow[] = {"借閱", "不借閱"};
				int select = JOptionPane.showOptionDialog(null,"目前可借閱",null+"student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,borrow,null);
				switch (select){
         					case 0:
					userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor(), this.name);
					userbooks.add(ub);
					adbook.setsituation("unavailable");
					break;
				}
			}
			
		}
   	}
	public String support_retrieve_date(String bkname){
		for(userbook ub: userbooks){
			if(ub.getname() == bkname){
				return ub.getretrievedate();
			}
		}
		return "0";
	}
}