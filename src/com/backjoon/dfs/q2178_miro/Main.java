package com.backjoon.dfs.q2178_miro;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] visited;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split("");
			for(int j = 0 ; j < m ; j ++) {
				map[i][j] = Integer.parseInt(read[j]);
			}
		}
		
		Queue<Integer[]> que = new LinkedList<>();
		que.offer(new Integer[] {0, 0, 1});
		visited[0][0] = 1;
		
		int answer = 0;
		while(!que.isEmpty()) {
			Integer[] poll = que.poll().clone();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = poll[0] + dx[i];
				int nextY = poll[1] + dy[i];
				if(nextX < 0 || nextX >= m)continue;
				if(nextY < 0 || nextY >= n)continue;
				if(visited[nextY][nextX] == 1)continue;
				if(map[nextY][nextX] == 0)continue;
				visited[nextY][nextX] = 1;
				if(nextY == n - 1 && nextX == m - 1) {
					answer = poll[2] + 1;
				}
				que.offer(new Integer[] {nextX, nextY, poll[2] + 1});
			}
		}
		
		System.out.println(answer);
		bf.close();
	}

}
