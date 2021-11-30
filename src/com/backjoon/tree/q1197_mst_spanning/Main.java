package com.backjoon.tree.q1197_mst_spanning;

import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int a, b, w;
		
		public Edge(int a, int b, int w) {//방향성이 없기 때문에 a - b 상관없음
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
	
	static int v, e;
	static int[] root;
	
	/*
	 * 최소 스패닝 트리 : 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = br.readLine().split(" ");
		v = Integer.parseInt(read[0]);
		e = Integer.parseInt(read[1]);

		//특정구간 최소신장을 구하려면 dijkstra, 모든 구간 사이의 최단 가중치를 구하려면 floyd warshall.. 
		//스패닝 트리 문제의 경우에는 크루스칼(kruskal) 알고리즘 
		/* 
		 * 1. 각 간선을 리스트넣고, 
		 * 2. w 값이 최소값으로 정렬 연결시켜가며
		 * 3. union find 로 전체 연결상태가 되는 경우를 찾는다.
		 */
		root = new int[v + 1];
		Arrays.fill(root, -1);
		List<Edge> list = new ArrayList<>();
		for(int i = 0 ; i < e ; i++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			int w = Integer.parseInt(read[2]);
			
			list.add(new Edge(a, b, w));
		}
		
		Collections.sort(list);
		int answer = 0;
		for(int i = 0 ; i < list.size(); i++) {
			int a = list.get(i).a;
			int b = list.get(i).b;
			if(getRoot(a) != getRoot(b)) {
				connect(a, b);
				answer += list.get(i).w;
			}
			
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.flush();
		bw.close();
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
