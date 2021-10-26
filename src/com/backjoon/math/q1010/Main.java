package com.backjoon.math.q1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	static long[][] ferma;
	static int MOD = 10007;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		for(int i = 0 ; i < n ; i ++) {
			String[] read = bf.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			ferma = new long[a + 1][b + 1];
			System.out.println(dp(a, b));
		}
		
		bf.close();
	}
	//페르마 소정리로 조합 경우의 수 구함
	static long dp(int a, int b) {
		
		if(a == b || a == 0)return 1;
		
		if(ferma[a][b] == 0) {
			ferma[a][b] = dp(a-1, b-1) + dp(a, b - 1);
		}
		
		return ferma[a][b];
	}

}
