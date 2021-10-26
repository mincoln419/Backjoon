package com.backjoon.dp.q13305;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		String[] read = bf.readLine().split(" ");
		long[] dist = new long[n];//n-1개이 이지만 1번째부터 의미가있으므로
		for(int i = 1 ; i < n; i++) {
			dist[i] = Long.parseLong(read[i - 1]);
		}
		read = bf.readLine().split(" ");
		long[] cost = new long[n];
		for(int i = 0 ; i < n- 1; i++) {
			cost[i] = Long.parseLong(read[i]);
		}
		
		long min = cost[0];//최저비용은 시작지점으로 하고..
		long sum = 0L;//비용의 합계
		for(int i = 1 ; i < n ; i++) {
			sum += min * dist[i];//이전에 구한 비용으로 일단 계산후
			min = Math.min(min, cost[i]);//현재까지의 최저비용으로 갱신
		}
		
		System.out.println(sum);
	}
}
