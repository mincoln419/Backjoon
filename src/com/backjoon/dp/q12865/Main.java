package com.backjoon.dp.q12865;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(bf.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n + 1][k + 1];
		
	
		//dp[weight]에 무게가 weight 만큼 되는 경우의 가치의 최대값을 입력한다. -> 추가할수 없는 경우는 해당 무게값 메모화를 이전 i값에서 그대로 가져온다
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= k; j++){//
				if(w[i] > j) {//해당 메모값에 추가할 수 없으므로 그대로 가져감 
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]]+ v[i]);
				}
				
			}
		}
		
		System.out.println(dp[n][k]);
		
	}
}
