package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PurchaseInfoRepo 
{
	DatabaseConnection dbc;
	
	public PurchaseInfoRepo()
	{
		dbc = new DatabaseConnection();
	}
	/*
	public void insertInDB(Employee e)
	{
		String query = "INSERT INTO employees VALUES ('"+e.getEmpId()+"','"+e.getName()+"','"+e.getDesignation()+"',"+e.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String empId)
	{
		String query = "DELETE from employees WHERE empId='"+empId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Employee e)
	{
		String query = "UPDATE employees SET employeeName='"+e.getName()+"', designation = '"+e.getDesignation()+"', salary = "+e.getSalary()+" WHERE empId='"+e.getEmpId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	*/
	public Employee searchPurchaseInfo(String purchaseId)
	{
		
		String query = "SELECT `purchaseId`, `cusId`, `productId`, `productName`, `price`, `quantity` FROM `purchaseinfo` WHERE `purchaseId`='"+purchaseId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				emp = new Employee();
				emp.setEmpId(empId);
				emp.setName(name);
				emp.setDesignation(designation);
				emp.setSalary(salary);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	
	public String[][] getAllEmployee()
	{
		ArrayList<Product> ar = new ArrayList<Product>();
		String query = "SELECT * FROM product;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String productId = dbc.result.getString("productId");
				String productName = dbc.result.getString("productName");
				String price = dbc.result.getString("price");
				double quantity = dbc.result.getDouble("quantity");
				
				Product p = new Product(productId,productName,price,quantity);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getProductId();
			data[i][1] = ((Product)obj[i]).getProductName();
			data[i][2] = ((Product)obj[i]).getPrice()+"";
			data[i][3] = (((Product)obj[i]).getQuantity())+"";
		}
		return data;
	}
}




