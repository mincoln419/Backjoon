package com.backjoon.distribution.q1992_quardTree;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		//n*n배열로 만들고 dfs로 체크
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i ++) {
			String[] read = bf.readLine().split("");
			for(int j = 0 ; j < read.length; j++) {
				arr[i][j] = Integer.parseInt(read[j]);
			}
		}
		
		//전체값 검색
		int std = arr[0][0];
		boolean flag = true;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(std != arr[i][j]) {
					flag = false;
					break;
				}
			}
			if(!flag)break;
		}
		
		if(flag) System.out.println(std);
		else dfs(0, 0, n);

		bf.close();
		

	}
	
	static void dfs(int fx, int fy, int n) {
		
		int[] dy = {fy, fy, fy + n/2,  fy + n/2};
		int[] dx = {fx, fx + n/2, fx, fx + n/2};
		
		System.out.print("(");
		
		for(int k = 0 ; k < 4 ; k++) {
			int std = arr[dy[k]][dx[k]];
			//System.out.println(dy[k] + "," + dx[k] + "::" +std);
			boolean flag = true;
			for(int i = dy[k] ; i < dy[k] + n/2; i++) {
				for(int j = dx[k] ; j < dx[k] + n/2; j++) {
					if(std != arr[i][j]) {
						flag = false;
						break;
					}
				}
				if(!flag)break;
			}
			if(flag) {
				System.out.print(std);
			}else {
				dfs(dx[k], dy[k], n/2);
			}
		}
		System.out.print(")");
	}
}
