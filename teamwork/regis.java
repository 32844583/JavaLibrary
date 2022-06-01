
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;

public class regis{
   public String gui() {
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);
      JTextField uField = new JTextField(5);
      JFrame jf = new JFrame();
      jf.setSize(250,250);
      jf.setLocationRelativeTo(null);
      JPanel myPanel = new JPanel();
      GridLayout experimentLayout = new GridLayout(0,3);
      myPanel.setLayout(experimentLayout);
      myPanel.add(new JLabel("姓名:")); 
      myPanel.add(uField); 
      myPanel.add(Box.createHorizontalStrut(15));// a spacer
      myPanel.add(new JLabel("帳號:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("密碼:"));
      myPanel.add(yField);
      myPanel.add(Box.createHorizontalStrut(15));
      JLabel label = new JLabel("身份別:");
      myPanel.add(label);
      String[] listData = {"Student", "Teacher", "Staff", "Admin"};
      final JComboBox<String> comboBox = new JComboBox<String>(listData);
      comboBox.setSelectedIndex(0);
      myPanel.add(comboBox);


      int result = JOptionPane.showConfirmDialog(null, myPanel,"registration", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
   JOptionPane.showMessageDialog(null,"註冊成功！\n歡迎: "+comboBox.getSelectedItem()+" "+uField.getText());
   return xField.getText() +'-'+ yField.getText() + '-' +comboBox.getSelectedItem()+ '-' +uField.getText();
      }
      else{
	JOptionPane.showMessageDialog(null,"取消註冊");
                    return "Cancel regis";
      }
   }
}

/*comboBox.addItemListener(new ItemListener(){
   public void itemStateChanged(ItemEvent e){
   if(e.getStateChange()==ItemEvent.SELECTED){
            System.out.println(comboBox.getSelectedItem());
   }
}
}*/