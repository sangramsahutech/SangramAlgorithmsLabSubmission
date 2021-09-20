package com.greatlearning.mincurrencyexchange.driver;

import java.util.Scanner;

import com.greatlearning.mincurrencyexchange.service.CountTheNotes;

public class CurrencyExchangeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations ");
		int noOfDeno = sc.nextInt();
		int[] denomination = new int[noOfDeno];
		int holdDeno = 0;
		System.out.println("Enter the currency denominations value ");
		for(int i=0;i<noOfDeno;i++) {
			holdDeno = sc.nextInt();
			if(holdDeno>=0) {
				denomination[i] = holdDeno;
			}
			else {
				System.out.println("Denomination can not be negative!");
				i -= 1;
			}
		}
		System.out.println("Enter the amount you want to pay ");
		int payAmount = sc.nextInt();
		CountTheNotes cash = new CountTheNotes();
		cash.sortDesc(denomination, 0, noOfDeno-1);
		cash.getMinCur(denomination, noOfDeno, payAmount);
		sc.close();
	}

}
