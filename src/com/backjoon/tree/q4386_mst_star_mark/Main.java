package com.backjoon.tree.q4386_mst_star_mark;

import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		double x, y;
		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int a, b;
		double w;
		
		public Edge(int a, int b, double w) {//방향성이 없기 때문에 a - b 상관없음
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge obj) {
			if(this.w > obj.w) return 1;
			return -1;
		}
	}
	
	static int v;
	static int[] root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		v = Integer.parseInt(br.readLine());

		root = new int[v];
		Arrays.fill(root, -1);
		List<Node> nlist = new ArrayList<>();
		List<Edge> elist = new ArrayList<>();
		
		for(int i = 0 ; i < v ; i++) {
			String[] read = br.readLine().split(" ");
			double x = Double.parseDouble(read[0]);
			double y = Double.parseDouble(read[1]);
			Node node = new Node(x, y);
			nlist.add(node);	
		}
		
		//백트레킹을 통해 모든 노드의 간선을 구한다
		for(int i = 0 ; i < v; i++) {
			Node a = nlist.get(i);
			for(int j = i + 1 ; j < v ; j++){
				Node b = nlist.get(j);
				double dist = getDist(a, b);
				//System.out.println(a.x + " , " + a.y +"-" + b.x + " , " + b.y +" :: "+ dist);
				elist.add(new Edge(i, j, dist));
			}
		}

		Collections.sort(elist);
		double answer = 0;
		for(int i = 0 ; i < elist.size(); i++) {
			int a = elist.get(i).a;
			int b = elist.get(i).b;
			if(getRoot(a) != getRoot(b)) {
				connect(a, b);
				answer += elist.get(i).w;
			}
			
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static double getDist(Node a, Node b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

	private static void connect(int a, int b) {
		a = getRoot(a);
		b = getRoot(b);
		
		if(a > b) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		root[a] = root[a] + root[b];
		root[b] = a;
		
	}

	private static int getRoot(int a) {
		
		if(root[a] < 0)return a;
		return root[a] = getRoot(root[a]);
	}
}
