import javax.swing.*;
import java.awt.*;
public class adminstrator extends user{
	public adminstrator(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
	}
	public void action(user u){
		book_manage b = new book_manage();
		int select = Integer.parseInt(JOptionPane.showInputDialog("�޲z��"+u.getname()+"�A�n, �аݱz�n? +  \n(1)�s��ΧR�����y \n(2)�s�W���y\n(3)�d�ݩҦ����y\n(4)�n�X"));
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
		int select = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Java Bank! Select transactions: \n(1)�s�� \n(2)�R�� \n (3)����\n"));
		
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
			JOptionPane.showMessageDialog(null, "�R�����\!");
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
		myPanel.add(new JLabel("�Q�ק�"));
		myPanel.add(new JLabel("���@���O?"));
		myPanel.add(Box.createHorizontalStrut(15));
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("�ѦW:"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("�@��:"));
      		myPanel.add(yField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("�X����:"));
      		myPanel.add(zField);

      		int result = JOptionPane.showConfirmDialog(null, myPanel,"Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      		if (result == JOptionPane.OK_OPTION) {
			b.setname(xField.getText());
			b.setpublish(yField.getText());
			b.setauthor(zField.getText());
      		}
	}
}