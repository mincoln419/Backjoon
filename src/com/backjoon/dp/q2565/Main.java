package com.backjoon.dp.q2565;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		int[] dp = new int[n];
		
		Arrays.fill(dp, 1);
		
		// top-bottom
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int answer = 1;

		Arrays.sort(arr, (o1, o2) ->{
			if(o1[0] > o2[0])return 1;
			else if(o1[0] == o2[0]) {
				if(o1[1] > o2[1])return 1;
			}
			return -1;
		});
		
		for (int i = 0; i < n; i++) {
			//가장긴 증가하는수열
			int[] next = arr[i];		
			for (int j = 0; j < i; j++) {
				if (next[0] > arr[j][0] && next[1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			answer = Math.max(dp[i], answer);
		}

		System.out.println(n - answer);
	}
	
}
