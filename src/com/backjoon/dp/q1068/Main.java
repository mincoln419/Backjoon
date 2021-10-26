package com.backjoon.dp.q1068;

import java.io.*;
import java.util.*;

class Node{
	
	int child;
	
	public Node(int child) {
		this.child = child;
	}
}


public class Main {

	static List<Node>[] list;
	static int[] visited;
	static int k;
	static List<Integer> answer;
	static int root;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		list = new List[n];
		for(int i = 0 ; i < n ;i++) {
			list[i] = new ArrayList<>();
		}
		visited = new int[n];
		answer = new ArrayList<>();
		root = -1;
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0)root = i;
			else list[num].add(new Node(i));
		}
		k = Integer.parseInt(bf.readLine());
		
		if(k == root)System.out.println(0);
		else {
			dfs(root);
			System.out.println(answer.size());
		}
	}
	
	static void dfs(int node) {
		visited[node] = 1;
		boolean chk = true;
		for(int i = 0 ; i < list[node].size();i++) {
			int next = list[node].get(i).child;
			if(next == k)continue;
			if(visited[next] == 0) {
				chk = false;
				visited[next] = 1;
				dfs(next);
			}
		}
		if(chk) {
			//System.out.println("reaf::" + node);
			answer.add(node);
		}
	}
}
