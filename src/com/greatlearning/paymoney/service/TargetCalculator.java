package com.greatlearning.paymoney.service;

import java.util.Arrays;

public class TargetCalculator {
	public int calculateTarget(int[] txnAmount, int txnSize, int targetAmount) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<txnSize;i++) {
			if(targetAmount > 0) {
				targetAmount = targetAmount-txnAmount[i];
				count++;
			}
		}
		if(targetAmount <=0) {
			return count;
		}
		return 0;
	}
}