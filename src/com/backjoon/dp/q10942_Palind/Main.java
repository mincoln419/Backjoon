package com.backjoon.dp.q10942_Palind;

import java.io.*;
import java.util.*;

public class Main {

	static int[] nums;
	static int[][] cache;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		
		String[] arr = bf.readLine().split(" ");
		nums = new int[n+1];
		cache = new int[n+1][n+1];
		
		for(int i = 1 ; i < n + 1 ; i++) {
			nums[i] = Integer.parseInt(arr[i-1]);
			Arrays.fill(cache[i], -1);
		}
		
		int t = Integer.parseInt(bf.readLine());
		for(int i = 0 ; i < t; i++){
			String[] read = bf.readLine().split(" ");
			int s = Integer.parseInt(read[0]);
			int e = Integer.parseInt(read[1]);
			bw.write(dp(s, e) + "\n");
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}
	
	static int dp(int s, int e) {
		
		if(cache[s][e] > - 1)return cache[s][e];
		if(s == e) return cache[s][e] = 1;
		if(nums[s] == nums[e]) {
			if(e-s == 1) cache[s][e] = 1;
			else cache[s][e] = dp(s + 1, e - 1);
		}else cache[s][e] = 0;

		return cache[s][e];
	}
}
