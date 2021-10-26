package com.backjoon.math.q11050;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	static long[][] ferma;
	static int MOD = 10007;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] read = bf.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);
		
		
		
		//이항계수 - 조합
		// nC2 = n!/k! * (n-k)!
		// 
		ferma = new long[n+1][k+1];//페르마 정리에 의한 조합값을 메모화 
				
		System.out.println(dp(n, k));
		
		
		bf.close();
	}

	static long dp(int n, int k) {

		if(n == k || k == 0) {
			return ferma[n][k] = 1;	
		}

		if(ferma[n][k] == 0) {
			ferma[n][k] = (dp(n - 1, k - 1) + dp(n - 1, k)) % MOD;
		}
		
		return ferma[n][k];
	}
}
