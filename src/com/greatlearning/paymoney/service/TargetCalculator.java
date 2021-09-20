package com.greatlearning.paymoney.service;

public class TargetCalculator {
	public int calculateTarget(int[] txnAmount, int txnSize, int targetAmount) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<txnSize;i++) {
			if(targetAmount <=0) {
				return count;
			}
			else {
				targetAmount = targetAmount-txnAmount[i];
				count++;
			}
		}
		return 0;
	}
}
