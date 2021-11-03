package com.backjoon.dfs.q7569_tomato_3D;

import java.io.*;
import java.util.*;

public class Main {

	static int[][][] visited;
	static int[][][] map;
	static int[] dx = { 1, -1, 0, 0, 0, 0};
	static int[] dy = { 0, 0, 1, -1, 0, 0};
	static int[] dz = { 0, 0, 0,  0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		map = new int[h][n][m];
		visited = new int[h][n][m];
		
		Queue<Integer[]> que = new LinkedList<>();
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < n ; j++) {
				String[] read = bf.readLine().split(" ");
				for(int k = 0 ; k < m ; k++) {
					map[i][j][k] = Integer.parseInt(read[k]);
					
					if(map[i][j][k] == 1) {
						visited[i][j][k] = 1;
						que.offer(new Integer[] {k, j, i, 0});
					}
				}
			}
		}

		int answer = 0;
		while(!que.isEmpty()) {
			Integer[] poll = que.poll().clone();
			
			for(int i = 0 ; i < 6; i++) {
				int nextX = poll[0] + dx[i];
				int nextY = poll[1] + dy[i];
				int nextZ = poll[2] + dz[i];
				
				if(nextX < 0 || nextX >= m)continue;
				if(nextY < 0 || nextY >= n)continue;
				if(nextZ < 0 || nextZ >= h)continue;
				if(visited[nextZ][nextY][nextX] == 1)continue;
				if(map[nextZ][nextY][nextX] != 0)continue;
				visited[nextZ][nextY][nextX] = 1;
				answer = Math.max(answer, poll[3] + 1);
				que.offer(new Integer[] {nextX, nextY, nextZ, poll[3]+ 1});
			}
		}
		
		boolean chk = true;
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < n ; j++) {
				for(int k = 0 ; k < m ; k++) {
					if(map[i][j][k] != -1 && visited[i][j][k] == 0)chk = false;
				}
			}
		}
		if(chk)System.out.println(answer);
		else System.out.println("-1");
		bf.close();
	}
}
