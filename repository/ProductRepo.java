package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class ProductRepo implements IProductRepo
{
	DatabaseConnection dbc;
	
	public ProductRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Product p)
	{
		String query = "INSERT INTO product VALUES ('"+p.getProductId()+"','"+p.getProductName()+"','"+p.getPrice()+"',"+p.getQuantity()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
		public void deleteFromDB(String productId)
	{
		String query = "DELETE from product WHERE productId='"+productId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
		public void updateInDB(Product p)
	{
		String query = "UPDATE product SET productName='"+p.getProductName()+"', price = '"+p.getPrice()+"', quantity = "+p.getQuantity()+" WHERE productId='"+p.getProductId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
		public Product searchProduct(String productId)
	{
		Product pro = null;
		String query = "SELECT `productName`, `price`, `quantity` FROM `product` WHERE `productId`='"+productId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String productName = dbc.result.getString("productName");
				double price = dbc.result.getDouble("price");
				int quantity = dbc.result.getInt("quantity");
				pro = new Product();
				pro.setProductId(productId);
				pro.setProductName(productName);
				pro.setPrice(price);
				pro.setQuantity(quantity);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return pro;
	}
	public String[][] getAllProduct()
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
				double price = dbc.result.getDouble("price");
				int quantity = dbc.result.getInt("quantity");
				
				
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




