package com.backjoon.stack.q1874;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 0 ; i < n ; i++) {
			int m = Integer.parseInt(bf.readLine());
			que.offer(m);
		}
		
		Stack<Integer> st = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= n ; i++) {
			if(!que.isEmpty() && !st.isEmpty() && que.peek().compareTo(st.peek()) == 0) {
				sb.append("-\n");
				st.pop();
				que.poll();
				i--;
			}else {
				sb.append("+\n");
				st.push(i);
			}
		}
		
		while(!que.isEmpty() && !st.isEmpty()) {
			
			if(que.poll().compareTo(st.pop()) == 0) {
				sb.append("-\n");
			}else{
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
		}
		
		if(!que.isEmpty() || !st.isEmpty()) {
			sb = new StringBuilder();
			sb.append("NO");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bf.close();
		bw.close();
	}
}
