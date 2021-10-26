package com.backjoon.dp.q1991;
import java.util.*;
import java.io.*;

class Node{
	char left;
	char right;
	
	public Node(char left, char right) {
		this.left = left;
		this.right = right;
	}

	public char getLeft() {
		return left;
	}

	public char getRight() {
		return right;
	}
}

public class Main {
	
	
	static Node[] list;
	
	static int[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		//��������Ʈ
		list = new Node[n];
		visited = new int[26];
		
		
		int preRoot = 0;
		int midRoot = 0;
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			
			
			char left_child = st.nextToken().charAt(0);
			char right_child = st.nextToken().charAt(0);
			
			list[parent  - 'A'] = new Node(left_child, right_child);
			
		}
		
		preDfs('A');
		System.out.println("");
		inDfs('A');
		System.out.println("");
		postDfs('A');
		
	}

	static void preDfs(int node) {
		if(node == '.') return;
		
		System.out.print(String.valueOf((char)node));
		preDfs(list[node-'A'].getLeft());
		preDfs(list[node-'A'].getRight());
	}
	
	static void inDfs(int node) {
		if(node == '.') return;
		
		inDfs(list[node-'A'].getLeft());
		System.out.print(String.valueOf((char)node));
		inDfs(list[node-'A'].getRight());
	}
	
	static void postDfs(int node) {
		if(node == '.') return;
		
		postDfs(list[node-'A'].getLeft());
		postDfs(list[node-'A'].getRight());
		System.out.print(String.valueOf((char)node));
	}
}
