package com.backjoon.tree.q15681_tree_and_query;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	//인접리스트로 연결정보를 세팅한 후 dfs로 root노드를 기준으로 트리세팅..
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] dp;
	
	/*
	 * 루트 있는 트리.. 순회탐색 불가하다는 의미
	 * */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] read = br.readLine().split(" ");
        int n = Integer.parseInt(read[0]); // 노드 수
        int r = Integer.parseInt(read[1]); // 루트번호
        int q = Integer.parseInt(read[2]); // 쿼리수
        		
        list = new List[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        
        //해당 노드가 루트일 경우 하위 노드 개수
        dp = new int[n + 1];
        Arrays.fill(dp, 1);
        
        for(int i = 1 ; i <= n ; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n - 1 ; i++) {
        	read = br.readLine().split(" ");
        	int a = Integer.parseInt(read[0]);
        	int b = Integer.parseInt(read[1]);
        	list[a].add(b);
        	list[b].add(a);
        }
        visited[r] = true;
        dfs(r, 0);
        
        for(int i = 0 ; i < q; i++) {
        	int idx = Integer.parseInt(br.readLine());
        	bw.write(dp[idx] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
	}
	
	private static void dfs(int r, int cnt) {
		for(int i = 0 ; i < list[r].size() ; i++) {
			int next = list[r].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);
				dp[r] += dp[next];
			}
		}
		
	}
}
