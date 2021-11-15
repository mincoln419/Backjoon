package com.backjoon.dijkstra.q10217;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer[]>[] list;
	static int[][] cost;//메모화할 부분
	static int INF = Integer.MAX_VALUE/2;
	static int n, m, k;

	// Bellman-Ford - 최단거리 구할때 음수가 포함될 경우.. -> cycle 여부를 판단하는 로직 추가
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int t = 0 ; t < T ; t++) {
			String[] read = bf.readLine().split(" ");
			n = Integer.parseInt(read[0]);//공항수 시작,도착점 포함
			m = Integer.parseInt(read[1]);//총자원
			k = Integer.parseInt(read[2]);//티켓정보
			list = new List[n + 1];
			cost = new int[n + 1][m + 1];
			for(int i = 0 ; i <= n ; i++) {
				list[i] = new ArrayList<>();
				Arrays.fill(cost[i], INF);
			}

			cost[1][0] = 0;
			
			//인접리스트 구성
			for(int i = 0 ; i < k ; i++) {
				read = bf.readLine().split(" ");
				int s = Integer.parseInt(read[0]);//출발공항
				int e = Integer.parseInt(read[1]);//도착공항
				int c = Integer.parseInt(read[2]);//비용
				int d = Integer.parseInt(read[3]);//소요시간
				
				list[s].add(new Integer[]{e, c, d});
			}
			dijkstra();
			Arrays.sort(cost[n]);
			if(cost[n][0] != INF) {
				System.out.println(cost[n][0]);
			}
			else System.out.println("Poor KCM");
		}
	}

	static void dijkstra() {
		
		Queue<Integer[]> que = new PriorityQueue<>((o1, o2) -> {
			if(o1[2].compareTo(o2[2]) > 0)return 1;
			else if(o1[2].compareTo(o2[2]) == 0) {
				if(o1[1].compareTo(o2[1]) > 0)return 1;
			}
			return -1;
		});//거리순으로 체킹
		
		//시작은 1에서 시작..
		que.offer(new Integer[] {1, 0, 0});
		
		while(!que.isEmpty()) {
			
			Integer[] poll = que.poll().clone();
			
			int now = poll[0].intValue();
			Integer nowc = poll[1];
			Integer nowd = poll[2];
			
			
			for(int i = 0 ; i < list[now].size(); i++) {
				int next = list[now].get(i)[0];
				int nextc = list[now].get(i)[1] + nowc;
				int nextd = list[now].get(i)[2] + nowd;
				
				if(nextc > m)continue;
				
				if(cost[next][nextc] <= nextd)continue;
				
				for(int j = nextc; j <= m ; j++) {
					if(cost[next][j] > nextd) cost[next][j] = nextd;
				}
				
				cost[next][nextc] = nextd;
				que.offer(new Integer[] {next, nextc, nextd});
			}
		}
	}
}
