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
			myPanel.add(new JLabel("排行\t書名\n"));
			for (int i = 0; i < t.length; i++) {
				myPanel.add(new JLabel(i + 1 + "\t" + t[i]));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
			JLabel label = new JLabel("請選擇要借閱的書籍：");
			myPanel.add(label);
			for (String s : t) {
				comboBox.addItem(s);
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
			String borrow_list[] = { "借閱", "不動作" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "借閱", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			book adbook = new book("", "", "");
			adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
			System.out.println(adbook.getname());
			if (result == 0) {
				if (userbooks.size() >= this.lendup) {
					JOptionPane.showMessageDialog(null, "超過借閱數量");
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
							JOptionPane.showMessageDialog(null, response);
						} else {
							response += "\n此書已被別人借閱至" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response);
							String reserve[] = { "預約", "不動作" };
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
						JOptionPane.showMessageDialog(null, "借閱至" + ub.getretrievedate());
						userbooks.add(ub);
						adbook.setsituation("unavailable");
						adbook.setcount();
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "目前無書籍！");
		}
	}

}