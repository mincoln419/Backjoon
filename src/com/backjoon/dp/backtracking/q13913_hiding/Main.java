package com.backjoon.dp.backtracking.q13913_hiding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int MAX = 100000;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = br.readLine().split(" ");
		
		int n = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);
		br.close();
		
		int[] dp = new int[MAX + 1];
		Arrays.fill(dp, MAX);//최대값으로 세팅
		
		if(n > k) {//시작점이 더 클경우는 무조건 1씩 감소해서 접근하는 방법밖에 없음
			
			System.out.println(n - k);
			for(int i = n ; i >= k ;i--) {
				bw.write(i + " ");
			}
			bw.flush();
			bw.close();
			return;
		}else if(n == k) {
			System.out.println(0);
			System.out.println(n);
			bw.close();
			return;
		}
		
		Queue<Stack<Integer>> que = new LinkedList<>();
		Stack<Integer> st = new Stack<>();
		st.add(n);
		que.add(st);
		while(!que.isEmpty()) {
			Stack<Integer> now = que.poll();
			
			//순간이동 했을 경우
			int next = now.peek() * 2;
			if(next <= MAX) {
				
				if(next == k) {
					now.add(next);
					returnAnswer(now);
					bw.close();
					return;
				}
				
				if(now.size() < dp[next]) {
					dp[next] = now.size();
					Stack<Integer> copy = new Stack<>();
					copy.addAll(now);
					copy.add(next);
					que.offer(copy);
				} 
			}
			next = now.peek() + 1;
			if(next <= MAX) {
				if(next == k) {
					now.add(next);
					returnAnswer(now);
					bw.close();
					return;
				}
				
				if(now.size() < dp[next]) {
					dp[next] = now.size();
					Stack<Integer> copy = new Stack<>();
					copy.addAll(now);
					copy.add(next);
					que.offer(copy);
				} 
			}
			next = now.peek() - 1;
			if(next >= 0) {
				if(next == k) {
					now.add(next);
					returnAnswer(now);
					bw.close();
					return;
				}
				
				if(now.size() < dp[next]) {
					dp[next] = now.size();
					Stack<Integer> copy = new Stack<>();
					copy.addAll(now);
					copy.add(next);
					que.offer(copy);
				} 
			}
		}
	}

	private static void returnAnswer(Stack<Integer> now) {
		System.out.println(now.size() - 1);
		StringBuilder sb = new StringBuilder();
		for(int a : now) {
				sb.append(a);
				sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
