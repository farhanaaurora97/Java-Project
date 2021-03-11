package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Customer c)
	{
		String query = "INSERT INTO customer VALUES ('"+c.getCusId()+"','"+c.getName()+"','"+c.getAddress()+"',"+c.getPhoneNumber()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String cusId)
	{
		String query = "DELETE from customer WHERE cusId='"+cusId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateInDB(Customer c)
	{
		String query = "UPDATE customer SET customerName='"+c.getName()+"', address = '"+c.getAddress()+"', phoneNumber = "+c.getPhoneNumber()+" WHERE cusId='"+c.getCusId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Customer searchCustomer(String cusId)
	{
		Customer cus = null;
		String query = "SELECT `customerName`, `address`, `phoneNumber` FROM `customer` WHERE `cusId`='"+cusId+"';"; 
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("customerName");
				String address = dbc.result.getString("address");
				String phoneNumber = dbc.result.getString("phoneNumber");
				
				cus = new Customer(cusId,name,address,phoneNumber);
				cus.setCusId(cusId);
				cus.setName(name);
				cus.setAddress(address);
				cus.setPhoneNumber(phoneNumber);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return cus;
	}
	public String[][] getAllCustomer()
	{
		ArrayList<Customer> ar = new ArrayList<Customer>();
		String query = "SELECT * FROM customer;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String cusId = dbc.result.getString("cusId");
				String name = dbc.result.getString("customerName");
				String address = dbc.result.getString("address");
				String phoneNumber = dbc.result.getString("phoneNumber");
				
				Customer c = new Customer(cusId,name,address,phoneNumber);
				ar.add(c);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Customer)obj[i]).getCusId();
			data[i][1] = ((Customer)obj[i]).getName();
			data[i][2] = ((Customer)obj[i]).getAddress();
			data[i][3] = (((Customer)obj[i]).getPhoneNumber());
		}
		return data;
	}
}




