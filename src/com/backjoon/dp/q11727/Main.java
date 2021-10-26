package com.backjoon.dp.q11727;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 문제 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	 * 
	 * 아래 그림은 2×17 직사각형을 채운 한가지 예이다.
	 * 
	 * 
	 * 
	 * 입력 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
	 * 
	 * 출력 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
	 * 
	 */
	static int MOD = 10007;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		int n = Integer.parseInt(bf.readLine());
		
		//점화식구해서 dp로 처리
		int[] dp = new int[n + 2];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		//dp[4] = dp[3] * 2 - 1;
		
		for(int i = 3 ; i <= n ; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2)%MOD;
		}
		System.out.println(dp[n]);
	}

}
