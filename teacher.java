import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class teacher extends normaluser {
	private ArrayList<book> search_books = new ArrayList<book>();
	private ArrayList<userbook> userbooks = new ArrayList<userbook>();
	private ArrayList<userbook> history = new ArrayList<userbook>();
	private int money;
	private int lendup;

	public teacher(String n, String acc, String pass, String ident) {
		super(n, acc, pass, ident);
		this.lendup = 15;
	}

	public void action() {
		String login[] = { "登出", "查詢所有借閱資料", "搜尋書籍", "查詢排行榜" };
		int select;
		do {
<<<<<<< HEAD
			select = JOptionPane.showOptionDialog(null, "老師" + super.getname() + "您好：", "一般使用者介面",
=======
			select = JOptionPane.showOptionDialog(null, "�Юv" + super.getname() + "�z�n�G", "�@��ϥΪ̤���",
>>>>>>> 32cdc9c (java)
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, login, null);
			switch (select) {
				case 1:
					watchinfo();
					break;
				case 2:
					borrow_book();
					break;
				case 3:
					ranking();
					break;
			}
		} while (select != 0 && select != -1);

		if (select == -1) {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "請重新操作");
		}
	}

=======
			JOptionPane.showMessageDialog(null, "�Э��s�ާ@","�n�J�t��",1);
		}
	}

	
>>>>>>> 32cdc9c (java)

	public void watchinfo() {
		if (userbooks.size() > 0) {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, １);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel("書名　　　" + "狀態"));
			for (userbook ub : userbooks) {
				myPanel.add(new JLabel(ub.getname() + "　　"
						+ (ub.getsituation() == "reserved" ? "預約中" : "借閱中(至" + ub.getretrievedate() + ")")));
			}
			for (userbook ub : history) {
				myPanel.add(new JLabel(ub.getname() + "　　" + "已歸還(於" + ub.getretrievedate() + ")"));
			}
			myPanel.add(new JLabel("目前借閱數量：	" + userbooks.size()));
			myPanel.add(new JLabel("目前需繳納罰金：	" + money));
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇歸還或要取消預約的書籍：");
			myPanel.add(label);
			for (userbook ub : userbooks) {
				comboBox.addItem(ub.getname());
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			String retrieve_list[] = { "取消預約", "不動作" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "所有借閱資料", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, retrieve_list, null);
			if (result == 0) {
				for (userbook ub : userbooks) {
					if (ub.getname() == comboBox.getSelectedItem().toString()) {
						if (ub.getsituation() == "reserved") {
							cancel_reserved(ub);
<<<<<<< HEAD
							JOptionPane.showMessageDialog(null, "取消預約！！");
=======
							JOptionPane.showMessageDialog(null, "�����w���I�I","�j�M�P�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
						} else {
							retrieve(ub);
						}
						break;
					}
				}
			}
		} else {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, 1);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel("書名　　　" + "狀態"));
			myPanel.add(new JLabel("目前借閱數量：　" + userbooks.size()));
			myPanel.add(new JLabel("目前需繳納罰金：　" + money));
			for (userbook ub : history) {
				myPanel.add(new JLabel(ub.getname() + "　　" + "已歸還(於" + ub.getretrievedate() + ")"));
			}
			JOptionPane.showMessageDialog(null, myPanel,"�ٮѨt��",1);
		}

	}

	public void retrieve(userbook ub) {
		book_manage bkm = new book_manage();
		bkm.user_retrieve(ub.getname());
		userbooks.remove(ub);
		history.add(ub);
		Date now = new Date();
		JOptionPane.showMessageDialog(null,
<<<<<<< HEAD
				"歸還成功！！\n" + (money_amount(ub, now) == 0 ? "無新增罰金" : "新增罰金" + money_amount(ub, now)));
=======
				"�k�٦��\�I�I\n" + (money_amount(ub, now) == 0 ? "�L�s�W�@��" : "�s�W�@��" + money_amount(ub, now)),"�ٮѨt��",1);
>>>>>>> 32cdc9c (java)
		watchinfo();
	}

	public void borrow_book() {
		userbook_manage ubm = new userbook_manage();
		book_manage bm = new book_manage();
		book adbook = new book("", "", "");
		search_books = bm.new_search_gui();
		for (book b : search_books) {
			System.out.println(b.getname());
		}
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
			String borrow_list[] = { "借閱", "不動作" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "搜尋與借閱介面", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
			if (result == 0) {
				if (userbooks.size() >= this.lendup) {
<<<<<<< HEAD
					JOptionPane.showMessageDialog(null, "超過借閱數量");
=======
					JOptionPane.showMessageDialog(null, "�W�L�ɾ\�ƶq","�j�M�P�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
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
<<<<<<< HEAD
							response += "您已借閱, 不可重複借閱" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response);
						} else {
							response += "\n此書已被別人借閱至" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response);
							String reserve[] = { "預約", "不動作" };
							int select = JOptionPane.showOptionDialog(null, "您要預約嗎？", null + "student",
=======
							response += "�z�w�ɾ\, ���i���ƭɾ\" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"�j�M�P�ɾ\�t��",1);
						} else {
							response += "\n���Ѥw�Q�O�H�ɾ\��" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"�j�M�P�ɾ\�t��",1);
							String reserve[] = { "�w��", "���ʧ@" };
							int select = JOptionPane.showOptionDialog(null, "�z�n�w���ܡH", null + "student",
>>>>>>> 32cdc9c (java)
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, reserve, null);
							if (select == 0) {
								userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor(),
										"reserved");
								userbooks.add(ub);
							}
						}
					} else {
						userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor());
<<<<<<< HEAD
						JOptionPane.showMessageDialog(null, "借閱至" + ub.getretrievedate());
=======
						JOptionPane.showMessageDialog(null, "�ɾ\��" + ub.getretrievedate(),"�j�M�P�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
						userbooks.add(ub);
						adbook.setsituation("unavailable");
						adbook.setcount();
					}
				}
			}
		} else {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "查無此書籍");
=======
			JOptionPane.showMessageDialog(null, "�d�L�����y","�j�M�P�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
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
		money += temp_money;
		return temp_money;
	}

	public String getname() {
		return super.getname();
	}

	public String support_retrieve_date(String bkname) {
		for (userbook ub : userbooks) {
			if (ub.getname() == bkname) {
				return ub.getretrievedate();
			}
		}
		return "0";
	}
}