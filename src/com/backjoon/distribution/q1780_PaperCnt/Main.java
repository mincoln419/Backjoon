package com.backjoon.distribution.q1780_PaperCnt;

import java.io.*;

public class Main {
	
	static int[][] arr;
	static int[] cnt; 
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(bf.readLine());
		
		arr = new int[n][n];
		cnt = new int[3];//-1, 0, 1
		for(int i = 0 ; i < n ;i++) {
			
			String[] read = bf.readLine().split(" ");
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(read[j]);
			}
		}
		
		int std = arr[0][0];
		boolean flag = true;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ;j++) {
				
				if(arr[i][j] != std) {
					flag = false;
					break;
				}
			}
			if(!flag)break;
		}
		
		if(flag) {
			if(std == -1)cnt[0]++;
			else if(std == 0)cnt[1]++;
			else if(std == 1)cnt[2]++;
		}
		else {
			dfs(0, 0, n);
		}
		
		for(int i = 0 ; i < cnt.length ;i++) {
			System.out.println(cnt[i]);
		}
		bf.close();

	}
	
	static void dfs(int fx, int fy, int n) {
		
		int[] dy = {fy, fy, fy, fy + n/3, fy + n/3, fy + n/3, fy + 2 * n/3, fy + 2 * n/3, fy + 2 * n/3};
		int[] dx = {fx, fx + n/3, fx + 2 * n/3, fx, fx + n/3, fx + 2 * n/3, fx, fx + n/3, fx + 2 * n/3};
		
		
		for(int k = 0 ; k < 9; k++) {
			int std = arr[dy[k]][dx[k]];
			boolean flag = true;
			for(int i = dy[k]; i < dy[k] + n/3; i++) {
				for(int j = dx[k]; j < dx[k] + n/3; j++) {
					
					if(arr[i][j] != std) {
						flag = false;
						break;
					}
				}
				if(!flag)break;
			}
			if(flag) {
				if(std == -1)cnt[0]++;
				else if(std == 0)cnt[1]++;
				else if(std == 1)cnt[2]++;
			}else {
				dfs(dx[k], dy[k], n/3);
			}
		}
	}
}
