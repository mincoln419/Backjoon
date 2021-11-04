package com.backjoon.dijkstra.q9370_unchcked_destin;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer[]>[] list;
	static long INF = Long.MAX_VALUE;

	// 미확인목적지
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int k = 0 ; k < T ; k++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			list = new List[n + 1];
			for(int j = 1 ; j <= n ; j ++) {
				list[j] = new ArrayList<>();
			}
			for(int j = 0 ; j < m ; j++) {
				String[] read = bf.readLine().split(" ");
				int a = Integer.parseInt(read[0]);
				int b = Integer.parseInt(read[1]);
				int w = Integer.parseInt(read[2]);
				list[a].add(new Integer[] {b, w});
				list[b].add(new Integer[] {a, w});//양방향 간선
			}
			
			int[] target = new int[t];
			for(int j = 0 ; j < t ; j++) {
				 target[j] = Integer.parseInt(bf.readLine()); 
			}
			Arrays.sort(target);
			dijkstra(n, s, target, g, h);
		}		
	}
	
	static void dijkstra(int n, int from, int[] target, int g, int h) {

		int[] visited = new int[n + 1];
		long[] dist = new long[n + 1];
		Arrays.fill(dist, INF);
		dist[from] = 0;
		
		
		Set<String>[] routes = new Set[n + 1];//최단 길이 경로를 담는 리스트
		for(int i= 0 ; i < routes.length; i++) {
			routes[i] = new HashSet<>(); 
		}
		
		Queue<Long[]> que = new PriorityQueue<>((o1, o2) -> o1[1].compareTo(o2[1]));
		que.offer(new Long[] {(long)from, 0L});
		
		while(!que.isEmpty()) {
			
			Long[] poll = que.poll().clone();
			
			int now = poll[0].intValue();
			long nowd = poll[1];
			
			if(visited[now] == 1)continue;
			visited[now] = 1;
			
			for(int i = 0; i < list[now].size(); i++) {
				
				int next = list[now].get(i)[0];
				int nextd = list[now].get(i)[1];
				
				if(dist[next] == INF) {
					if(now == from) {
						routes[next].add(from + "," + next);
					}else {
						routes[next].addAll(routes[now]);
						routes[next].add(now + "," + next);
					}
					
					dist[next] = nowd + nextd;
					que.offer(new Long[] {(long)next, dist[next]});
				}
				else if(visited[next] == 0){
					if(dist[next] > nowd + nextd) {
						dist[next] = nowd + nextd;
						routes[next].clear();
						routes[next].addAll(routes[now]);
						routes[next].add(now + "," + next);
						que.offer(new Long[] {(long)next, dist[next]});
					}else if(dist[next] == nowd + nextd) {//길이가 같은.. 다른 경로가 있을 수 있으므로 추가해준다
						routes[next].addAll(routes[now]);//단, 길이 갱신을 굳이 안해도 된다.
						routes[next].add(now + "," + next);
					}
				}
			}
		}
				
		for(int i = 0 ; i < target.length; i++) {

			for(int j = 0 ; j < routes[target[i]].size(); j++) {
				if(routes[target[i]].contains(g + "," + h) || routes[target[i]].contains(h + "," + g)) {
					System.out.print(target[i] + " ");
					break;
				}  
			}
		}
		System.out.println("");
	}	
}
