package com.backjoon.dfs.q2206_breakWall;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][][] visited = new int[n][m][2];
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] read = bf.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(read[j]);
			}
		}

		Queue<Integer[]> que = new LinkedList<>();

		que.offer(new Integer[] { 0, 0, 1, 0});
		int answer = -1;
		if(m - 1 == 0 && n - 1 == 0) answer = 1;
		
		while (!que.isEmpty()) {
			Integer[] poll = que.poll().clone();
			int x = poll[0];
			int y = poll[1];
			//System.out.println("x,y:::" + x + " , " + y);
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextX < 0 || nextX >= m) continue;
				if (nextY < 0 || nextY >= n) continue;
				
				if (visited[nextY][nextX][0] == 1 && visited[nextY][nextX][1] == 1) continue;
				
				if (board[nextY][nextX] == 1 && poll[3] == 0 && visited[nextY][nextX][1] == 0) {
					visited[nextY][nextX][1] = 1;
					que.offer(new Integer[] { nextX, nextY, poll[2] + 1, 1});
					continue;
				}
				
				if(board[nextY][nextX] == 1)continue;
				
				if(poll[3] == 1) {
					if(visited[nextY][nextX][1] == 1)continue;
					visited[nextY][nextX][1] = 1;
					
				}else {
					if(visited[nextY][nextX][0] == 1)continue;
					visited[nextY][nextX][0] = 1;
				}
				
				if (nextX == m - 1 && nextY == n - 1) {
					answer = poll[2] + 1;
					que.clear();
					break;
				}
				
				que.offer(new Integer[] { nextX, nextY, poll[2] + 1 , poll[3]});
			}
		}
		
		System.out.println(answer);
		bf.close();
	}

}
