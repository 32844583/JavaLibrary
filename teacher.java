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
		String login[] = { "�n�X", "�d�ߩҦ��ɾ\���", "�j�M���y", "�d�߱Ʀ�]" };
		int select;
		do {
			select = JOptionPane.showOptionDialog(null, "�Юv" + super.getname() + "�z�n�G", "�@��ϥΪ̤���",
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
			JOptionPane.showMessageDialog(null, "�Э��s�ާ@","�n�J�t��",1);
		}
	}

	

	public void watchinfo() {
		if (userbooks.size() > 0) {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, ��);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel("�ѦW�@�@�@" + "���A"));
			for (userbook ub : userbooks) {
				myPanel.add(new JLabel(ub.getname() + "�@�@"
						+ (ub.getsituation() == "reserved" ? "�w����" : "�ɾ\��(��" + ub.getretrievedate() + ")")));
			}
			for (userbook ub : history) {
				myPanel.add(new JLabel(ub.getname() + "�@�@" + "�w�k��(��" + ub.getretrievedate() + ")"));
			}
			myPanel.add(new JLabel("�ثe�ɾ\�ƶq�G	" + userbooks.size()));
			myPanel.add(new JLabel("�ثe��ú�ǻ@���G	" + money));
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("�п���k�٩έn�����w�������y�G");
			myPanel.add(label);
			for (userbook ub : userbooks) {
				comboBox.addItem(ub.getname());
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			String retrieve_list[] = { "�����w��", "���ʧ@" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "�Ҧ��ɾ\���", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, retrieve_list, null);
			if (result == 0) {
				for (userbook ub : userbooks) {
					if (ub.getname() == comboBox.getSelectedItem().toString()) {
						if (ub.getsituation() == "reserved") {
							cancel_reserved(ub);
							JOptionPane.showMessageDialog(null, "�����w���I�I","�j�M�P�ɾ\�t��",1);
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
			myPanel.add(new JLabel("�ѦW�@�@�@" + "���A"));
			myPanel.add(new JLabel("�ثe�ɾ\�ƶq�G�@" + userbooks.size()));
			myPanel.add(new JLabel("�ثe��ú�ǻ@���G�@" + money));
			for (userbook ub : history) {
				myPanel.add(new JLabel(ub.getname() + "�@�@" + "�w�k��(��" + ub.getretrievedate() + ")"));
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
				"�k�٦��\�I�I\n" + (money_amount(ub, now) == 0 ? "�L�s�W�@��" : "�s�W�@��" + money_amount(ub, now)),"�ٮѨt��",1);
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
		myPanel.add(new JLabel("�ѦW�@�@�@�X�����@�@�@�@�̡@�@�@�@���A\n"));

		if (search_books.size() != 0) {
			for (book b : search_books) {
				myPanel.add(new JLabel(b.getname() + "�@�@�@" + b.getpublish() + "�@�@�@" + b.getauthor() + "�@�@�@"
						+ (b.getsituation() == "available" ? "�i�ɾ\" : "�w�Q�ɾ\(��" + ubm.retrieve_date(b.getname()) + ")")));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("�п�ܭn�ɾ\�����y");
			myPanel.add(label);

			for (book b : search_books) {
				comboBox.addItem(b.getname());
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			String borrow_list[] = { "�ɾ\", "���ʧ@" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "�j�M�P�ɾ\����", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
			if (result == 0) {
				if (userbooks.size() >= this.lendup) {
					JOptionPane.showMessageDialog(null, "�W�L�ɾ\�ƶq","�j�M�P�ɾ\�t��",1);
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
							response += "�z�w�ɾ\, ���i���ƭɾ\" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"�j�M�P�ɾ\�t��",1);
						} else {
							response += "\n���Ѥw�Q�O�H�ɾ\��" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"�j�M�P�ɾ\�t��",1);
							String reserve[] = { "�w��", "���ʧ@" };
							int select = JOptionPane.showOptionDialog(null, "�z�n�w���ܡH", null + "student",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, reserve, null);
							if (select == 0) {
								userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor(),
										"reserved");
								userbooks.add(ub);
							}
						}
					} else {
						userbook ub = new userbook(adbook.getname(), adbook.getpublish(), adbook.getauthor());
						JOptionPane.showMessageDialog(null, "�ɾ\��" + ub.getretrievedate(),"�j�M�P�ɾ\�t��",1);
						userbooks.add(ub);
						adbook.setsituation("unavailable");
						adbook.setcount();
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "�d�L�����y","�j�M�P�ɾ\�t��",1);
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