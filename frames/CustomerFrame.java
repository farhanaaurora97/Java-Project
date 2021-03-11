package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerFrame extends JFrame implements ActionListener

{
	private JLabel cusIdLabel,customerNameLabel,address,phoneNumber;
	private JTextField cusIdTF, customerNameTF, addressTF,phoneNumberTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable cusTable;
	private JScrollPane cusTableSP;
	
	private User user;
	private CustomerRepo cr;
	private UserRepo ur;
	
	public CustomerFrame(User user)
	{
		super("CustomerFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.user = user;
		
		cr = new CustomerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Address", "PhoneNumber"};
		
		cusTable = new JTable(data,head);
		cusTableSP = new JScrollPane(cusTable);
		cusTableSP.setBounds(350, 100, 400, 150);
		cusTable.setEnabled(false);
		panel.add(cusTableSP);
		
		cusIdLabel = new JLabel("ID :");
		cusIdLabel.setBounds(100,100,100,30);
		panel.add(cusIdLabel);
		
		cusIdTF = new JTextField();
		cusIdTF.setBounds(220,100,100,30);
		panel.add(cusIdTF);
		
		customerNameLabel = new JLabel("Name :");
		customerNameLabel.setBounds(100,150,100,30);
		panel.add(customerNameLabel);
		
		customerNameTF = new JTextField();
	    customerNameTF.setBounds(220,150,100,30);
		panel.add(customerNameTF);
		
		address= new JLabel("Address :");
		address.setBounds(100,200,100,30);
		panel.add(address);
		
		addressTF=new JTextField();
		addressTF.setBounds(220,200,100,30);
		panel.add(addressTF);
		
		phoneNumber=new JLabel("PhoneNumber :");
		phoneNumber.setBounds(100,250,100,30);
		panel.add(phoneNumber);
		
		
		phoneNumberTF=new JTextField();
		phoneNumberTF.setBounds(220,250,100,30);
		panel.add(phoneNumberTF);
		
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!cusIdTF.getText().equals("") || !cusIdTF.getText().equals(null))
			{
				Customer c = cr.searchCustomer(cusIdTF.getText());
				if(c!= null)
				{
					//cusIdTF.setText(c.getCusId());
					customerNameTF.setText(c.getName());
					addressTF.setText(c.getAddress());
					phoneNumberTF.setText(c.getPhoneNumber());
					
					cusIdTF.setEnabled(false);
					customerNameTF.setEnabled(true);
					addressTF.setEnabled(true);
					phoneNumberTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Customer c = new Customer();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			c.setCusId(cusIdTF.getText());
			c.setName(customerNameTF.getText());
			c.setAddress(addressTF.getText());
			c.setPhoneNumber(phoneNumberTF.getText());
			
			u.setUserId(cusIdTF.getText());
			u.setPassword(x+"");
			/*
			if(((empDesignationTF.getText()).equals("Manager")) || ((empDesignationTF.getText()).equals("manager")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			*/
			cr.insertInDB(c);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+cusIdTF.getText()+"and Password: "+x);
			
			cusIdTF.setText("");
			customerNameTF.setText("");
			addressTF.setText("");
			phoneNumberTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			cusIdTF.setText("");
			customerNameTF.setText("");
			addressTF.setText("");
			phoneNumberTF.setText("");
			
			cusIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Customer c = new Customer();
			
			c.setCusId(cusIdTF.getText());
			c.setName(customerNameTF.getText());
			c.setAddress(addressTF.getText());
			c.setPhoneNumber(phoneNumberTF.getText());
			
			cr.updateInDB(c);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			cusIdTF.setText("");
			customerNameTF.setText("");
			addressTF.setText("");
			phoneNumberTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			cusIdTF.setEnabled(true);
			customerNameTF.setEnabled(true);
			addressTF.setEnabled(true);
			phoneNumberTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			cr.deleteFromDB(cusIdTF.getText());
			ur.deleteUser(cusIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			cusIdTF.setText("");
			customerNameTF.setText("");
			addressTF.setText("");
			phoneNumberTF.setText("");
			
			cusIdTF.setEnabled(true);
			customerNameTF.setEnabled(true);
			addressTF.setEnabled(true);
			phoneNumberTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getAllCustomer();
			String head[] = {"Id", "Name", "Adress", "PhoneNumber"};
			
			panel.remove(cusTableSP);
			
			cusTable = new JTable(data,head);
			cusTable.setEnabled(false);
			cusTableSP = new JScrollPane(cusTable);
			cusTableSP.setBounds(350, 100, 400, 150);
			panel.add(cusTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(user);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}
