package com.backjoon.que.q11866;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] read = bf.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1 ; i <= n ; i++) {
			que.offer(i);
		}
		
		int[] answer = new int[n];
		int idx = 0;
		while(!que.isEmpty()) {
			for(int i = 0 ; i < k - 1; i++) {
				que.offer(que.poll());
			}
			answer[idx] = que.poll();
			idx++;
		}
		
		
		bw.write("<");
		for(int i = 0 ; i < n ; i++) {
			bw.write(answer[i]+"");
			if(i < n-1)bw.write(", ");
		}
		bw.write(">");
		
		bw.flush();
		bf.close();
		bw.close();	
	}

}
