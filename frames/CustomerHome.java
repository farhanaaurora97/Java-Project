package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerHome extends JFrame implements ActionListener
{
	JButton logoutBtn, viewProductListBtn, purchaseHistoryBtn, changePasswordBtn;
	JPanel panel;
	
	User user;
	//ProductFrame pf;
	
	public CustomerHome(User user)
	{
		super("Welcome Customer");
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
		
		viewProductListBtn = new JButton("View Product");
		viewProductListBtn.setBounds(50, 100, 150, 30);
		viewProductListBtn.addActionListener(this);
		panel.add(viewProductListBtn);
		
		purchaseHistoryBtn = new JButton("Purchase History");
		purchaseHistoryBtn.setBounds(225, 100, 150, 30);
		purchaseHistoryBtn.addActionListener(this);
		panel.add(purchaseHistoryBtn);
		
		/*
		managePurchaseBtn = new JButton("Manage Purchase");
		managePurchaseBtn.setBounds(400, 100, 150, 30);
		managePurchaseBtn.addActionListener(this);
		panel.add(managePurchaseBtn);
		*/
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
		else if(command.equals(viewProductListBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				CusViewProductFrame cvf = new CusViewProductFrame(user);
				cvf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		/*
		else if(command.equals(purchaseHistoryBtn.getText()))
		{
			if(user.getStatus()==2)
			{
				PurchaseInfoRepo pr = new PurchaseInfoRepo();
			
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(managePurchaseBtn.getText()))
		{
			
		}
		*/
		else{}
	}
}