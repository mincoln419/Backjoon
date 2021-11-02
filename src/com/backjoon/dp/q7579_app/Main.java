package com.backjoon.dp.q7579_app;

import java.io.*;

public class Main {

	static int[][] cache;
	static int n; 
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = bf.readLine().split(" ");
		n = Integer.parseInt(read[0]);
		int m = Integer.parseInt(read[1]);
		
		cache = new int[n][100001];//코스트 기준으로 메모화  
		
		read = bf.readLine().split(" ");
		String[] bytes = bf.readLine().split(" ");
		int[] mem = new int[n];
		int[] cost = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			mem[i] = Integer.parseInt(read[i]);
			cost[i] = Integer.parseInt(bytes[i]);
		}
		int answer = Integer.MAX_VALUE;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= 10000; j++) {
				if(i == 0) {
					if(j >= cost[i])cache[i][j] = mem[i];
				}else {
					if(j >= cost[i])cache[i][j] = Math.max(cache[i - 1][j - cost[i]] + mem[i], cache[i - 1][j]);
					else cache[i][j] = cache[i - 1][j];
				}
				
				if(cache[i][j] >= m)answer = Math.min(answer, j);
			}
		}
		bw.write(answer + "\n");
		bw.flush();
		bf.close();
		bw.close();
		
	}
}
