package com.backjoon.que.q10866;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> deque = new LinkedBlockingDeque<>();
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
					
			if(read[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(read[1]));
			}else if(read[0].equals("push_back")) {
				deque.addLast(Integer.parseInt(read[1]));
			}else if(read[0].equals("pop_front")) {
				if(deque.isEmpty())bw.write("-1\n");
				else bw.write(deque.pollFirst() +"\n");
			}else if(read[0].equals("pop_back")) {
				if(deque.isEmpty())bw.write("-1\n");
				else bw.write(deque.pollLast() +"\n");
			}else if(read[0].equals("size")) {
				bw.write(deque.size() +"\n");
			}else if(read[0].equals("empty")) {
				bw.write((deque.isEmpty()? 1 : 0) +"\n");
			}else if(read[0].equals("front")) {
				if(deque.isEmpty())bw.write("-1\n");
				else bw.write(deque.getFirst() +"\n");
			}else if(read[0].equals("back")) {
				if(deque.isEmpty())bw.write("-1\n");
				else bw.write(deque.getLast() +"\n");
			}

		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
