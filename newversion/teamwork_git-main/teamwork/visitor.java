import javax.swing.*;
import java.awt.*;
import java.util.*;
public class visitor {
    static ArrayList <book> search_books = new ArrayList <book>();
    static ArrayList<userbook> userbooks = new ArrayList<userbook>();
    public void action(){
		String login[] = {"�j�M���y","�Ʀ�]","�n�X"};
		int select = JOptionPane.showOptionDialog(null,"�X�ȱz�n�G",null, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
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
		 myPanel.add(new JLabel("�ѦW:" + b.getname()));
		 myPanel.add(Box.createHorizontalStrut(15));
		 }
		 final JComboBox<String> comboBox = new JComboBox<String>();
		JLabel label = new JLabel("�ثe�j�M�쪺���y�G");
		myPanel.add(label);
		
		for(book b : search_books){
		 comboBox.addItem(b.getname());
		}
		comboBox.setSelectedIndex(0);
		myPanel.add(comboBox);
		int result = JOptionPane.showConfirmDialog(null, myPanel,"search",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		adbook = bm.borrow_book_search(comboBox.getSelectedItem().toString());
		if(result == JOptionPane.OK_OPTION){
		 JOptionPane.showMessageDialog(null, "�еn�J�A���ɾ\");
		}
		else {
			JOptionPane.showMessageDialog(null, "�d�L�����y");
		}
	}
}
}
/*public void watchinfo(){
    search s = new search();
		JPanel myPanel = new JPanel();
        s.search_gui();
    for (book b:search_books){
		myPanel.add(new JLabel("�ѦW:" + b.getname()));
		myPanel.add(Box.createHorizontalStrut(15));
	}
		GridLayout experimentLayout = new GridLayout(0,2);
		myPanel.setLayout(experimentLayout);
       
int result = JOptionPane.showConfirmDialog(null,myPanel,"���y�W��",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
if(result == JOptionPane.OK_OPTION){
    if(search_books.size() == 0){JOptionPane.showMessageDialog(null, "�d�L�����y");}
}
}*/


