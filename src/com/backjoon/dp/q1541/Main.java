package com.backjoon.dp.q1541;

import java.io.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//+, - 기호만 있을 때 제일 작게 하려면 - 이후에 있는 수를 다 괄호로 묶으면 됨
		
		String renew = bf.readLine().replace("+", " + ");
		renew = renew.replace("-", " - ");
		
		String[] arr = renew.split(" ");
		
		int sum = 0;
		boolean flag = true; // true 일때는 더하고 false일때는 마이너스 -> 한번 마이너스가 나오면 그 뒤의 값을 다 묶어서 마이너스 처리가능
		for(int i = 0 ; i < arr.length; i ++) {
			
			if(flag && arr[i].charAt(0) == '-')flag = false;
			if(arr[i].charAt(0) >= '0' && arr[i].charAt(0) <= '9') {//숫자일경우
				int num = Integer.parseInt(arr[i]);
				if(flag)sum += num;
				else sum -= num;
			}
		}
		
		System.out.println(sum);
		
	}
}
