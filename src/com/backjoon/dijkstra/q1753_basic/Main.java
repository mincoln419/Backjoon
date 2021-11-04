package com.backjoon.dijkstra.q1753_basic;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer[]>[] list;
	static long[] dist;
	static long INF = Long.MAX_VALUE;
	static int v, e, k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(bf.readLine());// 시작정점

		list = new List[v + 1];
		dist = new long[v + 1];
		Arrays.fill(dist, INF);
		dist[k] = 0;

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Integer[] { b, w });
		}

		dijkstra(k);

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	static void dijkstra(int from) {
		PriorityQueue<Long[]> que = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
		
		que.offer(new Long[] {(long)from, 0L});
		int[] visited = new int[v + 1];
		while(!que.isEmpty()) {
			
			Long[] poll = que.poll().clone();
			int now = poll[0].intValue();
			Long nowd = poll[1];
			
			if(visited[now] == 1)continue;
			visited[now] = 1;
			for(int i = 0 ; i < list[now].size();i++) {
				Integer next = list[now].get(i)[0];
				long nextd = list[now].get(i)[1];
				if(dist[next] == INF) {
					dist[next] = dist[now] + nextd;
					que.offer(new Long[] {next.longValue(), dist[next]});
				} 
				else {
					dist[next] = Math.min(dist[next], (long)(dist[now] + nextd));
					que.offer(new Long[] {next.longValue(), dist[next]});
				}
			}
		}
	}
}
