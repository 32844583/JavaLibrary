import javax.swing.*;
import java.awt.*;
import java.util.*;

public class visitor {
	static ArrayList<book> search_books = new ArrayList<book>();

	public void action() {
		String login[] = { "搜尋書籍", "排行榜", "回到首頁" };
		int select = JOptionPane.showOptionDialog(null, "訪客您好：", null, JOptionPane.YES_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, login, null);
		if (select != 2) {
			switch (select) {
				case 0:
					borrow_book();
					break;
				case 1:
					ranking();
					break;
				case 2:
					break;
			}
			action();
		}
	}

	public void borrow_book() {
		userbook_manage ubm = new userbook_manage();
		book_manage bm = new book_manage();
		book adbook = new book("", "", "");
		search_books = bm.new_search_gui();
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0, 1);
		myPanel.setLayout(experimentLayout);
		if (search_books.size() != 0) {
			myPanel.add(new JLabel("書名　　　出版社　　　作者　　　　狀態\n"));
			for (book b : search_books) {
				myPanel.add(new JLabel(b.getname() + "　　　" + b.getpublish() + "　　　" + b.getauthor() + "　　　"
						+ (b.getsituation() == "available" ? "可借閱" : "已被借閱(至" + ubm.retrieve_date(b.getname()) + ")")));
			}
			JOptionPane.showMessageDialog(null, myPanel,"�j�M�P�ɾ\�t��",1);
		} else {
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "查無此書籍");
=======
			JOptionPane.showMessageDialog(null, "�d�L�����y","�j�M�P�ɾ\�t��",1);
>>>>>>> 32cdc9c (java)
		}
	}

	public void ranking() {
		book_manage bm = new book_manage();
		userbook_manage ubm = new userbook_manage();
		String[] t = bm.top3().split(",");

		if (t.length >= 0) {
			JFrame jf = new JFrame();
			jf.setSize(500, 500);
			jf.setLocationRelativeTo(null);
			JPanel myPanel = new JPanel();
			GridLayout experimentLayout = new GridLayout(0, 1);
			myPanel.setLayout(experimentLayout);
			myPanel.add(new JLabel("排行	書名\n"));
			for (int i = 0; i < t.length; i++) {
<<<<<<< HEAD
				myPanel.add(new JLabel(i + 1 + "　　　" + t[i]));
			}
			String borrow_list[] = { "不動作", "註冊" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "不動作", JOptionPane.YES_NO_OPTION,
=======
				myPanel.add(new JLabel(i + 1 + "�@�@�@" + t[i]));
			}
			String borrow_list[] = { "���ʧ@", "���U" };
			int result = JOptionPane.showOptionDialog(null, myPanel, "�ɾ\�Ʀ�]", JOptionPane.YES_NO_OPTION,
>>>>>>> 32cdc9c (java)
					JOptionPane.QUESTION_MESSAGE, null, borrow_list, null);
			account_manage ac = new account_manage();
			if (result == 1) {
				ac.regis();
<<<<<<< HEAD
=======
				lib.menu();
>>>>>>> 32cdc9c (java)
			}
		}

	}
}
/*
 * public void watchinfo(){
 * search s = new search();
 * JPanel myPanel = new JPanel();
 * s.search_gui();
 * for (book b:search_books){
 * myPanel.add(new JLabel("書名:" + b.getname()));
 * myPanel.add(Box.createHorizontalStrut(15));
 * }
 * GridLayout experimentLayout = new GridLayout(0,2);
 * myPanel.setLayout(experimentLayout);
 * 
 * int result =
 * JOptionPane.showConfirmDialog(null,myPanel,"書籍名稱",JOptionPane.YES_NO_OPTION,
 * JOptionPane.QUESTION_MESSAGE);
 * if(result == JOptionPane.OK_OPTION){
 * if(search_books.size() == 0){JOptionPane.showMessageDialog(null, "查無此書籍");}
 * }
 */