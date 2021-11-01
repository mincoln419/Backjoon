package com.backjoon.dp.q2629;

import java.io.*;

public class Main {
	static int n;
	static int[] weight;
	static int[] visited;
	static int sum;
	static String[][] cache;
	static String[] answer;
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(bf.readLine());
		
		weight = new int[n + 1]; 
		String[] read = bf.readLine().split(" ");
		sum = 0;
		weight[0] = 0;
		for(int i = 1 ; i <= n; i ++) {
			weight[i] = Integer.parseInt(read[i-1]);
			sum += weight[i];
		}
		cache = new String[n + 1][sum + 1];
		answer = new String[sum + 1];
		for(int i = 0 ; i <= n ; i++) {
			visited = new int[n + 1];
			visited[i] = 1;
			dp(i, 0);
		}
		
		
		int m = Integer.parseInt(bf.readLine());
		read = bf.readLine().split(" ");
		for(int i = 0 ; i < m ; i++) {
			int num = Integer.parseInt(read[i]);
			if(num > sum)bw.write("N");
			else {
				if(answer[num] != null)bw.write("Y");
				else bw.write("N");
			} 
			
			if(i < m - 1)bw.write(" ");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
	
	static void dp(int num, int w) {
		
		for(int i = 0 ; i <= n; i++) {
			if(visited[i] == 1)continue;
			for(int j = 0 ; j < 2; j++) {//+일 경우, - 일경우로 백트레킹
				visited[i] = 1;
				int add = 0;
				if(j == 0)add = weight[i];
				else add = -weight[i];
				if(cache[num][Math.abs(w + add)] == null) {
					cache[num][Math.abs(w + add)] = "Y";
					answer[Math.abs(w + add)] = "Y";
					dp(num, Math.abs(w + add));
				}
				visited[i] = 0;
			}
		}
	}
}
