package com.backjoon.fn;

public class Main {
	
	public static void main(String[] args) {
		
		int n = 1;
		while(n <= 10000) {
			System.out.println(n);
			n = d(n);
		}
		
		
	}
	
	static int d(int num) {
		
		String str = num + "";
		
		int sum = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			int value = Integer.parseInt(String.valueOf(str.charAt(i)));
			sum += value;
		}
		sum += num;
		return sum;
	}

}
