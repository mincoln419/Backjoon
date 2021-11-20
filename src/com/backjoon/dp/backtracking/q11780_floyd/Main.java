package com.backjoon.dp.backtracking.q11780_floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	
	static final Long INF = Long.MAX_VALUE/2; // -> 두 거리 합산값이 long 값을 오버플로우 하므로 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/*
		 * 하나의 도시에서 다른 도시로 가는 경우 최단거리 -> dijkstra
		 * 모든 도시끼리의 최단거리 쌍 구하기 -> floyd warshal"
		 *  
		 * */
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] before = new int[n + 1][n + 1]; //route 백트래킹을 위한 메모화
		int[][] map = new int[n + 1][n + 1];
		long[][] dist = new long[n + 1][n + 1]; // i -> j 의 최단거리 메모화
		
		for(int i = 0 ; i < n + 1 ; i++) {
			Arrays.fill(dist[i], INF);
			Arrays.fill(before[i], -1);
			dist[i][i] = 0;
		}
		
		for(int i = 0 ; i < m ; i ++) {
			
			String[] read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			int w = Integer.parseInt(read[2]);
			
			if(w < dist[a][b]) {//동일한 루트가 있을 경우에는 최소값만 갱신하기 위함
				dist[a][b] = w;
				before[a][b] = a;
			}
		}
		
		
		
		//floyd-warshal - 각 도시간 최단거리 값을 메모화에 기록
		for(int i = 1 ; i <= n ; i ++) {
			for(int j = 1 ; j <= n ; j++) {
				for(int k = 1 ; k <= n ; k++) {
					if(i != j && j !=k && dist[j][k] > dist[i][k] + dist[j][i]) { // 최단거리 갱신
						dist[j][k] = dist[i][k] + dist[j][i];
						before[j][k] = before[i][k]; //백트레킹 갱신
					}
				}
			}
		}
		
		//dist 기준으로 각 도시간 최단거리를 구한다
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ;j++) {
				if(dist[i][j] == INF) {
					dist[i][j] = 0;//여기서 기록이 안된 경우 거리 0으로 통일
					bw.write("0 ");
				}
				else bw.write(dist[i][j] + " ");
			}
			bw.write("\n");
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ;j++) {
				if(dist[i][j] == 0) {
					bw.write("0\n");
					continue;
				}else {
					int s = i;//시작점
					int e = j;//종료지점
					//백트레킹
					Stack<Integer> st = new Stack<>();
					while(true) {
						st.add(e);
						e = before[s][e];
						if(e == -1) {
							break;
						}
					}
					
					bw.write(st.size() + " ");
					
					while(!st.isEmpty()) {
						bw.write(st.pop() + " ");
					}
					bw.write("\n");
				}
				
			}
			//bw.write("\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
