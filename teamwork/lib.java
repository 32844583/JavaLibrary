import javax.swing.JOptionPane; 
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class lib extends account_manage{
	public static void main(String [] args){
		account_manage ac = new account_manage();
		ac.initialize_user();
		book_manage bm = new book_manage();
		bm.initialize_book();
		menu();
	}
	public static void menu(){
		String login[] = {"���U","�n�J","�d�ߥ�","�X��"};
    	int select = JOptionPane.showOptionDialog(null,"�w��Ө줤�j�ɮѨt��!", "lib",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,1);
       	account_manage ac = new account_manage();
		while(select ==0 || select ==1 || select ==2 || select ==3){
			if (select == 0){
				ac.add();
			}

			if(select == 1){
				user u = ac.login();
				userbook_manage ubm = new userbook_manage();
				if (u.getidentification()  == "Teacher"){
					
				}
				else if (u.getidentification().equals("Student")){
					student stu = new student(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addstu(stu);
					stu.action();
					
				}
				else if (u.getidentification()  == "Staff"){
				}
				else if (u.getidentification().equals("Admin")){
					adminstrator temp_bkm = new adminstrator(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					temp_bkm.action(u);
				}
				else{System.out.println("No Existing");}
			}
			if(select == 3){
				visitor v = new visitor();
				v.action();
			}
			if (select == 2){ac.show();}
			menu();
		}
	
       	}
	
}