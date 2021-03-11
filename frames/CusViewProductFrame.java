package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CusViewProductFrame extends JFrame implements ActionListener
{
	private JLabel productIdLabel, productNameLabel, priceLabel, quantityLabel;
	private JTextField productIdTF, productNameTF, priceTF, quantityTF;
	private JButton loadBtn, /* insertBtn, updateBtn, deleteBtn, */ refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable productTable;
	private JScrollPane productTableSP;
	
	private User user;
	private ProductRepo pr;
	private UserRepo ur;
	
	
	public CusViewProductFrame(User user)
	{
		super("Customer View Product Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		pr = new ProductRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Cost", "Amount"};
		
		productTable = new JTable(data,head);
		productTableSP = new JScrollPane(productTable);
		productTableSP.setBounds(350, 100, 400, 150);
		productTable.setEnabled(false);
		panel.add(productTableSP);
		
		productIdLabel = new JLabel("ID :");
		productIdLabel.setBounds(100,100,100,30);
		panel.add(productIdLabel);
		
		productIdTF = new JTextField();
		productIdTF.setBounds(220,100,100,30);
		panel.add(productIdTF);
		
		productNameLabel = new JLabel("Name :");
		productNameLabel.setBounds(100,150,100,30);
		panel.add(productNameLabel);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(220,150,100,30);
		panel.add(productNameTF);
		
		priceLabel = new JLabel("Cost: ");
		priceLabel.setBounds(100,200,100,30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
		priceTF.setBounds(220,200,100,30);
		panel.add(priceTF);
		
		quantityLabel = new JLabel("Amount: ");
		quantityLabel.setBounds(100,250,100,30);
		panel.add(quantityLabel);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(220,250,100,30);
		panel.add(quantityTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		/* insertBtn = new JButton("Insert");
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
		 */
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
			if(!productIdTF.getText().equals("") || !productIdTF.getText().equals(null))
			{
				Product p = pr.searchProduct(productIdTF.getText());
				if(p!= null)
				{
					productNameTF.setText(p.getProductName());
					priceTF.setText(p.getPrice()+"");
					quantityTF.setText(p.getQuantity()+"");
					
					productIdTF.setEnabled(false);
					productNameTF.setEnabled(true);
					priceTF.setEnabled(true);
					quantityTF.setEnabled(true);
					
					/* updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true); */
					refreshBtn.setEnabled(true);
					/* insertBtn.setEnabled(false); */
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		/*
		else if(command.equals(insertBtn.getText()))
		{
			Product p = new Product();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			p.setProductId(productIdTF.getText());
			p.setProductName(productNameTF.getText());
			p.setPrice(Double.parseDouble(priceTF.getText()));
			p.setQuantity(Integer.parseInt(quantityTF.getText()));
			
			u.setUserId(productIdTF.getText());
			u.setPassword(x+""); */
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
			/* pr.insertInDB(p);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+productIdTF.getText()+"and Password: "+x);
			
			productIdTF.setText("");
			productNameTF.setText("");
			priceTF.setText("");
			quantityTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false); 
			refreshBtn.setEnabled(false);
			
		}
		*/
		else if(command.equals(refreshBtn.getText()))
		{
			productIdTF.setText("");
			productNameTF.setText("");
			priceTF.setText("");
			quantityTF.setText("");
			
			productIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			//updateBtn.setEnabled(false);
			//deleteBtn.setEnabled(false); 
			refreshBtn.setEnabled(false);
		}
		/*
		else if(command.equals(updateBtn.getText()))
		{
			Product p = new Product();
			
			p.setProductId(productIdTF.getText());
			p.setProductName(productNameTF.getText());
			p.setPrice(Double.parseDouble(priceTF.getText()));
			p.setQuantity(Integer.parseInt(quantityTF.getText()));
			
			pr.updateInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			 
			productIdTF.setText("");
			productNameTF.setText("");
			priceTF.setText("");
			quantityTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false); 
			refreshBtn.setEnabled(false);
			
			productIdTF.setEnabled(true);
			productNameTF.setEnabled(true);
			priceTF.setEnabled(true);
			quantityTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(productIdTF.getText());
			ur.deleteUser(productIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			productIdTF.setText("");
			productNameTF.setText("");
			priceTF.setText("");
			quantityTF.setText("");
			
			productIdTF.setEnabled(true);
			productNameTF.setEnabled(true);
			priceTF.setEnabled(true);
			quantityTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		*/
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllProduct();
			String head[] = {"Id", "Name", "Price", "Quantity"};
			
			panel.remove(productTableSP);
			
			productTable = new JTable(data,head);
			productTable.setEnabled(false);
			productTableSP = new JScrollPane(productTable);
			productTableSP.setBounds(350, 100, 400, 150);
			panel.add(productTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				EmployeeHome eh = new EmployeeHome(user);
			    eh.setVisible(true);
			    this.setVisible(false);
			}
			else if(user.getStatus()==2)
			{
				CustomerHome ch = new CustomerHome(user);
			    ch.setVisible(true);
			    this.setVisible(false);
			}
			else{}
		}
		else{}
		
	}
}