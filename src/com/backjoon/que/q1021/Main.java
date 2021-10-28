package com.backjoon.que.q1021;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> deque = new LinkedBlockingDeque<>();
		
		String[] read = bf.readLine().split(" ");
		
		int n = Integer.parseInt(read[0]);
		
		for(int i = 1 ; i <= n ; i++) {
			deque.add(i);
		}
		
		int m = Integer.parseInt(read[1]);
		String[] nums = bf.readLine().split(" ");
		int cnt = 0;
		for(int i = 0 ; i < m ; i++) {
			int target = Integer.parseInt(nums[i]);

			Deque<Integer> lque = new LinkedBlockingDeque<>();
			Deque<Integer> rque = new LinkedBlockingDeque<>();
			lque.addAll(deque);
			rque.addAll(deque);
			
			while(true) {
				int left = lque.pollFirst();
				//왼쪽으로 움직임
				if(left == target) {
					deque = new LinkedBlockingDeque<>();
					deque.addAll(lque);
					break;
				}
				lque.addLast(left);
				
				cnt++;
				
				rque.addFirst(rque.pollLast());
				int right = rque.getFirst();
				
				//오른쪽으로 움직입
				if(right == target) {
					rque.pollFirst();
					deque = new LinkedBlockingDeque<>();
					deque.addAll(rque);
					break;
				}
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}
	
}
