package com.backjoon.segment.q2042_segment_part_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static long[] arr;
	static long[] tree;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = br.readLine().split(" ");
		n = Integer.parseInt(read[0]);
		int m = Integer.parseInt(read[1]);
		int k = Integer.parseInt(read[2]);
		
		arr = new long[n + 1];
		tree = new long[n * 4];//세그먼트 트리
		
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		segTree(1, 1, n);
		
		for(int i = 0 ; i < tree.length; i++)System.out.print(tree[i] +" ");
		
		int mcnt = m;
		int kcnt = k;
		for(int i = 0 ; i < m + k; i++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			long c = Long.parseLong(read[2]);
			if(a == 1 && mcnt > 0) {// 데이터 변경
				long cha = c - arr[b]; 
				arr[b] = c; //※ 만약에 b값을 또 변경하는 경우 cha를 구하는 식에서 arr 가 다시 사용되므로 갱신 필요!
				treeUpdate(1, 1, n, b, cha);
				mcnt--;
			}else if(a == 2 && kcnt > 0) {
				bw.write(getSum(1, 1, n, b, (int)c)+ "\n");
				kcnt--;
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static long getSum(int node, int start, int end, int left, int right) {

		if(left > end || right < start)return 0;
		
		if(start >= left && end <= right)return tree[node]; // 정확하게 트리에서 주어질 경우도 있지만 범위내의 트리 값을 서로 더할 경우도 있음
		
		long leftsum = getSum(node * 2, start, (start + end)/2, left, right);
		long rightsum = getSum(node * 2 + 1, (start + end)/2 + 1, end, left, right);
		
		return leftsum + rightsum; 
	}

	private static void treeUpdate(int node, int start, int end, int idx, long cha) {
		if(idx < start || idx > end) return;
		
		tree[node] += cha;
		
		if(start != end) {//리프노드가 아니면
			treeUpdate(node * 2, start, (start + end)/2, idx, cha); //왼쪽
			treeUpdate(node * 2 + 1, (start + end)/2 + 1, end, idx, cha); //오른쪽
		}
		
	}

	private static long segTree(int node, int start, int end) {

		if(start == end) {//리프노드일때
			return tree[node] = arr[start];
		}else {
			return tree[node] = segTree(node * 2, start, (start + end)/2) + segTree(node * 2 + 1, (start + end)/2 + 1, end);
		}
	}

}
