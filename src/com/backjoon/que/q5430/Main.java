package com.backjoon.que.q5430;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			boolean flag = true;
			boolean way = true;//true老锭 沥规氢, false老锭 开规氢
			String command = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			String[] arr = bf.readLine().replaceAll("\\[", "").replaceAll("\\]", "").split(",");
			
			Deque<String> deque = new LinkedBlockingDeque<>();
			for(int j = 0 ; j < n ; j ++) {
				deque.add(arr[j]);
			}
			
			for(int j = 0 ; j < command.length(); j++) {
				if(command.charAt(j) == 'R') {				
					if(way) way = false;
					else way = true;
							
				} else if(command.charAt(j) == 'D') {
					if(deque.isEmpty()) {
						flag = false;
						bw.write("error\n");
						break;
					}else {
						if(way)deque.pollFirst();
						else deque.pollLast();
					} 
				}
			}
			
			if(flag) {
				bw.write("[");
				while(!deque.isEmpty()) {
					if(way) {
						bw.write(deque.pollFirst() + "");
					}else {
						bw.write(deque.pollLast() + "");
					} 
					
					if(deque.size() > 0)bw.write(",");
				}
				bw.write("]\n");
			}
			
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
