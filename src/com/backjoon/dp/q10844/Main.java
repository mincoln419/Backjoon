package com.backjoon.dp.q10844;
import java.util.*;
import java.io.*;
public class Main {

	static int MOD = 1000000000;

	/*
	 * 문제:
	 * 45656이란 수를 보자.
	 * 
	 * 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
	 * 
	 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
	 * 
	 * 입력: 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
	 * 
	 * 출력: 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
	 * 
	 */
	static int[][] memo;
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		//memo에는 i로 시작하는 자리수를 기록
 		memo = new int[10][n];
 		
 		//탐색하지 않은 값 -1로 초기 세팅
 		for(int i = 0; i < 10 ; i ++) {
 			Arrays.fill(memo[i], -1);
 			memo[i][0] = 1;//단, 나머지 자리수가 0일 경우 = 숫자 한개로 만들수 있는 계단수는 1개임.
 		}
		
		int sum = 0;
		for(int i = 1 ; i <= 9 ; i++) {
			sum += dp(i , n - 1);
			sum %= MOD;
		}
		
		System.out.println(sum + "");
	}
	
	static int dp(int pre, int rem) {
		
		if(memo[pre][rem] == -1) {
			
			int sum = 0;
			if(pre + 1 <= 9) {
				 sum += dp(pre + 1, rem - 1);
			} 
			if(pre - 1 >= 0) {
				sum += dp(pre - 1, rem - 1);
			}
			memo[pre][rem] = sum%MOD;
		}

		return memo[pre][rem];
	}
}
