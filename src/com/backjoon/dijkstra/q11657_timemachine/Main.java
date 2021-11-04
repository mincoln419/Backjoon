package com.backjoon.dijkstra.q11657_timemachine;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer[]>[] list;
	static Long[] dist;
	static Long INF = Long.MAX_VALUE;
	static int n, m;

	// Bellman-Ford - 최단거리 구할때 음수가 포함될 경우.. -> cycle 여부를 판단하는 로직 추가
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new Long[n + 1];
		list = new List[n + 1];

		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
		}
		// 인접리스트
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[a].add(new Integer[] {b, w, i});
		}

		bellmanford(1);
	}

	static void bellmanford(int num) {

		dist[num] = 0L;
		boolean update = false;
		for(int i = 0 ; i <= n ; i++) {
			
			update = false;
			
			for(int j = 1 ; j <= n ; j++) {
				for(int k = 0 ; k < list[j].size() ; k++) {
					int next = list[j].get(k)[0];
					long nextd = list[j].get(k)[1];
					if(dist[j].compareTo(INF) == 0)break;
					
					if(dist[next] > dist[j] + nextd) {
						dist[next] = dist[j] + nextd;
						update = true;
					}
				}
			}
			
			if(!update) break;
		}
		
		if(update) {
			for(int j = 1 ; j <= n ; j++) {
				for(int k = 0 ; k < list[j].size() ; k++) {
					int next = list[j].get(k)[0];
					long nextd = list[j].get(k)[1];
					if(dist[j].compareTo(INF) == 0)break;
					
					if(dist[next] > dist[j] + nextd) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		for(int i = 2 ; i < dist.length; i++) {
			if(dist[i] == INF)System.out.println("-1");
			else System.out.println(dist[i]);
		}
		
	}
}
