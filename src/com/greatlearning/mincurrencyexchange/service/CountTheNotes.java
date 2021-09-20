package com.greatlearning.mincurrencyexchange.service;

public class CountTheNotes {
	public void merge(int[] denomination, int left, int mid, int right) {
		int n1 = mid-left+1;
		int n2 = right-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i=0;i<n1;i++)
			L[i] = denomination[left+i];
		for(int i=0;i<n2;i++)
			R[i] = denomination[mid+1+i];
		int i=0, j=0, k=left;
		while(i<n1 && j<n2) {
			if(L[i] >= R[j]) {
				denomination[k] = L[i];
				i++;
			}
			else {
				denomination[k] = R[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			denomination[k] = L[i];
			i++;
			k++;
		}
		while(j<n2) {
			denomination[k] = R[j];
			j++;
			k++;
		}
	}
	
	public void sortDesc(int[] denomination, int left, int right) {
		// TODO Auto-generated method stub
		if(left<right) {
			int mid = (right+left)/2;
			sortDesc(denomination, left, mid);
			sortDesc(denomination, mid+1, right);
			merge(denomination, left, mid, right);
		}
			
	}
	public void getMinCur(int[] denomination, int noOfDeno, int payAmount) {
		int[] noOfNotes = new int[noOfDeno];
		if(payAmount<=0) {
			System.out.println("Payment amount should be greater than 0");
			return;
		}
		try {
			for(int i=0;i<noOfDeno;i++) {
				if(payAmount>0 && payAmount>=denomination[i]) {
					noOfNotes[i] = payAmount/denomination[i];
					payAmount = payAmount - (noOfNotes[i] * denomination[i]);
				}
			}
			if(payAmount>0) {
				System.out.println("The amount can not be paid.");
				return;
			}
			else {
				System.out.println("Your payment approach in order to give min no of notes will be ");
				for(int i=0;i<noOfDeno;i++) {
					if(noOfNotes[i]!=0)
						System.out.println(denomination[i] +":"+ noOfNotes[i]);
				}
			}
		} catch(ArithmeticException e) {
			System.out.println(e+" Denomination can not be 0!");
		}
	}
}
