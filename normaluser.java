import javax.swing.*;
import java.awt.*;
import java.util.*;

public abstract class normaluser extends user{
	private int lendup;
	private ArrayList<book> search_books = new ArrayList<book>();
	public normaluser(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
	}
	public abstract void borrow_book();
	public abstract void watchinfo();
	public void ranking() {
		book_manage bm = new book_manage();
		userbook_manage ubm = new userbook_manage();
		String[] t = bm.top3().split(",");

		if (4 > t.length && t.length > 0) {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, 1);
			myPanel.setLayout(experimentLayout);
<<<<<<< HEAD
			myPanel.add(new JLabel("排行\t書名\n"));
=======
			myPanel.add(new JLabel("�Ʀ�\t�ѦW\n"));
>>>>>>> 32cdc9c (java)
			for (int i = 0; i < t.length; i++) {
				myPanel.add(new JLabel(i + 1 + "\t" + t[i]));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
<<<<<<< HEAD
			JLabel label = new JLabel("請選擇要借閱的書籍：");
=======
			JLabel label = new JLabel("�п�ܭn�ɾ\�����y�G");
>>>>>>> 32cdc9c (java)
			myPanel.add(label);
			for (String s : t) {
				comboBox.addItem(s);
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
<<<<<<< HEAD
			String borrow_list[] = { "借閱", "不動作" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "借閱", JOptionPane.YES_NO_OPTION,
=======
			String borrow_list[] = { "�ɾ\", "���ʧ@" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "�ɾ\�t��", JOptionPane.YES_NO_OPTION,
>>>>>>> 32cdc9c (java)
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			book adbook = new book("", "", "");
			adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
			System.out.println(adbook.getname());
			if (result == 0) {
				if (userbooks.size() >= this.lendup) {
<<<<<<< HEAD
					JOptionPane.showMessageDialog(null, "超過借閱數量");
=======
					JOptionPane.showMessageDialog(null, "�W�L�ɾ\�ƶq","�ɾ\�t��",1);
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
							JOptionPane.showMessageDialog(null, response,"�ɾ\�t��",1);
						} else {
							response += "\n���Ѥw�Q�O�H�ɾ\��" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"�ɾ\�t��",1);
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
						JOptionPane.showMessageDialog(null, "�ɾ\��" + ub.getretrievedate(),"�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
						userbooks.add(ub);
						adbook.setsituation("unavailable");
						adbook.setcount();
					}
				}
			}
		} else {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "目前無書籍！");
=======
			JOptionPane.showMessageDialog(null, "�ثe�L���y�I","�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
		}
	}

}