package com.wipro.ccbill.main;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.wipro.ccbill.entity.CreditCardBill;
import com.wipro.ccbill.entity.Transaction;
public class MainClass {

	public static void main(String [] args)
	{
		try{   
			
			String s="1111222233334444";
			DecimalFormat df = new DecimalFormat("#.###");
			Transaction monthsTransaction [] = new Transaction[5]; 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			monthsTransaction[0]=new Transaction(s,formatter.parse("01/02/2016"),"household",8000.0,"DB");
			monthsTransaction[1]=new Transaction(s,formatter.parse("05/02/2016"),"Textile",12000.0,"DB");
			monthsTransaction[2]=new Transaction(s,formatter.parse("12/02/2016"),"movie",2700.0,"DB"); 
			monthsTransaction[3]=new Transaction(s,formatter.parse("16/02/2016"),"paid",19000.0,"CR");
			monthsTransaction[4]=new Transaction(s,formatter.parse("19/02/2016"),"household",4500.0,"DB");
			CreditCardBill ccbill = new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016") ,monthsTransaction); 
			System.out.println("Total to be paid : "+df .format(ccbill.calculateBillAmount()));  
			}
		catch(Exception e)
		{
			System.out.println(e);
		} 
	}
}
