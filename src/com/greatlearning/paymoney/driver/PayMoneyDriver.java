package com.greatlearning.paymoney.driver;

import java.util.Scanner;

import com.greatlearning.paymoney.service.TargetCalculator;

public class PayMoneyDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TargetCalculator tc = new TargetCalculator();
		System.out.println("Enter the size of transaction array ");
		int txnSize = sc.nextInt();
		int[] txnAmount = new int[txnSize]; 
		System.out.println("Enter the values of array ");
		for(int i=0;i<txnSize;i++)
			txnAmount[i] = sc.nextInt();
		System.out.println("Enter the total no of targets that needs to be achieved ");
		int maxTxnsTarget = sc.nextInt();
		while(maxTxnsTarget !=0) {
			System.out.println("Enter the value of target ");
			int targetAmount = sc.nextInt();
			if(targetAmount<=0)
				System.out.println("Please enter valid target amount greater than 0");
			else {
				int res = tc.calculateTarget(txnAmount, txnSize, targetAmount);
				if(res == 0)
					System.out.println("Given target is not achieved.");
				else
					System.out.println("The target achieved after "+res+" transactions.");
				maxTxnsTarget--;
			}
		}
	}

}
