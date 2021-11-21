package com.backjoon.tree.q1991_binary_basic;

import java.util.*;
import java.io.*;

/*
 * testcase

-input

7
A B C
B D .
C E F
E . .
F . G
D . .
G . .

-output

ABDCEFG
DBAECFG
DBEGFCA
 * 
 * 
 * 
 * */

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
		//인접리스트
		list = new Node[n];
		visited = new int[26];
		
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
