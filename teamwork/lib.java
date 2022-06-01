import javax.swing.JOptionPane; 
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class lib extends account_manage{
	public static void main(String [] args){
		menu();
	}
	public static void menu(){
		String login[] = {"查詢用","註冊","登入"};
    	int select = JOptionPane.showOptionDialog(null,"歡迎來到中大借書系統!", "lib",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,1);
       	account_manage ac = new account_manage();
		switch (select){
         			
			case 1:ac.add();break;

			case 2:
				String na = ac.login();
				user temp_u = new user("empty","empty","empty","empty");
				for(user i : users){
					if(i.getname().equals(na)){
						temp_u = i;
					}
				}
				String identitor = temp_u.getidentification();
				if (identitor  == "Teacher"){
					
				}
				else if (identitor.equals("Student")){
					student temp_stu = new student(temp_u.getname(), temp_u.getaccount(), temp_u.getpassword(), temp_u.getidentification());
					temp_stu.action(temp_u);
				}
				else if (identitor  == "Staff"){
				}
				else if (identitor.equals("Admin")){
					adminstrator temp_bkm = new adminstrator(temp_u.getname(), temp_u.getaccount(), temp_u.getpassword(), temp_u.getidentification());
					temp_bkm.action(temp_u);
				}
				else{System.out.println("No Existing");}
				break;
			case 3:ac.show();break;
       			}
	if (select !=4){menu();}}
	
}