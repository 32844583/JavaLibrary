import javax.swing.*;
import java.awt.*;
import java.util.*;
public class search extends book_manage{
	
	
	public book search_gui(){
	   	JTextField xField = new JTextField(5);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,3);
		myPanel.setLayout(experimentLayout);
		myPanel.add(new JLabel("√ˆ¡‰¶r∑j¥M:"));
		myPanel.add(xField);

		int result = JOptionPane.showConfirmDialog(null, myPanel,"Search", JOptionPane.OK_CANCEL_OPTION);
		book find = new book("no this book");
		for(book b : books){
			if (b.getname().contains(xField.getText())||
			b.getpublish().contains(xField.getText())||
			b.getauthor().contains(xField.getText())){ find = b;}
		}

		return find;
	}
}