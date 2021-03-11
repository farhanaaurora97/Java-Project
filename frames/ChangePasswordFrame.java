package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangePasswordFrame extends JFrame
{
	private JLabel oldPassLabel, newPassLabel;
	private JPasswordField oldPassPF, newPassPF;
	private JButton changePasswordBtn;
	private JPanel panel;
	private LoginFrame lf;
	//User user;
	
	public ChangePasswordFrame()
	{
		super("Change Password");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.lf = lf;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		oldPassLabel =new JLabel("Old Password : ");
		oldPassLabel.setBounds(200, 200, 120, 30);
		panel.add(oldPassLabel);
		
		oldPassPF =new JPasswordField();
		oldPassPF.setBounds(350, 200, 120, 30);
		panel.add(oldPassPF);
		
		newPassLabel =new JLabel("New Password : ");
		newPassLabel.setBounds(200, 260, 120, 30);
		panel.add(newPassLabel);
		
		newPassPF =new JPasswordField();
		newPassPF.setBounds(350, 260, 120, 30);
		panel.add(newPassPF);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(300, 320, 200, 30);
		//changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		this.add(panel);
	}
	/*
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(changePasswordBtn.getText()))
		{
			
			if(command.getSource().equals(changePasswordBtn))
			{
				
			}
			
		}
		
		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			this.setVisible(false);
			eh.setVisible(true);
		}
		else{}
		
	}
	*/
}