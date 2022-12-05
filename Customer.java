package com.nissan.App;

import java.util.Scanner;

public class Customer {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		try {
		System.out.println("Enetr Customer Name");
		String CustomerName=input.nextLine();
		
		System.out.println("Enetr account number");
		int accountNumber=input.nextInt();
		
		System.out.println("Eneter Min Amount");
		double minBal=input.nextDouble();
		double balance=minBal;
	
		
		char choice='n';
		do {
			System.out.println("What do you want\n1.Deposte\n2.Withdraw\n3.Show balance\n4.Trancefer");
			int option=input.nextInt();
			switch(option) {
			case 1:balance=Deposite(balance);
				break;
			case 2:balance=Withdraw(balance,minBal);
				break;
			case 3:ShowBalance(CustomerName,accountNumber,balance);
				break;
			case 4:balance=Transfer(balance,accountNumber,minBal);
				break;
			default:
				System.out.println("Enetr correction option");
			}
			System.out.println("Do you want Continue(y/n)");
			choice=input.next().charAt(0);
		}
		while(choice=='Y' || choice=='y');
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Thank You..!!!!");
		}
		
		
		
	}

	private static double Transfer(double balance ,int accountNumber,double minBal) {
		System.out.println("Enetr your account number");
		int aNumber=input.nextInt();
		
		System.out.println("Enetr account number to transfer");
		int TransferAccountNumber=input.nextInt();
		
		if(accountNumber==aNumber) {
			System.out.println("Enetr amount to be transferd");
			double amount=input.nextInt();
			if(amount>(balance-minBal)) {
				System.out.println("Transfered Amount Unsuccesfully...!!");
				System.out.println("Insufficent Funds..!!!");
			}
			else {
			balance=balance-amount;
			System.out.println("Transfered Amount Succesfully...!!");
			}
			return balance;
		}
		else {
			System.out.println("Transfered Amount Unsuccesfully..!!!");
			System.out.println("Incorrect account number");
		}
		return balance;
		
	}

	private static void ShowBalance(String customerName, int accountNumber, double balance) {
		System.out.println("Your Details\nAccount Holder name: " +customerName+"\nAccount number: "+accountNumber);
		System.out.println("Available balance: " +balance);
		
	}

	private static double Withdraw(double balance,double min) {
		double availableBalnace=balance-min;
		System.out.println("Enetr WithDraw Amount");
		try {
			double amount =input.nextDouble();
			if(amount>availableBalnace) {
				System.out.println("Insufficent Funds..!!!");
				
			}
			else if(amount>50000) {
				System.out.println("Enetr PAN Card number");
				String panNumber=input.nextLine();
				balance=balance-amount;
			}
			else {
				balance=balance-amount;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return balance;
		
		
	}

	private static double Deposite(double balance) {
		try {
			System.out.println("Enetr Amount");
			double amount=input.nextDouble();
			if(amount >50000) {
				System.out.println("Enetr PAN Card number");
				String panNumber=input.nextLine();
			}
			balance+=amount;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return balance;
		
	}

}
