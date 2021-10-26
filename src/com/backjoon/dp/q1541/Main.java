package com.backjoon.dp.q1541;

import java.io.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//+, - ��ȣ�� ���� �� ���� �۰� �Ϸ��� - ���Ŀ� �ִ� ���� �� ��ȣ�� ������ ��
		
		String renew = bf.readLine().replace("+", " + ");
		renew = renew.replace("-", " - ");
		
		String[] arr = renew.split(" ");
		
		int sum = 0;
		boolean flag = true; // true �϶��� ���ϰ� false�϶��� ���̳ʽ� -> �ѹ� ���̳ʽ��� ������ �� ���� ���� �� ��� ���̳ʽ� ó������
		for(int i = 0 ; i < arr.length; i ++) {
			
			if(flag && arr[i].charAt(0) == '-')flag = false;
			if(arr[i].charAt(0) >= '0' && arr[i].charAt(0) <= '9') {//�����ϰ��
				int num = Integer.parseInt(arr[i]);
				if(flag)sum += num;
				else sum -= num;
			}
		}
		
		System.out.println(sum);
		
	}
}
