package com.backjoon.dp.q2887_planet_tunnel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static class Edge implements Comparable<Edge>{
		int a, b;
		int w;
		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = Math.abs(w);
		}
		
		@Override
		public int compareTo(Edge edge) {
			if(this.w > edge.w)return 1;
			else if(this.w == edge.w)return 0;
			else return -1;
		}
		
	}
	

	
	static List<Edge> list;// 크루스칼을 위해 거리로 sort할 리스트 
	static int[] root;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		//행성위치 배열 (x, y , z 따로 담아서 비교해야 함.. 메모리초과문제)
		int[][] x = new int[n][2];
		int[][] y = new int[n][2];
		int[][] z = new int[n][2];
		//행성간 거리(edge) list
		list = new ArrayList<>();
		//크루스칼 알고리즘의 union find를 위한 배열
		root = new int[n + 1];
		Arrays.fill(root, -1);
				
		for(int i = 0 ; i < n ; i ++) {
			String[] read = bf.readLine().split(" ");
			x[i][0] = y[i][0] = z[i][0] = i;
			x[i][1] = Integer.parseInt(read[0]);
			y[i][1] = Integer.parseInt(read[1]);
			z[i][1] = Integer.parseInt(read[2]);
		}
		
		Arrays.sort(x, (o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(y, (o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(z, (o1, o2) -> o1[1] - o2[1]);
		
		int answer = 0;
		for(int i = 0 ; i < n - 1; i++) {
			int a = x[i][0];
			int b = x[i + 1][0];
			list.add(new Edge(a, b, x[i + 1][1] - x[i][1]));
			a = y[i][0];
			b = y[i + 1][0];
			list.add(new Edge(a, b, y[i + 1][1] - y[i][1]));
			a = z[i][0];
			b = z[i + 1][0];
			list.add(new Edge(a, b, z[i + 1][1] - z[i][1]));
		}
		
		Collections.sort(list);
		
		for(int i = 0 ; i < list.size() ; i++) {
			Edge e = list.get(i);
			int a = e.a;
			int b = e.b;
			if(connect(a, b)) {
				answer += e.w;
			}
		}
		
		bw.write(answer + "\n");
		
		bw.flush();
		bf.close();
		bw.close();
	}

	private static boolean connect(int a, int b) {
		a = getRoot(a);
		b = getRoot(b);
		
		if(a == b) return false;
		if(a > b) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		root[a] += root[b];
		root[b] = a;
		return true;
	}

	private static int getRoot(int a) {
		if(root[a] < 0)return a;
		return root[a] = getRoot(root[a]);
	}

}
