package com.backjoon.distribution.q6549_histogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] arr;
	static int[] tree;// 배열에 트리형태로 담음
	/* 세그먼트 트리 - 분할정복 */

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] read = bf.readLine().split(" ");
			if (read[0].equals("0"))break;

			int n = Integer.parseInt(read[0]);
			arr = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(read[i]);
			}
			tree = new int[n * 4];
			init(1, 1, n);
			for(int a : tree) {
				System.out.print(a + " ");
			}
			System.out.println("");
			
			
			bw.write(getMax(1, n, n) + "\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static void init(int node, int s, int e) {

		if (s == e) {// 리프노드 작업
			tree[node] = s;
		} else {// 상위 노드 작업
			int mid = (s + e) / 2;
			init(node * 2, s, mid);
			init(node * 2 + 1, mid + 1, e);

			// 각 구간에서 가장 높이가 낮은 값을 노드값으로 세팅
			if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2];
			} else {
				tree[node] = tree[node * 2 + 1];
			}

		}

	}

	private static long getMax(int s, int e, int n) {
		int m = query(1, n, 1, s, e);

		long area = (e - s + 1) * (long) arr[m];

		if (s <= m - 1) {
			long tmp = getMax(s, m - 1, n);
			area = Math.max(area, tmp);
		}

		if (m + 1 <= e) {
			long tmp = getMax(m + 1, e, n);
			area = Math.max(area, tmp);
		}

		return area;
	}

	
	//s - e 구간의 최소 높이 return
	private static int query(int s, int e, int node, int left, int right) {

		if (right < s || e < left) {
			return -1;
		}

		if (left <= s && e <= right) {
			return tree[node];
		}

		int mid = (s + e) / 2;
		int m1 = query(s, mid, node * 2, left, right);
		int m2 = query(mid + 1, e, node * 2 + 1, left, right);

		if (m1 == -1) return m2;
		else if (m2 == -1) return m1;
		else {
			if (arr[m1] <= arr[m2]) return m1;
			else return m2;
		}
	}

}
