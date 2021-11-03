package com.backjoon.dfs.q2667_danji;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] visited;
	static int[][] map;
	static List<Integer> answer;//단지수 - size : 집의 수 - 각 value
	static int[] dx = {1, -1, 0 , 0};
	static int[] dy = {0,  0, 1 ,-1};
	static int n;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		answer = new ArrayList<>();
		
		visited = new int[n][n];//정사각형
		map = new int[n][n];//정사각형
		
		for(int i = 0 ; i < n ; i ++) {
			String[] read = bf.readLine().split("");
			
			for(int j = 0 ; j < read.length; j++) {
				map[i][j] = Integer.parseInt(read[j]);
			}
		}
		

		//dfs로 탐색
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					visited[i][j] = 1;
					answer.add(dfs(j, i, 1));
				}
			}
		}
		//오름차순정렬이므로
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for(int i = 0 ; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
		bf.close();
	}
	
	static int dfs(int x, int y, int cnt) {
		for(int i = 0 ; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextX >= n)continue;
			if(nextY < 0 || nextY >= n)continue;
			
			if(visited[nextY][nextX] == 1)continue;
			if(map[nextY][nextX] == 0)continue;
			
			visited[nextY][nextX] = 1;
			cnt = dfs(nextX, nextY, cnt + 1);
		}
		return cnt;
	}
}
