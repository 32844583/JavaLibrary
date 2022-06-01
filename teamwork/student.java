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
		String login[] = {"�n�X","�d�߭ӤH���","�j�M���y"};
		int select = JOptionPane.showOptionDialog(null,"�ǥ�" + this.name+"�z�n:","student", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
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
				myPanel.add(new JLabel("�ѦW:" + ub.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
		}
		myPanel.add(new JLabel("�ثe�ɾ\�ƶq:" + userbooks.size()));
		myPanel.add(new JLabel("�п�J�k�ٮѦW"));
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
			JOptionPane.showMessageDialog(null, "�k�٦��\!!");
			watchinfo();
		}
		else{JOptionPane.showMessageDialog(null, "�z�L�ɾ\�����y!");}
	}
     	public void borrow_book(){
		userbook_manage ubm = new userbook_manage();
		book_manage bm = new book_manage();
		book adbook = bm.usersea();
		if(adbook.getname() == "no this book"){JOptionPane.showMessageDialog(null, "�d�L�����y");}
		else{
			String response = "";
			response += "�ѦW:" + adbook.getname() + "\n�X����:" + adbook.getpublish() + "\n�@��:" + adbook.getauthor();

			if(adbook.getsituation() == "unavailable"){
				String r_date = ubm.retrieve_date(adbook.getname());
				response += "\n���Ѥw�Q�ɾ\��" + r_date;
				JOptionPane.showMessageDialog(null, response);
			}
			else{
				response += "\n�ثe�i�ɾ\" ;
				String borrow[] = {"�ɾ\", "���ɾ\"};
				int select = JOptionPane.showOptionDialog(null,"�ثe�i�ɾ\",null+"student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,borrow,null);
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