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
		int select = Integer.parseInt(JOptionPane.showInputDialog(null, "學生" + u.getname()+"您好: \n(1)查詢個人資料 \n(2)搜尋 \n(3)登出\n"));
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
				myPanel.add(new JLabel("書名:" + cb.getname()));
				myPanel.add(Box.createHorizontalStrut(15));
			}
		}
		myPanel.add(new JLabel("目前借閱數量:" + ubm.count(u)));
		myPanel.add(new JLabel("請輸入歸還書名"));
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
		
		JOptionPane.showMessageDialog(null, "歸還成功!!");
		
	}
     	public void addcur(user u){
		int check = 0;
		book_manage bm = new book_manage();
		book adbook = bm.usersea();
		if(adbook.getname() == "no this book"){JOptionPane.showMessageDialog(null, "查無此書籍");}
		else{
			String response = "";
			curbook borrowed = new curbook("","","","");
			for(curbook cb:curbooks){
				if (adbook.getname().equals(cb.getname())){
					response += "書名:" + adbook.getname() + "\n出版社:" + adbook.getpublish() + "\n作者:" + adbook.getpublish();
						borrowed = cb;
				
				}
			}
			if(borrowed.getname() == ""){
				response += "\n目前可借閱" ;
				check = 1;
				int select = Integer.parseInt(JOptionPane.showInputDialog(response + " \n(1)借閱 \n(2)不借閱"));
				switch (select){
         					case 1:
					add(adbook, u);
					adbook.setsituation("unavailable");
					break;
				}
			}
			else{
				response += "\n此書已被" + borrowed.getborrower() + "借走請於" + borrowed.getretrievedate() + "後再次查看";
				JOptionPane.showMessageDialog(null, response);
			}
			
		}
   	}
}