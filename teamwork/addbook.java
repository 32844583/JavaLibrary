import javax.swing.*;
import java.awt.*;
public class addbook extends userbook_manage{
   public String gui() {
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);
      JTextField zField = new JTextField(5);
 
      JPanel myPanel = new JPanel();
      GridLayout experimentLayout = new GridLayout(0,3);
      myPanel.setLayout(experimentLayout);
      myPanel.add(new JLabel("書名:"));
      myPanel.add(xField);
myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("作者:"));
      myPanel.add(yField);
myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("出版社:"));
      myPanel.add(zField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,"addbook", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
	return xField.getText() +'-'+ yField.getText() + '-' +zField.getText();
      }
      else{
                    return xField.getText() +'-'+ yField.getText() + '-' +zField.getText();
      }
   }

}