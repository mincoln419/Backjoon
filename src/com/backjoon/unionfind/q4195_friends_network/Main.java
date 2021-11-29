package com.backjoon.unionfind.q4195_friends_network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	private static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());// 테스트케이스 갯수

		for (int t = 0; t < T; t++) {
			int f = Integer.parseInt(br.readLine());
			root = new int[1000001];
			Arrays.fill(root, -1);
			
			Map<String, Integer> map = new HashMap<>();
			int idx = 1;
			for (int i = 0; i < f; i++) {
				String[] edge = br.readLine().split(" ");

				// 친구이름으로 인덱스 매핑
				if (!map.containsKey(edge[0])) {
					map.put(edge[0], idx);
					idx++;
				}

				if (!map.containsKey(edge[1])) {
					map.put(edge[1], idx);
					idx++;
				}

				int a = map.get(edge[0]);
				int b = map.get(edge[1]);
				//System.out.println(a + " ," + b);
				unionInsert(a, b);
				bw.write(-root[getRoot(a)]+"\n");
			}

		}

		br.close();
		bw.flush();
		bw.close();

	}

	private static void unionInsert(int a, int b) {
		a = getRoot(a);
		b = getRoot(b);
		
		if(a == b)return;
		if(a > b) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		
		root[a] = root[a] + root[b]; 
		root[b] = a;
		
	}

	private static int getRoot(int a) {
		if(root[a] < 0)return a;
		
		return root[a] = getRoot(root[a]);
	}
}
