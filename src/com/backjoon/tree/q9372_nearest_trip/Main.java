package com.backjoon.tree.q9372_nearest_trip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < T; t++) {
			
			String[] read = br.readLine().split(" ");
			int n = Integer.parseInt(read[0]);//국가 수
			int m = Integer.parseInt(read[1]);//비행기 종류
			
			//인접리스트를 만들고 bfs로 탐색하여 가장 먼저 전부 탐색하는 경우를 찾는다. -- 거리가 같으므로
			List<Integer>[] list = new List[n + 1];
			for(int i = 1 ; i <= n ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < m ; i++) {
				read = br.readLine().split(" ");
				int a = Integer.parseInt(read[0]);
				int b = Integer.parseInt(read[1]);
				list[a].add(b);
				list[b].add(a); // 왕복가능한 비행기
			}
			
			Queue<Integer> que = new LinkedList<>();
			boolean[] visited = new boolean[n + 1];
			visited[1] = true;
			que.add(1);
			int cnt = 0;
			while(!que.isEmpty()) {
				int poll = que.poll();
				
				for(int i = 0 ; i < list[poll].size(); i++) {
					int next = list[poll].get(i);
					if(!visited[next]) {
						visited[next] = true;
						que.offer(next);
						cnt++;
					}
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
