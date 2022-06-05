import javax.swing.*;
import java.awt.*;
import java.util.*;
public class visitor extends book_manage {
    static ArrayList <book> search_books = new ArrayList <book>();
    static ArrayList<userbook> userbooks = new ArrayList<userbook>();
    public void action(){
		String login[] = {"搜尋書籍","排行榜","登出"};
		int select = JOptionPane.showOptionDialog(null,"訪客您好：",null, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
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
			myPanel.add(new JLabel("書名　　　出版社　　　作者　　　　狀態\n"));
			for (book b:search_books){
				myPanel.add(new JLabel(b.getname() +"　　　"+ b.getpublish() +"　　　"+ b.getauthor() +"　　　"+ (b.getsituation() == "available" ? "可借閱":"已被借閱(至" + ubm.retrieve_date(b.getname())+")")));
			}
			JOptionPane.showMessageDialog(null, myPanel);
		}
		else {
			JOptionPane.showMessageDialog(null, "查無此書籍");
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


