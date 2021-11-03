package com.backjoon.dfs.q1697_hiding;

import java.io.*;
import java.util.*;

public class Main {

	static int[] visited;
	static int[] loc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		Queue<Integer[]> que = new LinkedList<>();
		visited = new int[100001];
		loc = new int[100001];
		visited[s] = 1;
		que.offer(new Integer[] {s, 0});
		int answer = 0;
		while(!que.isEmpty()) {
			Integer[] poll = que.poll().clone();
			//3가지 방식으로 이동했을 경우 도달하는 시간
			//1칸전진
			if(poll[0] + 1 <= 100000 && visited[poll[0] + 1] == 0) {
				visited[poll[0] + 1] = 1;
				if(poll[0] + 1 == e) {
					answer = poll[1] + 1;
					break;
				}
				que.offer(new Integer[] {poll[0]+ 1, poll[1] + 1});
			}
			//1칸후진
			if(poll[0] - 1 >= 0 && visited[poll[0] - 1] == 0 ) {
				visited[poll[0] - 1] = 1;
				if(poll[0] - 1 == e) {
					answer = poll[1] + 1;
					break;
				}
				que.offer(new Integer[] {poll[0]- 1, poll[1] + 1});
			}
			//순간이동
			//1칸후진
			if(poll[0] * 2 <= 100000 && visited[poll[0] * 2] == 0) {
				visited[poll[0] * 2] = 1;
				if(poll[0] * 2 == e) {
					answer = poll[1] + 1;
					break;
				}
				que.offer(new Integer[] {poll[0] * 2, poll[1] + 1});
			}
		}
		
		System.out.println(answer);
		bf.close();
	}
}
