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
<<<<<<< HEAD
	      myPanel.add(new JLabel("å§“å:")); 
	      myPanel.add(uField); 
	      myPanel.add(Box.createHorizontalStrut(15));// a spacer
	      myPanel.add(new JLabel("å¸³è™Ÿ:"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("å¯†ç¢¼:"));
	      myPanel.add(yField);
	      myPanel.add(Box.createHorizontalStrut(15));
	      JLabel label = new JLabel("èº«ä»½åˆ¥:");
	      myPanel.add(label);
	      String[] listData = {"Student", "Teacher", "Staff", "Admin"};
	      final JComboBox<String> comboBox = new JComboBox<String>(listData);
	      comboBox.setSelectedIndex(0);
	      myPanel.add(comboBox);
	      int result = JOptionPane.showConfirmDialog(null, myPanel,"registration", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  if(xField.getText().equals("") || uField.getText().equals("") || yField.getText().equals("") ) {
	    		  JOptionPane.showMessageDialog(null,"æœ‰å°šæœªå¡«å…¥è³‡æ–™");
=======
	      myPanel.add(new JLabel("©m¦W¡G")); 
	      myPanel.add(uField); 
	      myPanel.add(Box.createHorizontalStrut(15));// a spacer
	      myPanel.add(new JLabel("±b¸¹¡G"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("±K½X¡G"));
	      myPanel.add(yField);
	      myPanel.add(Box.createHorizontalStrut(15));
	      JLabel label = new JLabel("¨­¥÷§O¡G");
	      myPanel.add(label);
	      String[] listData = {"¾Ç¥Í", "±Ğ®v", "Â¾­û", "ºŞ²z­û"};
	      final JComboBox<String> comboBox = new JComboBox<String>(listData);
	      comboBox.setSelectedIndex(0);
	      myPanel.add(comboBox);

	      int result = JOptionPane.showConfirmDialog(null, myPanel,"µù¥U¨t²Î", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  if(xField.getText().equals("") || uField.getText().equals("") || yField.getText().equals("") ) {
	    		  JOptionPane.showMessageDialog(null,"¦³©|¥¼¶ñ¤J¸ê®Æ","µù¥U¨t²Î",1);
>>>>>>> 32cdc9c (java)
	    	  }
	    	  else {
	    		  int check = 0;
		    	  for(user u: users) {
		    		  if(u.getname().equals(uField.getText()) || u.getaccount().equals(xField.getText())) {
		    			  check = 1;
		    		  }
		    	  }
		    	  if(check == 1) {
<<<<<<< HEAD
		    		  JOptionPane.showMessageDialog(null,"å¸³è™Ÿé‡è¤‡è¨»å†Š");
		    	  }
		    	  else {
		    		  JOptionPane.showMessageDialog(null,"è¨»å†ŠæˆåŠŸï¼\næ­¡è¿: "+comboBox.getSelectedItem()+" "+uField.getText());
		        	  if(comboBox.getSelectedItem().toString() == "Student") {users.add(new student(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "Teacher") {users.add(new teacher(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "Staff") {users.add(new staff(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "Admin") {users.add(new adminstrator(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
=======
		    		  JOptionPane.showMessageDialog(null,"±b¸¹­«½Æµù¥U","µù¥U¨t²Î",1);
		    	  }
		    	  else {
		    		  JOptionPane.showMessageDialog(null,"µù¥U¦¨¥\¡I\nÅwªï: "+comboBox.getSelectedItem()+" "+uField.getText(),"µù¥U¨t²Î",1);
		        	  if(comboBox.getSelectedItem().toString() == "¾Ç¥Í") {users.add(new student(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "±Ğ®v") {users.add(new teacher(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "Â¾­û") {users.add(new staff(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
		        	  else if(comboBox.getSelectedItem().toString() == "ºŞ²z­û") {users.add(new adminstrator(uField.getText(), xField.getText(), yField.getText(), comboBox.getSelectedItem().toString()));}
>>>>>>> 32cdc9c (java)
		    	  }
	    		  
	    	  }
	      }
	      else {
<<<<<<< HEAD
	    	  JOptionPane.showMessageDialog(null,"å–æ¶ˆè¨»å†Š");
=======
	    	  JOptionPane.showMessageDialog(null,"¨ú®øµù¥U","µù¥U¨t²Î",1);
>>>>>>> 32cdc9c (java)
	      }
	   }
	public user login(){
      		JTextField xField = new JTextField(5);
      		JTextField yField = new JTextField(5);
      		JPanel myPanel = new JPanel();
      		GridLayout experimentLayout = new GridLayout(0,3);
      		myPanel.setLayout(experimentLayout);
<<<<<<< HEAD
      		myPanel.add(new JLabel("å¸³è™Ÿ:"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("å¯†ç¢¼:"));
      		myPanel.add(yField);
      		String login_button[] = {"ç™»å…¥", "å–æ¶ˆ"};
      		int result = JOptionPane.showOptionDialog(null, myPanel,"ç™»å…¥ä»‹é¢", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, login_button,null);
=======
      		myPanel.add(new JLabel("±b¸¹¡G"));
      		myPanel.add(xField);
      		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      		myPanel.add(new JLabel("±K½X¡G"));
      		myPanel.add(yField);
      		String login_button[] = {"µn¤J", "¨ú®ø"};
      		int result = JOptionPane.showOptionDialog(null, myPanel,"µn¤J¤¶­±", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, login_button,null);
>>>>>>> 32cdc9c (java)
      		int check = 0;
      		int count = 0;
      		student ex = new student("", "", "", "");
      		while(result == 0 && (check == 0 && count < 3)){
      			for(user u:users){
      				if (u.getaccount().equals(xField.getText()) && u.getpassword().equals(yField.getText())){
<<<<<<< HEAD
						JOptionPane.showMessageDialog(null,"ç™»å…¥æˆåŠŸ!");
=======
						JOptionPane.showMessageDialog(null,"µn¤J¦¨¥\¡I","µn¤J¨t²Î",1);
>>>>>>> 32cdc9c (java)
						check = 1;
						return u;
      				}		
      			}
				if (check == 0){
<<<<<<< HEAD
					JOptionPane.showMessageDialog(null,"ç™»å…¥å¤±æ•—, è«‹ç¢ºèªå¸³è™Ÿå¯†ç¢¼æ˜¯å¦æ­£ç¢º");
					count +=1;
					result = JOptionPane.showConfirmDialog(null, myPanel,"login", JOptionPane.OK_CANCEL_OPTION);
				
     		}
		if(result == JOptionPane.CANCEL_OPTION){JOptionPane.showMessageDialog(null,"å–æ¶ˆç™»å…¥");}
      	}
      	return ex;  // å¸³è™Ÿå¯†ç¢¼éŒ¯èª¤æˆ–å–æ¶ˆç™»å…¥
=======
					JOptionPane.showMessageDialog(null,"µn¤J¥¢±Ñ¡A½Ğ½T»{±b¸¹±K½X¬O§_¥¿½T","µn¤J¨t²Î",1);
					count +=1;
					result = JOptionPane.showConfirmDialog(null, myPanel,"µn¤J¨t²Î", JOptionPane.OK_CANCEL_OPTION);
				
     		}
		if(result == JOptionPane.CANCEL_OPTION){JOptionPane.showMessageDialog(null,"¨ú®øµn¤J","µn¤J¨t²Î",1);}
      	}
      	return ex;  // ±b¸¹±K½X¿ù»~©Î¨ú®øµn¤J
>>>>>>> 32cdc9c (java)
      	
	}
	public void watch_user(user admin){
		JFrame jf = new JFrame();
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		JPanel myPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,ï¼‘);
		myPanel.setLayout(experimentLayout);
		myPanel.add(new JLabel("ä½¿ç”¨è€…ã€€ã€€ã€€" + "èº«åˆ†"));
		for (user u : users){
			myPanel.add(new JLabel(u.getname() +"ã€€ã€€"+ (u.getidentification())));
		}
		myPanel.add(new JLabel("ç›®å‰ä½¿ç”¨è€…æ•¸é‡:ã€€" + users.size()));
		final JComboBox<String> comboBox = new JComboBox<String>();
		myPanel.add(new JLabel("è«‹é¸æ“‡è¦åˆªé™¤æˆ–æ›´æ”¹æ¬Šé™çš„çš„ä½¿ç”¨è€…"));
		for(user u : users){
			if(u.getidentification() != "ºŞ²z­û") {
				comboBox.addItem(u.getname());
			}
		}
		comboBox.setSelectedIndex(0);
        myPanel.add(comboBox);
        String manage[] = {"åˆªé™¤ä½¿ç”¨è€…", "æ›´æ”¹æ¬Šé™", "ä¸å‹•ä½œ"};
        int result = JOptionPane.showOptionDialog(null, myPanel,"ç®¡ç†ä½¿ç”¨è€…ä»‹é¢",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,manage,null);
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
    			Panel.add(new JLabel("è«‹é¸æ“‡è¦æ›´æ”¹æ¬Šé™"));
    			final JComboBox<String> comboBox = new JComboBox<String>();
    			comboBox.addItem("ºŞ²z­û");
    			comboBox.addItem("¾Ç¥Í");
    			comboBox.addItem("±Ğ®v");
    			comboBox.addItem("Â¾­û");
    			Panel.add(comboBox);
    			String manage_ident[] = {"ç¢ºå®šæ›´æ”¹", "ä¸å‹•ä½œ"};
    			int select = JOptionPane.showOptionDialog(null, Panel,"ç®¡ç†ä½¿ç”¨è€…ä»‹é¢",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, manage_ident,null);
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
<<<<<<< HEAD
		users.add(new student("ç‹æ›‰æ˜", "user1", "user1", "Student"));
		users.add(new student("ç‹å¤§æ˜", "user3", "user3", "Student"));
		users.add(new adminstrator("æå°æ˜", "user2", "user2", "Admin"));
=======
		users.add(new student("¤ı¾å©ú", "user1", "user1", "Student"));
		users.add(new student("¤ı¤j©ú", "user3", "user3", "Student"));
		users.add(new adminstrator("§õ¤p©ú", "user2", "user2", "Admin"));
>>>>>>> 32cdc9c (java)
	}
	
}