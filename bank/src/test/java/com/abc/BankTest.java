package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

   /* @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }*/
    
    @Test
        public void transferBetweenAccounts() {
    	Bank bank = new Bank();
    	Customer bill = new Customer("Bill");
    	
    	//create checking and saving accounts for bill
    	Account checkingAccount = new Account(Account.CHECKING);
    	Account savingsAccount = new Account(Account.SAVINGS);
    	
    	// Open checking and savings accounts for Bill
          bill.openAccount(checkingAccount);
          bill.openAccount(savingsAccount);
          
       // Deposit 500 in checking account and 800 in savings account
           checkingAccount.deposit(500);
           savingsAccount.deposit(800);
          
        // Add Bill as customer to the bank
             bank.addCustomer(bill);
                  
                  
       // Transfer 100 from savings account to checking account
           bill.transferBetweenAccounts(savingsAccount, checkingAccount, 100.0);
           assertTrue( (checkingAccount.sumTransactions() == 600.0)&&(savingsAccount.sumTransactions() == 700.0));
          }		     
       }		 
        
   
