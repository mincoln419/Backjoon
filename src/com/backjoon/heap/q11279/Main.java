package com.backjoon.heap.q11279;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			
			if(Math.abs(o1) > Math.abs(o2))return 1;
			else if(Math.abs(o1) == Math.abs(o2)) {
				if(o1 > o2)return 1;
			}
			return -1;
		});
		
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(bf.readLine());
			
			if(num == 0) {
				if(pq.isEmpty())bw.write(0 +"\n");
				else bw.write(pq.poll() +"\n");
			}
			else pq.offer(num);
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}

}
