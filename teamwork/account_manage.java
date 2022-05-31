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
				JOptionPane.showMessageDialog(null,"該帳號已存在");
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
      		myPanel.add(new JLabel("帳號:"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("密碼:"));
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
				JOptionPane.showMessageDialog(null,"登入成功!");
				result = JOptionPane.CANCEL_OPTION;
				check = 1;
				return ex.getname();
			}
			else{
				JOptionPane.showMessageDialog(null,"登入失敗, 請確認帳號密碼是否正確");
				count +=1;
				result = JOptionPane.showConfirmDialog(null, myPanel,"login", JOptionPane.OK_CANCEL_OPTION);
			}
     		}
		if(result == JOptionPane.CANCEL_OPTION){JOptionPane.showMessageDialog(null,"取消登入");}
		return "error";  // 帳號密碼錯誤或取消登入
	}
	public void show(){
		String respon="" ;
		for (user u:users){
		respon += "姓名:" + u.getname() +"\n"+ "帳號:" + u.getaccount() +"\n"+ "密碼:" +u.getpassword() +"\n"+ "權限:" + u.getidentification() + "\n";}
		JOptionPane.showMessageDialog(null,"\n目前帳號數量" + users.size()+"\n"+ respon );
	}
	
}