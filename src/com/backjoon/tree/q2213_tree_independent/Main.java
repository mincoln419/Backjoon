package com.backjoon.tree.q2213_tree_independent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] w;
	static int[][] dp;
	static int[] visited;
	static List<Integer>[] list;
	static List<Integer> answer;

	static int maxWeight;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		String[] read = br.readLine().split(" ");
		w = new int[n + 1];
		dp = new int[n + 1][2];
		visited = new int[n + 1];
		answer = new ArrayList<>();

		list = new List[n + 1];
		// 가중치 세팅
		for (int i = 0; i < n; i++) {
			w[i + 1] = Integer.parseInt(read[i]);
			list[i + 1] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		visited = new int[n + 1];
		makeTree(1);
		visited[1] = 1;
		
		if(dp[1][1] > dp[1][0]) {
			maxWeight = dp[1][1];
			trace(1, true);
		}else {
			maxWeight = dp[1][0];
			trace(1, false);
		}
		
		System.out.println(maxWeight);
		Collections.sort(answer);
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}


		br.close();
	}

	private static void trace(int node, boolean flag) {
		if(flag)answer.add(node);
		
		for(int i = 0 ; i < list[node].size() ;i++) {
			int next = list[node].get(i);
			if(visited[next] == 1) continue;
			visited[next] = 1;
			
			if(flag) {
				trace(next, false);
			}else {
				if(dp[next][1] > dp[next][0]) {
					trace(next, true);
				}else {
					trace(next, false);
				}
			}
		}
	}

	//node가 포함되는 가장 큰 독립집합
	private static void makeTree(int node) {
		
		dp[node][1] = w[node];//node가 포함되었을 경우
		dp[node][0] = 0; //node가 포함되어있지 않을 경우
		visited[node] = 1;
		
		for(int i = 0 ; i < list[node].size(); i++) {
			
			int next = list[node].get(i);
			
			if(visited[next] == 1)continue;
			makeTree(next);
			dp[node][1] += dp[next][0];
			dp[node][0] += Math.max(dp[next][1], dp[next][0]); 
		}
		visited[node] = 0;
	}

}
