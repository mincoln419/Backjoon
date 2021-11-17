package com.backjoon.dp.backtracking.q14002_LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int max = 1000000;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] arr = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[max]; // 현재 index까지의 증가하는 수열 길이
		int[] before = new int[max]; //현재보다 작은 수가 있는 직전 인덱스 위치
		
		dp[0] = 1;
		
		int length = 0;
		for(int i = 1 ; i < n ; i++) {
			for(int j = i - 1 ; j >= 0; j--) {//현재 수 이전 수중에서 적은 수중 가장 가까운 값
				if(arr[j] < arr[i]) {
					if(dp[i] == 0 || dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						before[i] = j;
						length = Math.max(length, dp[i]);
					}
				}
			}
			if(dp[i] == 0)dp[i] = 1;
		}
		
		System.out.println(length);
		Stack<Long> answer = new Stack<>();
		for(int i = 0 ; i < n ; i ++) {
			if(dp[i] == length) {
				while(true) {
					if(dp[i] == 1) {
						answer.add(arr[i]);
						break;
					}
					answer.add(arr[i]);
					i = before[i];
				}
				break;
			}
		}
		
		while(!answer.isEmpty()) {
			System.out.print(answer.pop());
		}
	}
}
