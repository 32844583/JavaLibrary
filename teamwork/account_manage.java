import javax.swing.JOptionPane;
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
	public String login(){
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
      		int result = JOptionPane.showConfirmDialog(null, myPanel,"login", JOptionPane.OK_CANCEL_OPTION);
		int check = 0;
		int count = 0;
		user ex = new user("", "", "", "");
		while(result == JOptionPane.OK_OPTION && (check == 0 && count < 3)){
			for(user u:users){
				if (u.getaccount().equals(xField.getText()) && u.getpassword().equals(yField.getText())){
					ex = u;
				}
						
                    		}
			if (ex.getname() != ""){
				JOptionPane.showMessageDialog(null,"�n�J���\!");
				result = JOptionPane.CANCEL_OPTION;
				check = 1;
				return ex.getname();
			}
			else{
				JOptionPane.showMessageDialog(null,"�n�J����, �нT�{�b���K�X�O�_���T");
				count +=1;
				result = JOptionPane.showConfirmDialog(null, myPanel,"login", JOptionPane.OK_CANCEL_OPTION);
			}
     		}
		if(result == JOptionPane.CANCEL_OPTION){JOptionPane.showMessageDialog(null,"�����n�J");}
		return "error";  // �b���K�X���~�Ψ����n�J
	}
	public void show(){
		String respon="" ;
		for (user u:users){
		respon += "�m�W:" + u.getname() +"\n"+ "�b��:" + u.getaccount() +"\n"+ "�K�X:" +u.getpassword() +"\n"+ "�v��:" + u.getidentification() + "\n";}
		JOptionPane.showMessageDialog(null,"\n�ثe�b���ƶq" + users.size()+"\n"+ respon );
	}
	
}