package com.cg.mypaymentapp.repo;

import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;

public class WalletRepoImpl implements WalletRepo{

	private Map<String, Customer> data; 
	public WalletRepoImpl(Map<String, Customer> data) 
	{
		super();
		this.data = data;
	}

	public boolean save(Customer customer) 
	{
		data.put(customer.getMobileNo(),customer);
		if(data.isEmpty())
			return false;
		return true;
	}
	

	public Customer findOne(String mobileNo) 
	{
		for (Customer customer:data.values() ) 
		{
			if(customer.getMobileNo().equals(mobileNo))
				return customer;
		}	
		return null;
	}
	
	
}
