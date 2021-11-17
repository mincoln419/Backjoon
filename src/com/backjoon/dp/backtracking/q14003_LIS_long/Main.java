package com.backjoon.dp.backtracking.q14003_LIS_long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 1000001;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] arr = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int[] dp = new int[max];
		
		int size = 0;
		arr[size] = arr[0];
		dp[0] = size++;
		
		System.out.println(dp[0]);
		
		
	}

}
