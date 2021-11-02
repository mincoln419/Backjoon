package com.backjoon.dp.q7579_app;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] cache;
	static int n;
	static int[][] apps; 
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = bf.readLine().split(" ");
		n = Integer.parseInt(read[0]);
		int m = Integer.parseInt(read[1]);
		
		cache = new int[n][100001];//코스트 기준으로 메모화  
		
		read = bf.readLine().split(" ");
		String[] bytes = bf.readLine().split(" ");
		apps = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			apps[i][0] = Integer.parseInt(read[i]);
			apps[i][1] = Integer.parseInt(bytes[i]);
		}
		int answer = Integer.MAX_VALUE;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= 10000; j++) {
				if(i == 0) {
					if(j >= apps[i][1])cache[i][j] = apps[i][0];
				}else {
					if(j >= apps[i][1])cache[i][j] = Math.max(cache[i - 1][j - apps[i][1]] + apps[i][0], cache[i - 1][j]);
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
