import javax.swing.JOptionPane;
import java.util.ArrayList;
public class lib extends account_manage{
	public static void main(String [] args){
		menu();
	}
	public static void menu(){

       	int select = Integer.parseInt(JOptionPane.showInputDialog("�w��Ө줤�j�ɮѨt��! \n(1)���U \n(2)�n�J \n(3)�d�ߥثe�Ҧ��b��(���ҥ�)"));
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
				if (identitor  == "teacher"){
					
				}
				else if (identitor.equals("student")){
					student temp_stu = new student(temp_u.getname(), temp_u.getaccount(), temp_u.getpassword(), temp_u.getidentification());
					temp_stu.action(temp_u);
				}
				else if (identitor  == "staff"){
				}
				else if (identitor.equals("admin")){
					adminstrator temp_bkm = new adminstrator(temp_u.getname(), temp_u.getaccount(), temp_u.getpassword(), temp_u.getidentification());
					temp_bkm.action(temp_u);
				}
				else{System.out.println("no existing");}
				break;
			case 3:ac.show();break;
       			}
	if (select !=4){menu();}}
	
}