package entity;		

import java.lang.*;
 
 public class Customer
 {
	private String cusId;
	private String name;
	private String address;
	private String phoneNumber;
	
	public Customer(){}
	public Customer(String cusId,String name,String address,String phoneNumber)
	{
		this.cusId=cusId;
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	public void setCusId(String cusId){this.cusId = cusId;}
	public void setName(String name){this.name=name;}
	public void setAddress(String address){this.address=address;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}
	
	public String getCusId(){return cusId;}
	public String getName(){return name;}
	public String getAddress(){return address;}
	public String getPhoneNumber(){return phoneNumber;}
 }
 