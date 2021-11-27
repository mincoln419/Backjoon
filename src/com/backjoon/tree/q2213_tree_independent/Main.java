package com.backjoon.tree.q2213_tree_independent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] node_list;
	static int[] weight;
	static int[][] memo;
	static boolean[] check;
	static List<Integer> res;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		weight = new int[n + 1];
		node_list = new ArrayList[n + 1];
		memo = new int[n + 1][2];
		check = new boolean[n + 1];
		res = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			node_list[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < n + 1; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			node_list[b].add(a);
			node_list[a].add(b);
		}

		traversal(1);

		if (memo[1][1] > memo[1][0]) {
			System.out.println(memo[1][1]);
			trace(1, 1);
		} else {
			System.out.println(memo[1][0]);
			trace(1, 0);
		}

		Collections.sort(res);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}

	static void traversal(int pos) {

		int child_num = node_list[pos].size();

		memo[pos][0] = 0; // 참석 x
		memo[pos][1] = weight[pos]; // 참석 o

		if (child_num == 0)
			return;

		check[pos] = true;

		for (int child : node_list[pos]) {
			if (!check[child]) {
				traversal(child);

				// 자식 x > 자식 o
				if (memo[child][0] > memo[child][1]) {
					memo[pos][0] += memo[child][0]; // 부모 x 자식 x

				} else { // 자식 x < 자식 o
					memo[pos][0] += memo[child][1]; // 부모 x 자식 o
				}

				memo[pos][1] += memo[child][0]; // (공통) 부모 o 자식 x
			}
		}
		check[pos] = false;
	}

	static void trace(int pos, int attend) {
		check[pos] = true;
		if (attend == 1) {
			res.add(pos);
			for (int i = 0; i < node_list[pos].size(); i++) {
				int next = node_list[pos].get(i);
				if (!check[next]) {
					trace(next, 0);
				}
			}
		} else {
			for (int i = 0; i < node_list[pos].size(); i++) {
				int next = node_list[pos].get(i);
				if (!check[next]) {
					if (memo[next][1] > memo[next][0]) {
						trace(next, 1);
					} else {
						trace(next, 0);
					}
				}
			}
		}
		check[pos] = false;

	}
}
