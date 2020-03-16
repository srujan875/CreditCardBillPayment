package com.wipro.ccbill.entity;

import java.util.Date;

import com.wipro.ccbill.exception.InputValidationException;

public class CreditCardBill {

	private String creditCardNo;
	private String customerId;
	private Date billDate;
	private Transaction monthTransactions[];
	public CreditCardBill() {
		super();
	}
    public CreditCardBill(String creditCardNo, String customerId, Date billDate, Transaction[] monthTransactions) {
		
		this.creditCardNo = creditCardNo;
		this.customerId = customerId;
		this.billDate = billDate;
		this.monthTransactions = monthTransactions;
	}
    
    
    
    public double getTotalAmount(String transactionType)
    {
    	if(!(transactionType.equals("CR") || transactionType.equals("DB")))
    	{
    		return (double)0;
    	}
    	
    	double totalamount=0.0;
    	
    	for(int i=0;i<monthTransactions.length;i++)
    	{
    		if(monthTransactions[i].getTransactionType().equals(transactionType))
    		{
    		totalamount=totalamount+monthTransactions[i].getTransactionAmount();
    	    }
    	}
    	
    	return totalamount;
    }
    
    
  
    public double calculateBillAmount() throws InputValidationException
    {
    	double CRamount=0;
    	double DBamount=0;
    	if(!validateData().equals("valid"))
    	{
    		throw new InputValidationException();
    	}
    	else
    	{
    		if(monthTransactions!=null && monthTransactions.length>0)
    		{
    			for(int i=0;i<monthTransactions.length;i++)
    			{
    				if(monthTransactions[i].getTransactionType().equals("CR"))
    					CRamount+=monthTransactions[i].getTransactionAmount();
    				
    				if(monthTransactions[i].getTransactionType().equals("DB"))
    					DBamount+=monthTransactions[i].getTransactionAmount();
    			}
    			
    			double outstandingpaid=Math.abs(DBamount-CRamount);
    			double totalAmount=(outstandingpaid*19.9)/1200;
    					
    					return outstandingpaid+totalAmount;
    		}
    		else
    			return 0.0;
    	}
		
    }
    
    public String validateData() throws InputValidationException
    {
    	if(creditCardNo==null)
    	{
    		throw new InputValidationException();
    	}
    	if(creditCardNo.length()!=16)
    	{
    		throw new InputValidationException();
    	}
    	if(customerId==null)
    	{
    		throw new InputValidationException();
    	}
    	if(customerId.length()<6)
    	{
    		throw new InputValidationException();
    	}
    	else
    		return "valid";
    }
    
    
    
	public String getCreditCardNo() {
		return creditCardNo;
	}
    public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	public String getCustomerId() {
		return customerId;
	}
    public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    public Date getBillDate() {
		return billDate;
	}
    public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
    public Transaction[] getMonthTransactions() {
		return monthTransactions;
	}
    public void setMonthTransactions(Transaction[] monthTransactions) {
		this.monthTransactions = monthTransactions;
	}
	
   
}
