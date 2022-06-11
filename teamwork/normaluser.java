import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class normaluser extends user{
	private ArrayList<userbook> userbooks = new ArrayList<userbook>();
	private ArrayList<userbook> history = new ArrayList<userbook>();
	private int lendup;
	private int money;
	public normaluser(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
		if(ident.equals("學生")) {
			this.lendup = 10;
		}
		else if(ident.equals("教員") || ident.equals("職員")) {
			this.lendup = 15;
		}
	}
	public void action(user u) {
		String login[] = { "登出", "查詢所有借閱資料", "搜尋書籍", "查詢排行榜", "繳納罰金" };
		int select;
		do {
			select = JOptionPane.showOptionDialog(null, u.getidentification() + u.getname() + "您好：", "一般使用者介面",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, login, null);
			switch (select) {
				case 1:
					watchinfo();
					break;
				case 2:
					addbook(u);
					break;
				case 3:
					ranking(u);
					break;
				case 4:
					payment();
			}
		} while (select != 0 && select != -1);

		if (select == -1) {
			JOptionPane.showMessageDialog(null, "請重新操作","登入系統",1);
		}
	}

	public void watchinfo() {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, １);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel());
			if(userbooks.size() > 0) {
				myPanel.add(new JLabel("書名　　　" + "狀態"));
				for (userbook ub : userbooks) {
					myPanel.add(new JLabel(ub.getname() + "　　"
							+ (ub.getsituation() == "reserved" ? "預約中" : "借閱中(至" + ub.getretrievedate() + ")")));
				}
			}
			else {
				myPanel.add(new JLabel("目前無借閱書籍"));
			}
			
			myPanel.add(new JLabel());
			if(history.size() > 0) {
				myPanel.add(new JLabel("歷史借閱紀錄"));
				myPanel.add(new JLabel("書名　　　" + "狀態"));
				for (userbook ub : history) {
					myPanel.add(new JLabel(ub.getname() + "　　" + "已歸還(於" + ub.getretrievedate() + ")"));
				}
			}
			else {
				myPanel.add(new JLabel("目前無借閱紀錄"));
			}
			myPanel.add(new JLabel());
			myPanel.add(new JLabel((getmoney() == 0? "目前無需繳納罰金":"目前需繳納罰金：	" + getmoney())));
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇歸還或要取消預約的書籍：");
			myPanel.add(label);
			for (userbook ub : userbooks) {
				comboBox.addItem(ub.getname());
			}
			if(userbooks.size() > 0) {
				comboBox.setSelectedIndex(0);
			}
			myPanel.add(comboBox);
			String retrieve_list[] = { "歸還或取消預約", "退出" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "所有借閱資料", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, retrieve_list, null);
			if (result == 0) {
				for (userbook ub : userbooks) {
					if (ub.getname() == comboBox.getSelectedItem().toString()) {
						if (ub.getsituation() == "reserved") {
							cancel_reserved(ub);
							JOptionPane.showMessageDialog(null, "取消預約！！","借閱系統",1);
						} else {
							removebook(new book("","",""), ub);
						}
						break;
					}
				}
			}
	}
	public void payment() {
		int i = Integer.parseInt(JOptionPane.showInputDialog(null, "請輸入欲繳納罰金"));
		if(money > i) {
			money -= i;
		}
		else {
			JOptionPane.showMessageDialog(null, "輸出超過繳納金額，請重新輸入");
			payment();
		}
	}
	public void removebook(book b, userbook ub) {
		adminstrator admin = new adminstrator("","","","");
		admin.user_retrieve(ub.getname());
		userbooks.remove(ub);
		history.add(ub);
		Date now = new Date();
		JOptionPane.showMessageDialog(null,
				"歸還成功！！\n" + (money_amount(ub, now) == 0 ? "無新增罰金" : "新增罰金" + money_amount(ub, now)),"還書系統",1);
		watchinfo();
	}

	public void addbook(user u) {
		userbook_manage ubm = new userbook_manage();
		adminstrator admin = new adminstrator("","","","");
		book adbook = new book("", "", "");
		search_books = admin.new_search_gui();
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0, 1);
		myPanel.setLayout(experimentLayout);
		myPanel.add(new JLabel("書名　　　出版社　　　作者　　　　狀態\n"));

		if (search_books.size() != 0) {
			for (book b : search_books) {
				myPanel.add(new JLabel(b.getname() + "　　　" + b.getpublish() + "　　　" + b.getauthor() + "　　　"
						+ (b.getsituation() == "available" ? "可借閱" : "已被借閱(至" + ubm.retrieve_date(b.getname()) + ")")));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇要借閱的書籍");
			myPanel.add(label);

			for (book b : search_books) {
				comboBox.addItem(b.getname());
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			String borrow_list[] = { "借閱", "退出" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "搜尋與借閱介面", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			adbook = admin.borrow_book_search(comboBox.getSelectedItem().toString());
			if (result == 0) {
				borrow_book_support(adbook, u);
			}
		} else {
			JOptionPane.showMessageDialog(null, "查無此書籍","搜尋與借閱系統",1);
		}
	}

	public void cancel_reserved(userbook ub) {
		userbooks.remove(ub);
	}

	public int money_amount(userbook ub, Date now) {
		long diff = now.getTime() - ub.getretrievedate2().getTime();
		if (diff < 0) {
			diff = 0;
		}
		TimeUnit time = TimeUnit.DAYS;
		long difference = time.convert(diff, TimeUnit.MILLISECONDS);
		int temp_money = (int) (difference) * 100;
		setmoney(temp_money);
		return temp_money;
	}

	public String getname() {return super.getname();}
	public int getlendup() {return lendup;}
	public int getmoney() {return money;}
	public void setmoney(int m) {this.money += m;}

	public String support_retrieve_date(String bkname) {
		for (userbook ub : userbooks) {
			if (ub.getname() == bkname) {
				return ub.getretrievedate();
			}
		}
		return "0";
	}
	public void borrow_book_support(book adbook, user u ) {
		userbook_manage ubm = new userbook_manage();
		if (userbooks.size() >= lendup) {
			JOptionPane.showMessageDialog(null, "超過借閱數量" ,"搜尋系統",1);
		} else {
			String response = "";
			if (adbook.getsituation() == "unavailable") {
				int you_borrow = 0;
				for (userbook ub : userbooks) {
					if (ub.getname() == adbook.getname()) {
						you_borrow = 1;
					}
				}
				if (you_borrow == 1) {
					response += "您已借閱, 不可重複借閱" + ubm.retrieve_date(adbook.getname());
					JOptionPane.showMessageDialog(null, response,"搜尋與借閱系統",1);
				} else {
					response += "\n此書已被別人借閱至" + ubm.retrieve_date(adbook.getname());
					JOptionPane.showMessageDialog(null, response,"搜尋與借閱系統",1);
					String reserve[] = { "預約", "退出" };
					int select = JOptionPane.showOptionDialog(null, "您要預約嗎？", null + "student",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, reserve, null);
					if (select == 0) {
						userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor(),
								"reserved");
						userbooks.add(ub);
					}
				}
			} else {
				userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor());
				JOptionPane.showMessageDialog(null, "借閱至" + ub.getretrievedate(),"搜尋與借閱系統",1);
				userbooks.add(ub);
				adbook.setsituation("unavailable");
				adbook.setcount();
			}
		}
	}
	public void ranking(user u) {
		adminstrator admin = new adminstrator("","","","");
		userbook_manage ubm = new userbook_manage();
		String[] t = admin.top3().split(",");

		if (4 > t.length && t.length > 0) {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, 1);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel("排行　　　書名　　　次數\n"));
			for (int i = 0; i < t.length; i++) {
				int amount = admin.borrow_book_search(t[i]).getcount();
				myPanel.add(new JLabel(i + 1 + "　　　" + t[i] + "　　　" + amount));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇要借閱的書籍：");
			myPanel.add(label);
			for (String s : t) {
				comboBox.addItem(s);
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			String borrow_list[] = { "借閱", "退出" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "借閱", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			book adbook = new book("", "", "");
			adbook = admin.borrow_book_search(comboBox.getSelectedItem().toString());
			if (result == 0) {
				borrow_book_support(adbook, u);
			}
		}
	}

}