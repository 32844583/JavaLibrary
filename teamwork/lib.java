import javax.swing.JOptionPane;
import java.util.ArrayList;

public class lib extends account_manage {
	public static void main(String[] args) {
		account_manage ac = new account_manage();
		adminstrator admin = new adminstrator("","","","");
		ac.initialize_user();
		admin.initialize_book();
		menu();
	}

	public static void menu() {
		String login[] = { "註冊", "登入", "訪客" };
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
				if (u.getidentification() == "教員") {
					teacher tea = new teacher(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addtea(tea);
					tea.action(u);

				} else if (u.getidentification().equals("學生")) {
					student stu = new student(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addstu(stu);
					stu.action(u);

				} else if (u.getidentification().equals("職員")) {
					staff sta = new staff(u.getname(), u.getaccount(), u.getpassword(), u.getidentification());
					ubm.addsta(sta);
					sta.action(u);

				} else if (u.getidentification().equals("管理員")) {
					adminstrator temp_bkm = new adminstrator(u.getname(), u.getaccount(), u.getpassword(),
							u.getidentification());
					temp_bkm.action(u);
				}
			} else if (select == 2) {
				visitor v = new visitor();
				v.action();
			}
		} while (select == 0 || select == 1 || select == 2 || select == 3);
		JOptionPane.showMessageDialog(null, "謝謝光臨","中大圖書系統",1);
	}

}