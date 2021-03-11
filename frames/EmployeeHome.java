package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class EmployeeHome extends JFrame implements ActionListener
{
	JButton logoutBtn, viewEmployeeBtn, viewProductListBtn, viewCustomerBtn, changePasswordBtn;
	JPanel panel;
	
	User user;
	
	public EmployeeHome(User user)
	{
		super("Welcome Employee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(600, 100, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		viewEmployeeBtn = new JButton("View Employee");
		viewEmployeeBtn.setBounds(50, 100, 150, 30);
		viewEmployeeBtn.addActionListener(this);
		panel.add(viewEmployeeBtn);
		
		viewProductListBtn = new JButton("Product List");
		viewProductListBtn.setBounds(225, 100, 150, 30);
		viewProductListBtn.addActionListener(this);
		panel.add(viewProductListBtn);
		
		
		viewCustomerBtn = new JButton("View Customer");
		viewCustomerBtn.setBounds(400, 100, 150, 30);
		viewCustomerBtn.addActionListener(this);
		panel.add(viewCustomerBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(viewEmployeeBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				EmployeeFrame ef = new EmployeeFrame(user);
				ef.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(viewProductListBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				ProductFrame pf = new ProductFrame(user);
				pf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(viewCustomerBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				CustomerFrame cf = new CustomerFrame(user);
				cf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(changePasswordBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				ChangePasswordFrame cpf = new ChangePasswordFrame();
				cpf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else{}
	}
}