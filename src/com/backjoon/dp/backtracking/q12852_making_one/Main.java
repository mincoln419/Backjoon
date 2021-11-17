package com.backjoon.dp.backtracking.q12852_making_one;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	
	static int INF = 1000001;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[INF];// dp에는 해당 숫자를 만들기 위한 최소 연산 횟수를 저장 -> 신규가 이전보다 클 경우에는 dp에 저장하지 않음
		int[] before = new int[INF];//이전 숫자가 어떤 수인지 저장
		
		dp[1] = 0;
		for(int i = 1 ; i <= n ; i++) {
			
			if(i * 3 < INF) {
				if(dp[i * 3] == 0 || dp[i] + 1 < dp[i * 3]) {
					dp[i * 3] = dp[i] + 1;
					before[i * 3] = i;
				}
			}
			
			if(i * 2 < INF) {
				if(dp[i * 2] == 0 || dp[i] + 1 < dp[i * 2]) {
					dp[i * 2] = dp[i] + 1;
					before[i * 2] = i;
				}
			}
			
			if(i + 1 < INF) {
				if(dp[i + 1] == 0 || dp[i] + 1 < dp[i + 1]) {
					dp[i + 1] = dp[i] + 1;
					before[i + 1] = i;
				}
			}
		}
		
		System.out.println(dp[n]);
		
		while(true) {
			if(n == 1) {
				System.out.println(n);
				break;
			}
			
			System.out.print(n + " ");
			n = before[n];
		}
	}	
}
