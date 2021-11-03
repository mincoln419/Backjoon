package com.backjoon.dfs.q1012_vegitable;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] visited;
	static int[][] map;
	static List<Integer> answer;// 단지수 - size : 집의 수 - 각 value
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m, k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bf.readLine());
		for (int ti = 0; ti < t; ti++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n+1][m+1];// 배추밭
			visited = new int[n+1][m+1];

			for (int i = 0; i < k; i++) {
				String[] read = bf.readLine().split(" ");
				int x = Integer.parseInt(read[0]);
				int y = Integer.parseInt(read[1]);
				map[y][x] = 1;
			}
			answer = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j] == 0 && map[i][j] == 1) {
						visited[i][j] = 1;
						answer.add(dfs(j, i, 1));
					}
				}
			}
			System.out.println(answer.size());
		}
		bf.close();
	}

	static int dfs(int x, int y, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextX >= m)
				continue;
			if (nextY < 0 || nextY >= n)
				continue;
			if (visited[nextY][nextX] == 1)
				continue;
			if (map[nextY][nextX] == 0)
				continue;
			visited[nextY][nextX] = 1;

			cnt = dfs(nextX, nextY, cnt + 1);
		}

		return cnt;
	}

}
