package com.backjoon.dp.backtracking.q9252_LCS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[] a, b;
	static int[][] dp;
	static int[] dx = {-1, 0};
	static int[] dy = {0, -1};
	static int[] visited;
	static StringBuilder sb;
	
	/* 
	 * 
	 * LCS 이론참조
	 * https://velog.io/@emplam27/알고리즘-그림으로-알아보는-LCS-알고리즘-Longest-Common-Substring와-Longest-Common-Subsequence
	 * 
	 * */
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		
		dp = new int[a.length + 1][b.length + 1];//마진값 0 추가
		for(int i = 1 ; i <= a.length ; i++) {
			for(int j = 1 ; j <= b.length ;j++) {
				if(a[i - 1] != b[j - 1]) {//dp에는 마진을 줬기 때문에 -1로 데이터 확인
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}else {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		
		/*
		 * for(int[] c : dp) { for(int d : c) { System.out.print(d + " "); }
		 * System.out.println(""); }
		 */
		
		sb = new StringBuilder();
		
		System.out.println(dp[a.length][b.length]);
		visited = new int[dp[a.length][b.length] + 1];//dp 탐색시 해당 size를 탐색했을 경우 해당 탐색은 멈춤
		//dp 에 대해 탐색
		dfs(a.length, b.length);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int y, int x){
		
		if(dp[y][x] == 0)return;
		if(visited[dp[y][x]] == 1)return;
		
		boolean flag = true;
		for(int i = 0 ; i < 2; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
					
			if(dp[nextY][nextX] == dp[y][x]) {
				dfs(nextY, nextX);
				flag = false;
			}
		}
		
		if(flag) {//좌상 모두 dp값이 다른경우 -> LCS 값으로 넣고 역대각선으로 탐색 
			sb.insert(0 , String.valueOf(a[y - 1]));//출력시 마진값 준것 빼줌
			visited[dp[y][x]] = 1;
			dfs(y - 1, x - 1);
		}
	}
}
