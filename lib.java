import javax.swing.JOptionPane;
import java.util.ArrayList;

public class lib extends account_manage {
	public static void main(String[] args) {
		account_manage ac = new account_manage();
		ac.initialize_user();
		book_manage bm = new book_manage();
		bm.initialize_book();
		menu();
	}

	public static void menu() {
<<<<<<< HEAD
		String login[] = { "註冊", "登入", "訪客" };
=======
		String login[] = { "���U", "�n�J", "�X��" };
>>>>>>> 32cdc9c (java)
		int select;
		account_manage ac = new account_manage();
		do {
			select = JOptionPane.showOptionDialog(null, "歡迎來到中大借書系統！", "中大借閱系統", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, login, 1);
			if (select == 0) {
				ac.regis();
			}

			if (select == 1) {
				user u = ac.login();
				userbook_manage ubm = new userbook_manage();
				if (u.getidentification() == "�Э�") {
					teacher tea = new teacher(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addtea(tea);
					tea.action();

				} else if (u.getidentification().equals("�ǥ�")) {
					student stu = new student(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addstu(stu);
					stu.action();

				} else if (u.getidentification().equals("¾��")) {
					staff sta = new staff(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addsta(sta);
					sta.action();

				} else if (u.getidentification().equals("�޲z��")) {
					adminstrator temp_bkm = new adminstrator(u.getname(), u.getaccount(), u.getpassword(),
							u.getidentification());
					temp_bkm.action(u);
				} else {
					System.out.println("No Existing");
				}
			} else if (select == 2) {
				visitor v = new visitor();
				v.action();
			}
		} while (select == 0 || select == 1 || select == 2 || select == 3);
<<<<<<< HEAD
		JOptionPane.showMessageDialog(null, "謝謝光臨");
=======
		JOptionPane.showMessageDialog(null, "���¥��{","���j�ϮѨt��",1);
>>>>>>> 32cdc9c (java)
	}

}