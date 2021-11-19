package com.backjoon.dp.backtracking.q11779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Node{
	
	int next;
	int w;
	
	int value;

	//인접리스트 위한 생성자
	public Node(int next, int w) {
		this.next = next;
		this.w = w;
	}
	
	//트리구조 탐색을 위한 생성자
	public Node(int value) {
		this.value = value;
	}
}

public class Main {

	static List<Node>[] list;
	static int n, m, s, e;
	private static final long INF = 1000000001;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		
		//인접리스트 초기화
		list = new List[n + 1];
		for(int i = 0 ; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i ++) {
			String[] read = br.readLine().split(" ");
			
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			int w = Integer.parseInt(read[2]);
			
			list[a].add(new Node(b, w));
		}
		//시작점 종료지점
		String[] read = br.readLine().split(" "); 
		s = Integer.parseInt(read[0]);
		e = Integer.parseInt(read[1]);
		
		dijkstra();
		
		br.close();
	}

	private static void dijkstra() {
		
		long[] dist = new long[n + 1];
		int[] visited = new int[n + 1];
		int[] before = new int[n + 1];
		//최단거리를 트리탐색하기 위한 루트
		Arrays.fill(dist, INF);
		dist[s] = 0;
		before[s] = 0;

		for(int i = 1 ; i <= n ; i++) {
			int now = s;
			long nowd = INF;
			for(int j = 1 ; j <= n ; j++ ) {
				if(dist[j] < nowd && visited[j] == 0) {
					now = j;
					nowd = dist[j];
				}
			}
			if(nowd == INF) break;
			visited[now] = 1;
			
			for(int j = 0 ; j < list[now].size(); j++) {
				int next = list[now].get(j).next;
				int nextd = list[now].get(j).w;
				
				if(nowd + nextd < dist[next]) {
					dist[next] = nowd + nextd;
					before[next] = now;
				}  
			}
			if(now == e) break;
		}
		
		System.out.println(dist[e]);
		
		//before 배열을 기준으로 백트레킹
		int tmp = e;
		Stack<Integer> st = new Stack<>();
		while(true) {
			st.add(tmp);
			if(tmp == s)break;
			tmp = before[tmp];
		}
		System.out.println(st.size());
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
}

