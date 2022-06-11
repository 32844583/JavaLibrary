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
			myPanel.add(new JLabel("æŽ’è¡Œ\tæ›¸å\n"));
=======
			myPanel.add(new JLabel("±Æ¦æ\t®Ñ¦W\n"));
>>>>>>> 32cdc9c (java)
			for (int i = 0; i < t.length; i++) {
				myPanel.add(new JLabel(i + 1 + "\t" + t[i]));
			}
			final JComboBox<String> comboBox = new JComboBox<String>();
<<<<<<< HEAD
			JLabel label = new JLabel("è«‹é¸æ“‡è¦å€Ÿé–±çš„æ›¸ç±ï¼š");
=======
			JLabel label = new JLabel("½Ð¿ï¾Ü­n­É¾\ªº®ÑÄy¡G");
>>>>>>> 32cdc9c (java)
			myPanel.add(label);
			for (String s : t) {
				comboBox.addItem(s);
			}
			comboBox.setSelectedIndex(0);
			myPanel.add(comboBox);
<<<<<<< HEAD
			String borrow_list[] = { "å€Ÿé–±", "ä¸å‹•ä½œ" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "å€Ÿé–±", JOptionPane.YES_NO_OPTION,
=======
			String borrow_list[] = { "­É¾\", "¤£°Ê§@" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "­É¾\¨t²Î", JOptionPane.YES_NO_OPTION,
>>>>>>> 32cdc9c (java)
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			book adbook = new book("", "", "");
			adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
			System.out.println(adbook.getname());
			if (result == 0) {
				if (userbooks.size() >= this.lendup) {
<<<<<<< HEAD
					JOptionPane.showMessageDialog(null, "è¶…éŽå€Ÿé–±æ•¸é‡");
=======
					JOptionPane.showMessageDialog(null, "¶W¹L­É¾\¼Æ¶q","­É¾\¨t²Î",1);
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
							response += "æ‚¨å·²å€Ÿé–±, ä¸å¯é‡è¤‡å€Ÿé–±" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response);
						} else {
							response += "\næ­¤æ›¸å·²è¢«åˆ¥äººå€Ÿé–±è‡³" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response);
							String reserve[] = { "é ç´„", "ä¸å‹•ä½œ" };
							int select = JOptionPane.showOptionDialog(null, "æ‚¨è¦é ç´„å—Žï¼Ÿ", null + "student",
=======
							response += "±z¤w­É¾\, ¤£¥i­«½Æ­É¾\" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"­É¾\¨t²Î",1);
						} else {
							response += "\n¦¹®Ñ¤w³Q§O¤H­É¾\¦Ü" + ubm.retrieve_date(adbook.getname());
							JOptionPane.showMessageDialog(null, response,"­É¾\¨t²Î",1);
							String reserve[] = { "¹w¬ù", "¤£°Ê§@" };
							int select = JOptionPane.showOptionDialog(null, "±z­n¹w¬ù¶Ü¡H", null + "student",
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
						JOptionPane.showMessageDialog(null, "å€Ÿé–±è‡³" + ub.getretrievedate());
=======
						JOptionPane.showMessageDialog(null, "­É¾\¦Ü" + ub.getretrievedate(),"­É¾\¨t²Î",1);
>>>>>>> 32cdc9c (java)
						userbooks.add(ub);
						adbook.setsituation("unavailable");
						adbook.setcount();
					}
				}
			}
		} else {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "ç›®å‰ç„¡æ›¸ç±ï¼");
=======
			JOptionPane.showMessageDialog(null, "¥Ø«eµL®ÑÄy¡I","­É¾\¨t²Î",1);
>>>>>>> 32cdc9c (java)
		}
	}

}