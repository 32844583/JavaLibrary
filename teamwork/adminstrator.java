import javax.swing.*;
import java.awt.*;
public class adminstrator extends user{
	public adminstrator(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
	}
	public void action(user u){
		book_manage b = new book_manage();
		int select = Integer.parseInt(JOptionPane.showInputDialog("管理員"+u.getname()+"你好, 請問您要? +  \n(1)編輯或刪除書籍 \n(2)新增書籍\n(3)查看所有書籍\n(4)登出"));
		if (Integer.toString(select) == null){
			lib l = new lib();
			l.menu();
		}
		else{
		if (select !=4){
			switch (select){
         				case 1:
            				edit(u);
            				break;
         				case 2:
            				b.add();
            				break;
				case 3:
				b.show();
       			}
			action(u);
			}
		}
	}
	public void edit(user u){
		book_manage b = new book_manage();
		book adbook = searchbook();
		int select = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Java Bank! Select transactions: \n(1)編輯 \n(2)刪除 \n (3)驗證\n"));
		
		if (select !=4){
			switch (select){
         			case 1:
            			revise(adbook);
			if (adbook.getname() == "no this book"){
				JOptionPane.showMessageDialog(null, "there is not this book");
			}
            			break;
         			case 2:
			if (adbook.getname() == "no this book"){
				JOptionPane.showMessageDialog(null, "there is not this book");
			}
            			b.remove(adbook);
			JOptionPane.showMessageDialog(null, "刪除成功!");
            			break;
			case 3:
			b.show();
			break;
       			}
			
			action(u);
		}
		
	}
	public void revise(book b){
		JTextField xField = new JTextField(b.getname());
      		JTextField yField = new JTextField(b.getauthor());
      		JTextField zField = new JTextField(b.getpublish());
 
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,3);
		myPanel.add(new JLabel("想修改"));
		myPanel.add(new JLabel("哪一項呢?"));
		myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("書名:"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("作者:"));
      		myPanel.add(yField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("出版社:"));
      		myPanel.add(zField);

      		int result = JOptionPane.showConfirmDialog(null, myPanel,"Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      		if (result == JOptionPane.OK_OPTION) {
			b.setname(xField.getText());
			b.setpublish(yField.getText());
			b.setauthor(zField.getText());
      		}
	}
}