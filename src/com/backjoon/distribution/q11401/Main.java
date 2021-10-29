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
		// 1 * n! *x mod = (n!/(n-k)!k!)  mod -> 이렇게 되려면 n, k에 최소값을 넣어도 동일하게 작동해야 함 mod의 역원..
 
		//우선 팩토리얼을 각각 구하고
		//분모
		long number = factorial(n);
		//분모
		long denom = factorial(k) * factorial(n-k) % MOD;
		//역원을 구한다
		long x = dsb(denom, (long)MOD -2);
		
		System.out.println(number * x % MOD);
		
		bf.close();
	}
	//재귀 호출로 부르면 메모리 아웃
	static long factorial(long num) {
		long result = 1L;
		
		while(num > 1) {
			result = (result * num) % MOD;
			num--;
		}
		
		return result;
	}
	
	
	
	static long dsb(long A, long B) {//두개로 나눠서 계산
		
		if(B == 0)return 1 % MOD;
		
		long d = dsb(A, B/2);
		if(B % 2 == 0) {
			return (long)d * d % MOD;
		}else {
			return (long)d * d % MOD * A % MOD;
		}
	}
}
