package com.backjoon.dp.q11066_merge_file;

import java.io.*;
import java.util.Arrays;

public class Main {

	static int INF = Integer.MAX_VALUE/2;
	static int[][] cache;//시작점, 종점 별 최소비용 메모화
	static Integer[] arr;
	static int[] presum;//현재 index까지의 합꼐
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());//테스트케이스 수
		
		for(int i = 0 ; i < t ; i++) {
			
			int k = Integer.parseInt(bf.readLine());//소설을 구성하는 장의  수  k >=0
			
			String[] read = bf.readLine().split(" ");
			arr = new Integer[k];
			int pres  = 0;
			presum = new int[k+1];
			presum[0] = 0;
			for(int j = 0 ; j < read.length; j++) {
				arr[j] = Integer.parseInt(read[j]);
				pres+= arr[j];
				presum[j + 1] = pres;
			}
			cache = new int[k+1][k+1];
			
			for(int j = 0 ; j < k+ 1; j++) {
				Arrays.fill(cache[j], -1);
			}
			
			//dp
			int sum = INF;
			for(int j = 0 ; j < k; j++) {
				sum = Math.min(sum, dp(0, j) + dp(j+1, k - 1));
			}
			System.out.println(sum);		
		}
	}
	
	static int dp(int bgn, int end) {
		if(bgn == end)return arr[bgn];
		if(cache[bgn][end] > -1)return cache[bgn][end];
		
		cache[bgn][end] = INF;
		int sum = presum[end + 1] - presum[bgn]; 
		//System.out.println("sum::" + sum);
		for(int i = bgn; i < end; i++) {
			cache[bgn][end] = Math.min(cache[bgn][end], dp(bgn, i) + dp(i + 1, end) + sum);
		}
		
		return cache[bgn][end];
	}
}
