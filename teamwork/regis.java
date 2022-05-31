import javax.swing.*;
import java.awt.*;
public class regis{
   public String gui() {
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);
      JTextField zField = new JTextField(5);
      JTextField uField = new JTextField(5);
      JPanel myPanel = new JPanel();
      GridLayout experimentLayout = new GridLayout(0,3);
      myPanel.setLayout(experimentLayout);
      myPanel.add(new JLabel("帳號:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("密碼:"));
      myPanel.add(yField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("身分別:"));
      myPanel.add(zField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("姓名:"));
      myPanel.add(uField);
      String textFieldValue = "";
      int result = JOptionPane.showConfirmDialog(null, myPanel,"registration", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
	return xField.getText() +'-'+ yField.getText() + '-' +zField.getText()+ '-' +uField.getText();
      }
      else{
	JOptionPane.showMessageDialog(null,"取消註冊");
                    return "Cancel regis";
      }
   }
}