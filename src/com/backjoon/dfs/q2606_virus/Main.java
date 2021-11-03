package com.backjoon.dfs.q2606_virus;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int[] visited;
	static int answer;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		list = new List[n + 1];
		visited = new int[n + 1];
		for(int i = 0 ; i < n + 1 ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			String[] read = bf.readLine().split(" ");
			int s = Integer.parseInt(read[0]);
			int e = Integer.parseInt(read[1]);
			list[s].add(e);
			list[e].add(s);
		}
		answer = 0;
		visited[1] = 1;
		dfs(1);
		System.out.println(answer);
		bf.close();
	}
	
	static void dfs(int s) {
		
		for(int i = 0 ; i < list[s].size(); i++) {
			int e = list[s].get(i);
			
			if(visited[e] == 0) {
				visited[e] = 1;
				answer++;
				dfs(e);
			}
		}
		
	}
}
