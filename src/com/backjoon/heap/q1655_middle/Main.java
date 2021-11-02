package com.backjoon.heap.q1655_middle;


import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> lpq = new PriorityQueue<>((o1, o2) -> o1 - o2); //큰수는 여기에
		Queue<Integer> rpq = new PriorityQueue<>((o1, o2) -> o2 - o1); //작은수는 여기에
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(bf.readLine());
			if(rpq.isEmpty())rpq.offer(num);
			else {
				if(lpq.isEmpty()) {
					if(num >= rpq.peek())lpq.offer(num);
					else {
						lpq.offer(rpq.poll());
						rpq.offer(num);
					}
				}
				else if(rpq.size() == lpq.size()) {
					if(num <= lpq.peek())rpq.offer(num);
					else {
						rpq.offer(lpq.poll());
						lpq.offer(num);
					}
				}else {
					if(num < rpq.peek()) {
						lpq.offer(rpq.poll());
						rpq.offer(num);
					}else {
						lpq.offer(num);
					}
				}
			}
			bw.write(rpq.peek() +"\n");

		}

		bw.flush();
		bf.close();
		bw.close();
	}
}
