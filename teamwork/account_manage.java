import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class account_manage{
	public static ArrayList<user> users  = new ArrayList<user>();
	public void add(){
		regis  re = new regis();
		String information;
		int check = 0;
		information = re.gui();
		String[] info_part = information.split("-");
		// System.out.print(u.getname() + u.getaccount() + u.getpassword() + u.getidentification());
		if(info_part.length == 4){
			for(user u : users){
				if(u.getname().equals(info_part[3])){check = 1;}
			}
			if(check == 0){users.add(new user(info_part [3], info_part [0], info_part [1], info_part[2]));}
			else{
				JOptionPane.showMessageDialog(null,"�ӱb���w�s�b");
				add();
			}
		}
		
	}
	public user login(){
      		JTextField xField = new JTextField(5);
      		JTextField yField = new JTextField(5);
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,3);
      		myPanel.setLayout(experimentLayout);
      		myPanel.add(new JLabel("�b��:"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("�K�X:"));
      		myPanel.add(yField);
      		String login_button[] = {"�n�J", "����"};
      		int result = JOptionPane.showOptionDialog(null, myPanel,"�n�J����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, login_button,null);
		int check = 0;
		int count = 0;
		user ex = new user("", "", "", "");
		while(result == 0 && (check == 0 && count < 3)){
			for(user u:users){
				if (u.getaccount().equals(xField.getText()) && u.getpassword().equals(yField.getText())){
					JOptionPane.showMessageDialog(null,"�n�J���\!");
					check = 1;
					return u;
				}
						
                    		}
			if (check == 0){
				JOptionPane.showMessageDialog(null,"�n�J����, �нT�{�b���K�X�O�_���T");
				count +=1;
				result = JOptionPane.showConfirmDialog(null, myPanel,"login", JOptionPane.OK_CANCEL_OPTION);
			}
     		}
		if(result == JOptionPane.CANCEL_OPTION){JOptionPane.showMessageDialog(null,"�����n�J");}
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
			if(u.getidentification() != "Admin") {
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
    			comboBox.addItem("Admin");
    			comboBox.addItem("Student");
    			comboBox.addItem("Teacher");
    			comboBox.addItem("Staff");
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
		users.add(new user("�����", "user1", "user1", "Student"));
		users.add(new user("���j��", "user3", "user3", "Student"));
		users.add(new user("���p��", "user2", "user2", "Admin"));
	}
	
	
}