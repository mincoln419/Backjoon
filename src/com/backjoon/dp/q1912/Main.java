package com.backjoon.dp.q1912;

import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		
		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1 ; i < n + 1 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//점화식 전 초기값 세팅
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		int answer =  dp[1];
		for(int i = 2 ; i <= n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i-1] + arr[i]);
			dp[i] = Math.max(dp[i], arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}
