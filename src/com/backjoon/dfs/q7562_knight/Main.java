package com.backjoon.dfs.q7562_knight;

import java.io.*;
import java.util.*;

public class Main {

	static int[] visited;
	static int[] loc;
	static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
	static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());
		for(int k = 0 ; k < t ; k++) {
			int n = Integer.parseInt(bf.readLine());
			int[][] visited = new int[n][n];
			
			String read[] = bf.readLine().split(" ");
			int fx = Integer.parseInt(read[0]);
			int fy = Integer.parseInt(read[1]);
			
			read = bf.readLine().split(" ");
			int tx = Integer.parseInt(read[0]);
			int ty = Integer.parseInt(read[1]);
			
			Queue<Integer[]> que = new LinkedList<>();
			visited[fy][fx] = 1; 
			que.offer(new Integer[] {fx, fy, 0});
			
			int answer = 0;
			while(!que.isEmpty()) {
				Integer[] poll = que.poll().clone();
				
				for(int i = 0 ; i < dx.length; i++) {
					int nextX = poll[0] + dx[i];
					int nextY = poll[1] + dy[i];
					
					if(nextX < 0 || nextX >= n)continue;
					if(nextY < 0 || nextY >= n)continue;
					if(visited[nextY][nextX] == 1)continue;
					
					visited[nextY][nextX] = 1;
					if(nextX == tx && nextY == ty) {
						answer = poll[2] + 1;
						que.clear();
						break;
					}
					que.offer(new Integer[] {nextX, nextY , poll[2] + 1});
				}
			}
			System.out.println(answer);
		}
				
		bf.close();
	}

}
