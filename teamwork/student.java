import javax.swing.*;
import java.awt.*;
import java.util.*;
public class student extends userbook_manage{
	private int lendup;
	static ArrayList<curbook> temp_curbooks  = new ArrayList<curbook>();
	public student(String n, String acc, String pass, String ident){
		this.lendup = 10;
	}
	public void action(user u){
		int select = Integer.parseInt(JOptionPane.showInputDialog(null, "�ǥ�" + u.getname()+"�z�n: \n(1)�d�߭ӤH��� \n(2)�j�M \n(3)�n�X\n"));
		if (select !=3){
			switch (select){
         			case 1:
            				watchinfo(u);
            				break;
         			case 2:
            				addcur(u);
            				break;
       			}
			action(u);
		}
		
	}
	public void watchinfo(user u){
		String display = "";
		userbook_manage ubm = new userbook_manage();
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
		for (curbook cb:curbooks){
			if(cb.getborrower().equals(u.getname())){
				temp_curbooks.add(cb);
				myPanel.add(new JLabel("�ѦW:" + cb.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
		}
		myPanel.add(new JLabel("�ثe�ɾ\�ƶq:" + ubm.count(u)));
		myPanel.add(new JLabel("�п�J�k�ٮѦW"));
		JTextField xField = new JTextField(5);
		myPanel.add(xField);
		int result = JOptionPane.showConfirmDialog(null, myPanel,"retrieve", JOptionPane.OK_CANCEL_OPTION);
     		if (result == JOptionPane.OK_OPTION) {
			retrieve(xField.getText());
      		}
	}
	public void retrieve(String bkname){
		curbook temp = new curbook("","","","");
		for (curbook cb:curbooks){
			if(cb.getname().equals(bkname)){
				temp = cb;
			}
		}
		remove(temp);
		
		JOptionPane.showMessageDialog(null, "�k�٦��\!!");
		
	}
     	public void addcur(user u){
		int check = 0;
		book_manage bm = new book_manage();
		book adbook = bm.usersea();
		if(adbook.getname() == "no this book"){JOptionPane.showMessageDialog(null, "�d�L�����y");}
		else{
			String response = "";
			curbook borrowed = new curbook("","","","");
			for(curbook cb:curbooks){
				if (adbook.getname().equals(cb.getname())){
					response += "�ѦW:" + adbook.getname() + "\n�X����:" + adbook.getpublish() + "\n�@��:" + adbook.getpublish();
						borrowed = cb;
				
				}
			}
			if(borrowed.getname() == ""){
				response += "\n�ثe�i�ɾ\" ;
				check = 1;
				int select = Integer.parseInt(JOptionPane.showInputDialog(response + " \n(1)�ɾ\ \n(2)���ɾ\"));
				switch (select){
         					case 1:
					add(adbook, u);
					adbook.setsituation("unavailable");
					break;
				}
			}
			else{
				response += "\n���Ѥw�Q" + borrowed.getborrower() + "�ɨ��Щ�" + borrowed.getretrievedate() + "��A���d��";
				JOptionPane.showMessageDialog(null, response);
			}
			
		}
   	}
}