package com.backjoon.dfs.q1260;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int[] visited;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());//정점개수
		int m = Integer.parseInt(st.nextToken());//간선개수
		int v = Integer.parseInt(st.nextToken());//시작점
		
		list = new List[n + 1];
		visited = new int[n + 1];
		for(int i = 0 ; i < n + 1 ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			String[] read = bf.readLine().split(" ");
			int s = Integer.parseInt(read[0]);
			int e = Integer.parseInt(read[1]);
			
			//양방향 간선이므로 - 인접리스트 등록
			list[s].add(e);
			list[e].add(s);
		}
		//작은수 먼저 방문하므로 배열정리
		for(int i = 0 ; i < n + 1 ; i++) {
			Collections.sort(list[i]);
		}
		
		System.out.print(v +" ");
		visited[v] = 1;
		dfs(v);

		System.out.println("");
		//BFS
		Queue<Integer> que = new LinkedList<>();
		visited = new int[n + 1];
		visited[v] = 1;
		System.out.print(v + " ");
		que.offer(v);
		while(!que.isEmpty()) {
			int poll = que.poll();
			
			for(int i = 0 ; i < list[poll].size(); i++) {
				int e = list[poll].get(i);
				if(visited[e] == 0) {
					visited[e] = 1;
					System.out.print(e + " ");
					que.offer(e);
				}
			}
		}
		
		bf.close();
		bw.close();
	}
	
	static void dfs(int num) {
		
		for(int i = 0 ; i < list[num].size();i++) {
			int e = list[num].get(i);
			if(visited[e] == 0) {
				visited[e] = 1;
				System.out.print(e + " ");
				dfs(e);
			} 
		}
	}
}
