import javax.swing.*;
import java.awt.*;
import java.util.*;
public class visitor {
    static ArrayList <book> search_books = new ArrayList <book>();
    static ArrayList<userbook> userbooks = new ArrayList<userbook>();
    public void action(){
		String login[] = {"搜尋書籍","排行榜","登出"};
		int select = JOptionPane.showOptionDialog(null,"訪客您好：",null, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
		if (select !=3){
			switch (select){
         			case 0:
                     borrow_book();
            			break;
         			case 1:
                     
            			break;
       			}
			action();
		}
	}
	public void borrow_book(){
		userbook_manage ubm = new userbook_manage();
		book_manage bm = new book_manage();
		book adbook = new book("","","");
		search_books = bm.new_search_gui();
		for(book b : search_books){
		 System.out.println(b.getname());
		}
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
		if(search_books.size() != 0){
		 for (book b:search_books){
		 myPanel.add(new JLabel("書名:" + b.getname()));
		 myPanel.add(Box.createHorizontalStrut(15));
		 }
		 final JComboBox<String> comboBox = new JComboBox<String>();
		JLabel label = new JLabel("目前搜尋到的書籍：");
		myPanel.add(label);
		
		for(book b : search_books){
		 comboBox.addItem(b.getname());
		}
		comboBox.setSelectedIndex(0);
		myPanel.add(comboBox);
		int result = JOptionPane.showConfirmDialog(null, myPanel,"search",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
		if(result == JOptionPane.OK_OPTION){
		 JOptionPane.showMessageDialog(null, "請登入再做借閱");
		}
		else {
			JOptionPane.showMessageDialog(null, "查無此書籍");
		}
	}
}
}
/*public void watchinfo(){
    search s = new search();
		JPanel myPanel = new JPanel();
        s.search_gui();
    for (book b:search_books){
		myPanel.add(new JLabel("書名:" + b.getname()));
		myPanel.add(Box.createHorizontalStrut(15));
	}
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
       
int result = JOptionPane.showConfirmDialog(null,myPanel,"書籍名稱",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
if(result == JOptionPane.OK_OPTION){
    if(search_books.size() == 0){JOptionPane.showMessageDialog(null, "查無此書籍");}
}
}*/


