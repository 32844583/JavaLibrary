import javax.swing.*;
import java.awt.*;
import java.util.*;
public class visitor extends book_manage {
    static ArrayList <book> search_books = new ArrayList <book>();
    static ArrayList<userbook> userbooks = new ArrayList<userbook>();
    public void action(){
		String login[] = {"�j�M���y","�Ʀ�]","�n�X"};
		int select = JOptionPane.showOptionDialog(null,"�X�ȱz�n�G",null, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
		if (select !=2){
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
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,1);
		myPanel.setLayout(experimentLayout);
		if(search_books.size() != 0){
			myPanel.add(new JLabel("�ѦW�@�@�@�X�����@�@�@�@�̡@�@�@�@���A\n"));
			for (book b:search_books){
				myPanel.add(new JLabel(b.getname() +"�@�@�@"+ b.getpublish() +"�@�@�@"+ b.getauthor() +"�@�@�@"+ (b.getsituation() == "available" ? "�i�ɾ\":"�w�Q�ɾ\(��" + ubm.retrieve_date(b.getname())+")")));
			}
			JOptionPane.showMessageDialog(null, myPanel);
		}
		else {
			JOptionPane.showMessageDialog(null, "�d�L�����y");
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


