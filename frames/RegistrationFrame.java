package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import entity.*;
import repository.*;

public class RegistrationFrame extends JFrame implements ActionListener
{
	private JLabel nameLabel,passLabel,userIdLabel,addressLabel,phoneNoLabel;
	private JTextField nameTF,userIdTF,phoneNoTF,addressTF;
	private JPasswordField passPF;
	private JButton backBtn, exitBtn,submitBtn;
	
	private JPanel panel;
	//User user;
	
	public RegistrationFrame()
	{
		super("Registration Frame");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		nameLabel = new JLabel("User Name:");
		nameLabel.setBounds(150,170, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(280,170,100,30);
		panel.add(nameTF);
		
		
        addressLabel = new JLabel("Address:");
		addressLabel.setBounds(150,290, 100, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(280,290,100,30);
		panel.add(addressTF);
		
		
        userIdLabel = new JLabel("User Id:");
		userIdLabel.setBounds(150,50, 100, 30);
		panel.add(userIdLabel);
		
		userIdTF = new JTextField();
		userIdTF.setBounds(280,50,100,30);
		panel.add(userIdTF);
		
		phoneNoLabel= new JLabel("Phone No:");
		phoneNoLabel.setBounds(150,230,100,30);
		panel.add(phoneNoLabel);
		
		phoneNoTF = new JTextField();
		phoneNoTF.setBounds(280,230,100,30);
		panel.add(phoneNoTF);
		
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(150, 110, 100, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(280,110,100,30);
		panel.add(passPF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(300, 350, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(600,50, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600,110, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			CustomerRepo cr =new CustomerRepo();
			UserRepo ur =new UserRepo();
			Customer c = new Customer();
			User u =new User();
			//Random rd =new Random();
			//int x = rd.nextInt(9999999)+10000000;
			
			c.setCusId(userIdTF.getText());
			c.setName(nameTF.getText());
			c.setAddress(addressTF.getText());
			c.setPhoneNumber(phoneNoTF.getText());
			
			u.setUserId(userIdTF.getText());
			u.setPassword(passPF.getText());
			u.setStatus(2);
			
			cr.insertInDB(c);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, id: "+userIdTF.getText());
			
			userIdTF.setText("");
			passPF.setText("");
			nameTF.setText("");
			addressTF.setText("");
			phoneNoTF.setText("");
			
		}
		
		else if(command.equals(backBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
		    this.setVisible(false);
		}
		
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		
		else{}
		
	}
}