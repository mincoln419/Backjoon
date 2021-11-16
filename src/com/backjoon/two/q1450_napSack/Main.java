package com.backjoon.two.q1450_napSack;

import java.io.*;
import java.util.*;

public class Main {

	static int INF = Integer.MAX_VALUE;
	static List<Long> left, right;
	static int n, c;
	static int[] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read = br.readLine().split(" ");

		n = Integer.parseInt(read[0]);
		c = Integer.parseInt(read[1]);

		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		left = new ArrayList<>();
		right = new ArrayList<>();
		br.close();

		//투포인트 탐색
		dfs(0, n / 2, 0, left);
		dfs(n / 2, n, 0, right);
			
		//left값을 기준으로 이분 탐색 -> right 값만 정렬하면 됨 -- upper-bound
		Collections.sort(right);
		long answer = left.size() + right.size();
		for(int i = 0 ; i < left.size(); i++) {
			int min = 0;
			int max = right.size();
			long x = c - left.get(i);
			while (min < max) {
				int mid = (min + max) / 2;	
				
				if(right.get(mid) <= x) min = mid + 1;
				else max = mid;
			}
			answer += max;
		}
		//둘다 공집합인 경우를 포함
		answer++;
		System.out.println(answer);
	}
	
	static void dfs(long bgn, long end, long sum, List<Long> v) {
		
		//이미 최대값이 초과한경우
		if(sum > c)return;
		
		//끝까지 탐색한 경우
		if(bgn == end) {
			if(sum != 0)v.add(sum);
			return;
		}
		
		//시작지점을 1 추가하여 탐색 
		//현재 값을 포함시키지 않은 경우로 재탐색
		dfs(bgn + 1, end, sum, v);
		//현재 값을 포함시키는 경우로 재탐색
		dfs(bgn + 1, end, sum + arr[(int)bgn], v);
		
	}
	
}
