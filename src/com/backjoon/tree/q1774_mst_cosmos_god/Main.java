package com.backjoon.tree.q1774_mst_cosmos_god;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static class GodLoc{	
		int x, y;
		public GodLoc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge>{
		int a, b;
		double w;
		public Edge(int a, int b, double w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge edge) {
			
			if(this.w > edge.w)return 1;
			return -1;
		}
		
	}
	
	
	static List<Edge> list;// 크루스칼을 위해 거리로 sort할 리스트 
	static int[][] edge; // 이미 연결된 값을 체크하기 위한 배열
	static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = br.readLine().split(" ");
		int n = Integer.parseInt(read[0]);//우주신의 갯수
		int m = Integer.parseInt(read[1]);
		
		list = new ArrayList<>();
		edge = new int[n + 1][n + 1];
		root = new int[n + 1];//union find를 위한 root배열
		Arrays.fill(root, -1);
		
		GodLoc[] arr = new GodLoc[n + 1];
		//우주신 좌표세팅
		for(int i = 0 ; i < n ; i++) {
			read = br.readLine().split(" ");
			int x = Integer.parseInt(read[0]);
			int y = Integer.parseInt(read[1]);
			arr[i + 1] = new GodLoc(x, y);
		}
		
		//이미 연결된 간선 작성
		for(int i = 0 ; i < m ; i++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			edge[a][b] = 1;
			edge[b][a] = 1;
		}
		
		//각 신과 황선자 사이의 거리 세팅
		for(int i = 1 ; i <= n ; i++) {
			for(int j = i + 1 ; j <= n ; j++) {
				if(edge[i][j] == 0) {//이미 연결된 부분은 제외
					list.add(new Edge(i, j, getDist(arr[i], arr[j])));
				}else {//이미 연결된 부분은 미리 connect 처리
					connect(i, j);
				}
			}
		}
		
		Collections.sort(list);//compareTo override 한 기준으로 정렬
		
		double answer = 0.0;
		for(int i = 0 ; i < list.size() ; i++) {
			Edge e = list.get(i);
			int a = e.a;
			int b = e.b;
			if(connect(a, b)) {
				answer += e.w;
			};	
		}
		
		bw.write(String.format("%.2f", answer));
		br.close();
		bw.flush();
		bw.close();
	}

	//새로 연결된 경우만 true return
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

	//2차원 좌표에서 거리
	private static double getDist(GodLoc a, GodLoc b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

}
