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
		String login[] = { "è¨»å†Š", "ç™»å…¥", "è¨ªå®¢" };
=======
		String login[] = { "µù¥U", "µn¤J", "³X«È" };
>>>>>>> 32cdc9c (java)
		int select;
		account_manage ac = new account_manage();
		do {
			select = JOptionPane.showOptionDialog(null, "æ­¡è¿ä¾†åˆ°ä¸­å¤§å€Ÿæ›¸ç³»çµ±ï¼", "ä¸­å¤§å€Ÿé–±ç³»çµ±", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, login, 1);
			if (select == 0) {
				ac.regis();
			}

			if (select == 1) {
				user u = ac.login();
				userbook_manage ubm = new userbook_manage();
				if (u.getidentification() == "±Ğ­û") {
					teacher tea = new teacher(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addtea(tea);
					tea.action();

				} else if (u.getidentification().equals("¾Ç¥Í")) {
					student stu = new student(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addstu(stu);
					stu.action();

				} else if (u.getidentification().equals("Â¾­û")) {
					staff sta = new staff(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addsta(sta);
					sta.action();

				} else if (u.getidentification().equals("ºŞ²z­û")) {
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
		JOptionPane.showMessageDialog(null, "è¬è¬å…‰è‡¨");
=======
		JOptionPane.showMessageDialog(null, "ÁÂÁÂ¥úÁ{","¤¤¤j¹Ï®Ñ¨t²Î",1);
>>>>>>> 32cdc9c (java)
	}

}