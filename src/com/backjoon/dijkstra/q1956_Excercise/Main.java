package com.backjoon.dijkstra.q1956_Excercise;

import java.io.*;
import java.util.*;

public class Main {

	static List<Integer[]>[] list;
	static int v, e;
	static int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = br.readLine().split(" ");
		v = Integer.parseInt(read[0]);
		e = Integer.parseInt(read[1]);
			
		int[][] map = new int[v + 1][v + 1];
		for(int i = 0 ; i <= v ; i++) {
			Arrays.fill(map[i], INF);
			//map[i][i] = 0;
		}
		
		
		for(int i = 0; i < e ; i++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			int w = Integer.parseInt(read[2]);
			
			map[a][b] = w;
		}
		

		for(int i = 1 ; i <= v ; i++) {
			for(int j = 1 ; j <= v; j++) {
				for(int k = 1; k <= v; k++) {
					map[j][k] = Math.min(map[j][i] + map[i][k], map[j][k]);
				}
			}
		}
		
		int answer = INF;
		for(int i = 1 ; i <= v ; i++) {
			answer = Math.min(answer, map[i][i]);//사이클이 돌았을 경우
		}
		
		if(answer == INF)System.out.println(-1);
		else System.out.println(answer);
	}
}
