package com.backjoon.dijkstra.q1504;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer[]>[] list;
	static long[][] dist;
	static long INF = Long.MAX_VALUE;
	static int v, e, v1, v2;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new List[v + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new long[v + 1][v + 1];
		for(int i = 1 ; i <= v ; i++) {
			Arrays.fill(dist[i], INF);
		}
		// 인접리스트 생성
		for (int i = 0; i < e; i++) {
			String[] arr = bf.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);

			list[a].add(new Integer[] { b, w });
			list[b].add(new Integer[] { a, w });
		}

		// 중간에 반드시 거쳐야 하는 정점
		String[] read = bf.readLine().split(" ");
		v1 = Integer.parseInt(read[0]);
		v2 = Integer.parseInt(read[1]);

		long answer = INF;

		long a = 0L;
		long b = 0L;
		long c = 0L;

		a = dijkstra(1, v1);
		b = dijkstra(v1, v2);
		c = dijkstra(v2, v);
		
		if (a >= 0 && b >= 0 && c >= 0) {
			answer = a + b + c;
		}
		//초기화
		a = b = c = 0L;
		
		a = dijkstra(1, v2);
		b = dijkstra(v2, v1);
		c = dijkstra(v1, v);

		if (a >= 0 && b >= 0 && c >= 0) {
			answer = Math.min(answer, a + b + c);
		}
		if (answer == INF)
			answer = -1;
		System.out.println(answer);

		bf.close();
	}

	static long dijkstra(int from, int to) {
		
		//메모화추가
		if(dist[from][to] != INF)return dist[from][to];
		dist[from][from] = 0;
		int[] visited = new int[v + 1];
		Queue<Long[]> que = new PriorityQueue<>((o1, o2) -> o1[1].compareTo(o2[1]));
		que.offer(new Long[] { (long) from, 0L });

		while (!que.isEmpty()) {
			Long[] poll = que.poll().clone();
			int now = poll[0].intValue();
			long nowd = poll[1];

			if (visited[now] == 1)
				continue;
			visited[now] = 1;

			for (int i = 0; i < list[now].size(); i++) {
				Integer next = list[now].get(i)[0].intValue();
				long nextd = list[now].get(i)[1];
				if (dist[from][next] == INF) {
					dist[from][next] = nowd + nextd;
					que.offer(new Long[] { next.longValue(), dist[from][next] });
				} else {
					dist[from][next] = Math.min(dist[from][next], nowd + nextd);
					que.offer(new Long[] { next.longValue(), dist[from][next] });
				}
			}
		}

		return dist[from][to] == INF ? -1 : dist[from][to];
	}
}
