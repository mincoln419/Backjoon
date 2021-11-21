package com.backjoon.tree.q2263_tree_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식) 중위 순회한 결과 : DBAECFG // (왼쪽 자식)
	 * (루트) (오른쪽 자식) 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
	 */

	static int idx;

	static int[] visited;

	static int[] mid, post, pre;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());


		visited = new int[n + 1];

		
		mid = new int[n];
		post = new int[n];
		pre = new int[n];
		
		idx = 0;
		
		String[] read = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			mid[i] = Integer.parseInt(read[i]);
		}
		read = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(read[i]);
		}

		// root는 후위탐색의 마지막임
		int root = post[n - 1];

		visited[root] = 1;
		dfs(0, n - 1, 0, n - 1);
		
		for(int i = 0 ; i < pre.length ; i++) {
			System.out.print(pre[i] + " ");
		}


		br.close();
	}


	// root를 기준으로 중위탐색배열에서 s ~ e 범위에서의 최상위 root를 찾은 다음 재귀처리
	static void dfs(int ms, int me, int ps, int pe) {

		if(ms > me || ps > pe) return;
		
		pre[idx++] = post[pe];
		
		int root = ms;
		for(int i = ms ; i <= me ; i++) {
			if(mid[i] == post[pe]) {
				root = i;
				break;
			}
		}
		
		//left 탐색
		dfs(ms, root - 1, ps, ps + root - ms - 1);
		
		//right 탐색
		dfs(root + 1, me, ps + root - ms, pe - 1);
	}

}
