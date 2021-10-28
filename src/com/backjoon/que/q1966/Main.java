package com.backjoon.que.q1966;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
			int m = Integer.parseInt(read[0]);
			Integer idx = Integer.parseInt(read[1]);
			
			
			String[] pri = bf.readLine().split(" ");
			
			
			Queue<Integer[]> que = new LinkedList<>();

			for(int j = 0 ; j < m; j++) {
				Integer[] arr = new Integer[2];
				arr[0] = j;//index
				arr[1] = Integer.parseInt(pri[j]);//�߿䵵
				que.offer(arr);
			}
			
			int cnt = 0;
			while(!que.isEmpty()) {
				Integer[] poll = que.poll().clone();
				boolean flag = true;
				for(Integer[] a : que) {
					if(poll[1] < a[1]) {
						flag = false;
						break;
					}  
				}
				if(flag) {
					cnt++;
					if(poll[0] == idx)break;
				}else que.offer(poll);
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
