package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    public final double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }
    // added values
	public Date getTransactionDate() {
		// TODO Auto-generated method stub
		return transactionDate;
	}
	
	//added values

	public void setTransactionDate(Date transactionDate) {
				this.transactionDate = transactionDate;
			}

	

	
}
