package com.backjoon.dp.q11054;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		int[] l_dp = new int[n];
		int[] r_dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// top-bottom
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			arr[i] = next;
			l_dp[i] = 1;
			r_dp[i] = 1;
		}
		//memo[1] = 0;
		
		int answer = 1;

		for (int i = 0; i < n; i++) {
			//가장긴 증가하는수열
			int next = arr[i];		
			for (int j = 0; j < i; j++) {
				if (next > arr[j]) {
					l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
				}
			}

			//가장 긴 감소하는 수열
			next = arr[(n - 1) - i];
			for(int j = n - 1 ; j >= n - i; j--) {//last[i]인덱스부터 내림차순으로 검색 추가로 들어감
				if (next > arr[j]) {
					r_dp[(n - 1) - i] = Math.max(r_dp[(n - 1) - i], r_dp[j] + 1);
				}
			}
		}
		
		for(int i = 0 ; i < l_dp.length ;i++) {
			answer = Math.max(l_dp[i] + r_dp[i] - 1, answer);
		}
		
		System.out.println(answer);
	}
}