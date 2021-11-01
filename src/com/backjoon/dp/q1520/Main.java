package com.backjoon.dp.q1520;

import java.io.*;
import java.util.Arrays;

public class Main {

	static int n, m;
	static int[][] map;
	static int[][] memo;
	static int[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		String[] read = bf.readLine().split(" ");
		
		n = Integer.parseInt(read[0]);
		m = Integer.parseInt(read[1]);
		
		map = new int[n][m];
		memo = new int[n][m];
		

		
		
		visited = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String[] arr = bf.readLine().split(" ");
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}

		System.out.println(dp(0, 0));
		bf.close();
	}
	
	static int dp(int x, int y) {
		if(x == m - 1 && y == n - 1) return memo[y][x] = 1;
		if(memo[y][x] > 0)return memo[y][x];

		//¿ª¼øÀ¸·Î ÂÑ¾Æ °¡º¸Àð
		for(int i = 0 ; i < 4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX < 0 || nextX >= m)continue;
			if(nextY < 0 || nextY >= n)continue;
			if(map[nextY][nextX] >= map[y][x])continue;
			if(visited[nextY][nextX] == 1) {
				memo[y][x] += memo[nextY][nextX];
				continue;
			}
			visited[nextY][nextX] = 1;
			memo[y][x] += dp(nextX, nextY);
		}
		
		return memo[y][x];
	}
}
