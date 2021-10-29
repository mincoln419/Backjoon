package com.backjoon.distribution.q11401;

import java.io.*;

public class Main {

	static int MOD = 1000000007;
	static int x;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String read[] = bf.readLine().split(" ");
		
		int n = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);
		//combination mod = (n!/ (n-k)!k!) mod
		// 1 * n! *x mod = (n!/(n-k)!k!)  mod -> �̷��� �Ƿ��� n, k�� �ּҰ��� �־ �����ϰ� �۵��ؾ� �� mod�� ����..
 
		//�켱 ���丮���� ���� ���ϰ�
		//�и�
		long number = factorial(n);
		//�и�
		long denom = factorial(k) * factorial(n-k) % MOD;
		//������ ���Ѵ�
		long x = dsb(denom, (long)MOD -2);
		
		System.out.println(number * x % MOD);
		
		bf.close();
	}
	//��� ȣ��� �θ��� �޸� �ƿ�
	static long factorial(long num) {
		long result = 1L;
		
		while(num > 1) {
			result = (result * num) % MOD;
			num--;
		}
		
		return result;
	}
	
	
	
	static long dsb(long A, long B) {//�ΰ��� ������ ���
		
		if(B == 0)return 1 % MOD;
		
		long d = dsb(A, B/2);
		if(B % 2 == 0) {
			return (long)d * d % MOD;
		}else {
			return (long)d * d % MOD * A % MOD;
		}
	}
}
