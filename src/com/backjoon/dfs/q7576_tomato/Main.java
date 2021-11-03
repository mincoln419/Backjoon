package com.backjoon.dfs.q7576_tomato;

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
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
			for(int j = 0 ; j < m ;j++) {
				map[i][j] = Integer.parseInt(read[j]);
			}
		}
		
		
		
		int answer = 0;
		Queue<Integer[]> que = new LinkedList<>();
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1){
					que.offer(new Integer[] {j, i, 0});
					visited[i][j] = 1;
				}
			}
		}
		
		while(!que.isEmpty()) {
			Integer[] poll = que.poll().clone();
			for(int t = 0 ; t < 4 ; t++) {
				int nextX = poll[0] + dx[t];
				int nextY = poll[1] + dy[t];
				if(nextX < 0 || nextX >= m)continue;
				if(nextY < 0 || nextY >= n)continue;
				if(visited[nextY][nextX] == 1)continue;
				if(map[nextY][nextX] == 0) {
					visited[nextY][nextX] = 1;
					answer = Math.max(answer, poll[2] + 1);
					que.offer(new Integer[] {nextX, nextY, poll[2] + 1});
				}
			}
		}
		
		
		boolean chk = true;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
				if(map[i][j] != -1 && visited[i][j] == 0) {
					chk = false;
					break;
				}
			}
			if(!chk)break;
		}
		if(chk)System.out.println(answer);
		else System.out.println("-1");
		
	}

}
