package entity;

import java.lang.*;

public class Product
{
	private String productId;
	private String productName;
	private double price;
	private int quantity;
	
	public Product(){}
	public Product(String productId, String productName, double price,int quantity)
	{
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setProductId(String productId){this.productId = productId;}
	public void setProductName(String productName){this.productName = productName;}
	public void setPrice(double price){this.price = price;}
	public void setQuantity(int quantity){this.quantity =quantity;}
	
	public String getProductId(){return productId;}
	public String getProductName(){return productName;}
	public double getPrice(){return price;}
	public int getQuantity(){return quantity;}
}