package com.backjoon.tree.q2533_dp_sns;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<Integer>[] list;
	static int[][] dp;
	static boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		
		list = new List[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		//인접리스트작성
		for(int i = 0 ; i < n - 1; i++) {
			String[] read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		dp = new int[n + 1][2];
		
		//dp 초기화- [i][1] 배열은 얼리아답터가 최소 한명 있다는 의미 - 만약에 거치게 되면 얼리어댑터 한명이 추가되는 것
		for(int i = 1 ; i <= n; i++) {
			dp[i][1] = 1;
		}
		visited = new boolean[n + 1];//dfs를 하기 위해 visited 선언
		
		dfs(1);
		
		bw.write(Math.min(dp[1][0], dp[1][1]) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	
	private static void dfs(int num) {
		visited[num] = true; // 자기 자신으로 돌아오는 것을 막기위한 visited세팅
		for(int i = 0 ; i < list[num].size(); i++) {
			int next = list[num].get(i);
			
			if(!visited[next]) {
				dfs(next);
				dp[num][0] += dp[next][1];
				dp[num][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
		visited[num] = false;
	}
}
