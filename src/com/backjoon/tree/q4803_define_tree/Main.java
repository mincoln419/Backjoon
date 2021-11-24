package com.backjoon.tree.q4803_define_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static class Node {
		
		int num;
		int parent;
		List<Node> children;
		
		public Node(int num, int parent) {
			this.num = num;
			this.parent = parent;
			children = new ArrayList<>();
		}
	}
	
	static List<Integer>[] edge;
	static boolean[] visited;
	static int cnt;
	static Node root;
	static boolean circle;
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int idx = 1;
        while(true) {
        	String[] read = br.readLine().split(" ");
        	int n = Integer.parseInt(read[0]);
        	int m = Integer.parseInt(read[1]);
        	if(n == 0 && m == 0)break;
        	edge = new List[n + 1]; // 인덱스 0 부분에 마진을 주고 연결여부를 2차원 배열로 구성
        	for(int i = 1 ; i <= n  ; i++ ) {
        		edge[i] = new ArrayList<>();
        	}
        	for(int i = 0 ; i < m ; i++) {
        		read = br.readLine().split(" ");
        		int a = Integer.parseInt(read[0]);
            	int b = Integer.parseInt(read[1]);
            	edge[a].add(b);
            	edge[b].add(a);
        	}
        	visited = new boolean[n + 1];
        	Arrays.fill(visited, true);
        	cnt = 0;
        	for(int i = 1 ; i <= n ; i++) {
        		if(visited[i]) {
        			circle = false;
        			root = new Node(i, -1);
        			visited[i] = false;
        			dfs(root);
        			if(!circle)cnt++; // 순환이 아니어야 tree cnt+1
        		}
        	}
        	StringBuilder sb = new StringBuilder();
        	sb.append("Case ");
        	sb.append(idx);
        	sb.append(": ");
        	if(cnt > 1) {
        		sb.append("A forest of ");
        		sb.append(cnt);
        		sb.append(" trees.");
        	}
        	else if(cnt == 1 && !circle)sb.append("There is one tree.");
        	else sb.append("No trees.");
        	bw.write(sb.toString() + "\n");
        	idx ++;
        }
        bw.flush();
        bw.close();
        br.close();
	}
    
	private static void dfs(Node node) {
		for(int i = 0 ; i < edge[node.num].size(); i++) {
			Node next = new Node(edge[node.num].get(i), node.num);
			
			if(next.num == node.parent)continue;
			
			if(visited[next.num]) {
				visited[next.num] = false;
				node.children.add(next);
				dfs(next);
			}else{
				circle = true;
			}
		}
	}
}
