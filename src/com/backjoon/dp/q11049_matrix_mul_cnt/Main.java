package com.backjoon.dp.q11049_matrix_mul_cnt;

import java.io.*;

public class Main {

	static int INF = Integer.MAX_VALUE/2;
	static Integer[][] cache;//시작점, 종점 별 최소비용 메모화
	static Integer[][] arr;
	static int[] presum;//현재 index까지의 합꼐
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		arr = new Integer[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
			arr[i][0] = Integer.parseInt(read[0]);
			arr[i][1] = Integer.parseInt(read[1]);
		}
		cache = new Integer[n][n];
		
		int sum = dp(0, n - 1);
		
		System.out.println(sum);
	}
	
	static int dp(int bgn, int end) {
		
		if(cache[bgn][end] != null)return cache[bgn][end];
		if(bgn == end) return cache[bgn][end] = 0;
		if(end - bgn == 1) {
			return cache[bgn][end] = arr[bgn][0] * arr[bgn][1] * arr[end][1];
		}
		cache[bgn][end] = INF;
		for(int i = bgn ; i < end; i++) {
			cache[bgn][end] = Math.min(dp(bgn, i) + dp(i + 1, end) + arr[bgn][0]* arr[i][1] * arr[end][1], cache[bgn][end]);
		}
		
		return cache[bgn][end];
	}
}
