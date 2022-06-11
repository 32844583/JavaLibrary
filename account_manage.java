import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class account_manage{
	public static ArrayList<user> users  = new ArrayList<user>();
   public void regis() {
	      JTextField xField = new JTextField(5);
	      JTextField yField = new JTextField(5);
	      JTextField uField = new JTextField(5);
	      JFrame jf = new JFrame();
	      jf.setSize(250,250);
	      jf.setLocationRelativeTo(null);
	      JPanel myPanel = new JPanel();
	      GridLayout experimentLayout = new GridLayout(0,3);
	      myPanel.setLayout(experimentLayout);
	      myPanel.add(new JLabel("�m�W�G")); 
	      myPanel.add(uField); 
	      myPanel.add(Box.createHorizontalStrut(15));// a spacer
	      myPanel.add(new JLabel("�b���G"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("�K�X�G"));
	      myPanel.add(yField);
	      myPanel.add(Box.createHorizontalStrut(15));
	      JLabel label = new JLabel("�����O�G");
	      myPanel.add(label);
	      String[] listData = {"�ǥ�", "�Юv", "¾��", "�޲z��"};
	      final JComboBox<String> comboBox = new JComboBox<String>(listData);
	      comboBox.setSelectedIndex(0);
	      myPanel.add(comboBox);

	      int result = JOptionPane.showConfirmDialog(null, myPanel,"���U�t��", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  if(xField.getText().equals("") || uField.getText().equals("") || yField.getText().equals("") ) {
	    		  JOptionPane.showMessageDialog(null,"���|����J���","���U�t��",1);
	    	  }
	    	  else {
	    		  int check = 0;
		    	  for(user u: users) {
		    		  if(u.getname().equals(uField.getText()) || u.getaccount().equals(xField.getText())) {
		    			  check = 1;
		    		  }
		    	  }
		    	  if(check == 1) {
		    		  JOptionPane.showMessageDialog(null,"�b�����Ƶ��U","���U�t��",1);
		    	  }
		    	  else {
		    		  JOptionPane.showMessageDialog(null,"���U���\�I\n�w��: "+comboBox.getSelectedItem()+" "+uField.getText(),"���U�t��",1);
		        	  if(comboBox.getSelectedItem().toString() == "�ǥ�") {users.add(new student(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "�Юv") {users.add(new teacher(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "¾��") {users.add(new staff(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "�޲z��") {users.add(new adminstrator(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		    	  }
	    		  
	    	  }
	      }
	      else {
	    	  JOptionPane.showMessageDialog(null,"�������U","���U�t��",1);
	      }
	   }
	public user login(){
      		JTextField xField = new JTextField(5);
      		JTextField yField = new JTextField(5);
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,3);
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("�b���G"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("�K�X�G"));
      		myPanel.add(yField);
      		String login_button[] = {"�n�J", "����"};
      		int result = JOptionPane.showOptionDialog(null, myPanel,"�n�J����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, login_button,null);
      		int check = 0;
      		int count = 0;
      		student ex = new student("", "", "", "");
      		while(result == 0 && (check == 0 && count < 3)){
      			for(user u:users){
      				if (u.getaccount().equals(xField.getText()) && u.getpassword().equals(yField.getText())){
						JOptionPane.showMessageDialog(null,"�n�J���\�I","�n�J�t��",1);
						check = 1;
						return u;
      				}		
      			}
				if (check == 0){
					JOptionPane.showMessageDialog(null,"�n�J���ѡA�нT�{�b���K�X�O�_���T","�n�J�t��",1);
					count +=1;
					result = JOptionPane.showConfirmDialog(null, myPanel,"�n�J�t��", JOptionPane.OK_CANCEL_OPTION);
				
     		}
		if(result == JOptionPane.CANCEL_OPTION){JOptionPane.showMessageDialog(null,"�����n�J","�n�J�t��",1);}
      	}
      	return ex;  // �b���K�X���~�Ψ����n�J
      	
	}
	public void watch_user(user admin){
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,��);
		myPanel.setLayout(experimentLayout);
		myPanel.add(new JLabel("�ϥΪ̡@�@�@" + "����"));
		for (user u : users){
			myPanel.add(new JLabel(u.getname() +"�@�@"+ (u.getidentification())));
		}
		myPanel.add(new JLabel("�ثe�ϥΪ̼ƶq:�@" + users.size()));
		final JComboBox<String> comboBox = new JComboBox<String>();
		myPanel.add(new JLabel("�п�ܭn�R���Χ���v�������ϥΪ�"));
		for(user u : users){
			if(u.getidentification() != "�޲z��") {
				comboBox.addItem(u.getname());
			}
		}
		comboBox.setSelectedIndex(0);
        myPanel.add(comboBox);
        String manage[] = {"�R���ϥΪ�", "����v��", "���ʧ@"};
        int result = JOptionPane.showOptionDialog(null, myPanel,"�޲z�ϥΪ̤���",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,manage,null);
        if(result == 0) {
        	remove_user(comboBox.getSelectedItem().toString());
        }
        else if(result == 1) {
        	change_privilege(comboBox.getSelectedItem().toString());
        }
	}
	public void change_privilege(String username){
		for(user u : users) {
    		if(u.getname() == username) {
    			JFrame j = new JFrame();
    			j.setSize(500,500);
    			j.setLocationRelativeTo(null);
    			JPanel Panel = new JPanel();
    			GridLayout experiment = new GridLayout(0,1);
    			Panel.setLayout(experiment);
    			Panel.add(new JLabel("�п�ܭn����v��"));
    			final JComboBox<String> comboBox = new JComboBox<String>();
    			comboBox.addItem("�޲z��");
    			comboBox.addItem("�ǥ�");
    			comboBox.addItem("�Юv");
    			comboBox.addItem("¾��");
    			Panel.add(comboBox);
    			String manage_ident[] = {"�T�w���", "���ʧ@"};
    			int select = JOptionPane.showOptionDialog(null, Panel,"�޲z�ϥΪ̤���",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, manage_ident,null);
    			if(select == 0) {
    				u.setidentification(comboBox.getSelectedItem().toString());
    			}
    		}
    	}
	}
	public void remove_user(String delete_name) {
		users.removeIf(user -> user.getname() == delete_name);
	}
	public void initialize_user(){
		users.add(new student("�����", "user1", "user1", "Student"));
		users.add(new student("���j��", "user3", "user3", "Student"));
		users.add(new adminstrator("���p��", "user2", "user2", "Admin"));
	}
	
}