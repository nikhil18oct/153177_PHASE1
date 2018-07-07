package com.cg.mypaymentapp.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mypaymentapp.beans.*;
import com.cg.mypaymentapp.exception.*;
import com.cg.mypaymentapp.service.*;

public class TestClass {

	
	@Test(expected=InvalidInputException.class)
	public void exceptionTest1() 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312m",new BigDecimal(25000));
			   
	}
	
	
	
	
	
	@Test(expected=InvalidInputException.class)
	public void exceptionTest2() 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","90328",new BigDecimal(25000));
			   
	}
	
	@Test(expected=InvalidInputException.class)
	public void exceptionTest3() 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.createAccount("Thakur","9032858312",new BigDecimal(5000));
			   
	}
	
	@Test(expected=InvalidInputException.class)
	public void exceptionTest4() 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","",new BigDecimal(25000));
			   
	}
	

	
	
	@Test(expected=InvalidInputException.class)
	public void exceptionTest6() 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("","",new BigDecimal(25000));
			   
	}
	
	
	
	
		
	@Test
	public void objectCustomer() 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));   
	}
	
	
	
	@Test(expected=InvalidInputException.class)
	public void showbalanceTest() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.showBalance("90328583");
	 }
	
	
	
	@Test(expected=InsufficientBalanceException.class)
	public void insufficientamountTest() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.createAccount("thakur","9849934120",new BigDecimal(10000)); 
	 service.fundTransfer("9032858312", "9849934120", new BigDecimal(26000));
	 }
	
	@Test(expected=InvalidInputException.class)
	public void negativeFundTransferTest() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.createAccount("thakur","9849934120",new BigDecimal(10000)); 
	 service.fundTransfer("9032858312", "9849934120", new BigDecimal(-10000));
	 }
	
	@Test(expected=InvalidInputException.class)
	public void fundTransferTest() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.createAccount("thakur","9849934120",new BigDecimal(10000)); 
	 service.fundTransfer("903285832", "9934120", new BigDecimal(-10000));
	 }
	
	@Test(expected=InvalidInputException.class)
	public void fundTransferTest1() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.createAccount("thakur","9849934120",new BigDecimal(10000)); 
	 service.fundTransfer("", "9849934120", new BigDecimal(-10000));
	 }
	
	
	
	
	
	@Test
	public void depositTest() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 Customer c=service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 c=service.depositAmount("9032858312",new BigDecimal(5000));
	 assertEquals(c.getWallet().getBalance(),new BigDecimal(30000));
	}
	
	
	
	@Test(expected=InvalidInputException.class)
	public void depositTest1() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(-25000)); 
	}
	
	@Test
	public void depositTest2() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 Customer c=service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 c=service.depositAmount("9032858312",new BigDecimal(5000));
	 assertEquals(c.getName(),"nikhil");
	}
	
	@Test
	public void depositTest3() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 Customer c=service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 c=service.depositAmount("9032858312",new BigDecimal(5000));
	 assertEquals(c.getMobileNo(),"9032858312");
	}
	
	
	
	
	

	@Test(expected=InsufficientBalanceException.class)
	public void insufficientamountTest1() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.withdrawAmount("9032858312", new BigDecimal(26000)); 
	 
	 }
	
	
	
	@Test(expected=InvalidInputException.class)
	public void insufficientamountTest2() throws Exception 
	{
	 WalletService   service=new WalletServiceImpl();
	 service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 service.withdrawAmount("90328583m", new BigDecimal(2000)); 
	 
	 }
	
	
	@Test
	public void insertHashMap() 
	{
	 WalletService   service=new WalletServiceImpl();
	 Customer c=service.createAccount("nikhil","9032858312",new BigDecimal(25000));
	 Map<String,Customer> m=new HashMap<>();
	 m.put(c.getMobileNo(),c);
	 assertEquals(m.containsKey("9032858312"),true);
			   
	}

}
