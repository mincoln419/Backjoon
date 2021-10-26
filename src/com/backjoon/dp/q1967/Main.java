package com.backjoon.dp.q1967;

import java.io.*;
import java.util.*;

class Node{
	
	int child;
	int length;
	
	public Node(int child, int length) {
		this.child = child;
		this.length = length;
	}
	
}

public class Main {

	
	static List<Node>[] list;
	static int[] visited;
	//첫 탐색에서  멀리 떨어진 노드(가중치계산)
	static int x = 0;
	static int[] dist;
	static int max = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		list = new List[n + 1];//노드 인접리스트

		for(int i = 0 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < n -1  ; i++) {
			String[] read = bf.readLine().split(" ");
			int parent = Integer.parseInt(read[0]);
			int child = Integer.parseInt(read[1]);
			int length = Integer.parseInt(read[2]);
			list[parent].add(new Node(child, length));
			list[child].add(new Node(parent, length));
		}
		
		dist = new int[n + 1];//기준점부터의 누적가중치
		visited = new int[n + 1];
		dfs(1, 0);
		max = 0;
		//System.out.println(x);
		visited = new int[n + 1];
		dist = new int[n + 1];//기준점부터의 누적가중치
		dfs(x, 0);

		System.out.println(max);
	}
	
	static void dfs(int node, int length) {
		visited[node] = 1;
		//System.out.println("node::" + node);
		
		for(int i = 0 ; i < list[node].size(); i++) {
			int next = list[node].get(i).child;
			if(visited[next] == 0) {
				visited[next] = 1;
				int accumul = length + list[node].get(i).length;
				dfs(next, accumul);
				if(accumul > max) {
					max = accumul;
					x = next;
				}
			}
		}
	}
}
