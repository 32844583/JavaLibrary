import javax.swing.*;
import java.awt.*;
public class adminstrator extends user{
	public adminstrator(String n, String acc, String pass, String ident){
		super(n, acc, pass, ident);
	}
	public void action(user u){
		book_manage b = new book_manage();
		String login[] = {"�n�X","�d�ݩҦ����y","�s��ΧR�����y","�s�W���y"};
		int select = JOptionPane.showOptionDialog(null,"�޲z��"+u.getname()+"�A�n, �аݱz�n?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
		if (select !=0){
			switch (select){
         		case 1:
				 b.show();
            	break;
         		case 2:
				 edit(u);
            	break;
				case 3:
				b.add();
       			}
			action(u);
			}
		}
	
	public void edit(user u){
		book_manage b = new book_manage();
		book adbook = searchbook();
		String login[] = {"�s��","�R��","����"};
		int select = JOptionPane.showOptionDialog(null,"Welcome to Java Bank! Select transactions:","bookmanage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,login,null);
		
		if (select !=3){
			switch (select){
         			case 0:
            			revise(adbook);
			if (adbook.getname() == "no this book"){
				JOptionPane.showMessageDialog(null, "there is not this book");
			}
            			break;
         			case 1:
			if (adbook.getname() == "no this book"){
				JOptionPane.showMessageDialog(null, "there is not this book");
			}
            			b.remove(adbook);
			JOptionPane.showMessageDialog(null, "�R�����\!");
            			break;
			case 2:
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