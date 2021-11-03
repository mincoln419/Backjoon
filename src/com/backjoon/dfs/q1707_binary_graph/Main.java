package com.backjoon.dfs.q1707_binary_graph;

import java.io.*;
import java.util.*;

public class Main {

	//Bipartite 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < k ; i++) {
			String[] read = bf.readLine().split(" ");
			int v = Integer.parseInt(read[0]);//정점개수
			int e = Integer.parseInt(read[1]);//간선개수
			
			List<Integer>[] list = new List[v + 1];
			for(int j = 1 ; j <= v; j++) {
				list[j] = new ArrayList<>();
			}
			int[][] arr = new int[e][2];
			for(int j = 0 ; j < e; j++) {
				read = bf.readLine().split(" ");
				int a = Integer.parseInt(read[0]);
				int b = Integer.parseInt(read[1]);
				arr[j][0] = a;
				arr[j][1] = b;
				list[a].add(b);
				list[b].add(a);
			}
			//dfs로 연결되었는지 탐색
			//정점의 수만큼 visited를 만듬
			int[] visited = new int[v + 1];
			
			boolean chk = true;
			
			for(int j = 1 ; j < visited.length ; j++) {
				if(visited[j] == 0) {
					visited[j] = 1;
					chk = dfs(visited, list, j);
					if(!chk)break;
				}
			}
			
			if(chk) System.out.println("YES");
			else System.out.println("NO");
		}
		bf.close();
	}
	
	static boolean dfs(int[] visited, List<Integer>[] list , int num) {
		
		boolean result = true;
		for(int i = 0 ; i < list[num].size(); i++) {
			int e = list[num].get(i);
			if(visited[e] == 0) {
				if(visited[num] == 1) {
					visited[e] = 2;
				}else {
					visited[e] = 1;
				}
				result = dfs(visited, list, e);
			}else {
				if(visited[num] == visited[e]) return false;
			}
		}
		return result;
	}
}
