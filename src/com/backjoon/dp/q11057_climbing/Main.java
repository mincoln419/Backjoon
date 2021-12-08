package com.backjoon.dp.q11057_climbing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int MOD = 10007;

	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		//오르막수
		dp = new int[n + 1][10];//자리수에 대해 마진을 준다 
		Arrays.fill(dp[1], 1);
		
		for(int i = 1 ; i < n; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				for(int k = j ; k < 10; k++) {
					dp[i + 1][j] = (dp[i + 1][j] + dp[i][k]) % MOD;  
				}
			}
		}
		
		int answer = 0;
		for(int i = 0 ; i < 10; i++) {
			answer = (answer + dp[n][i]) % MOD;
		}
		bw.write(answer + "\n");
		bf.close();
		bw.flush();
		bw.close();
		
	}

}
