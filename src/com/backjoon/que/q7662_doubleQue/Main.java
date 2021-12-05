package com.backjoon.que.q7662_doubleQue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int t = 0 ; t < T ; t ++) {
			
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<>();
			PriorityQueue<Integer> reque = new PriorityQueue<>((o1, o2) -> o2 - o1);
			int insCnt = 0;
			for(int i = 0 ; i < k ; i++) {
				String[] read = br.readLine().split(" ");
				int num = Integer.parseInt(read[1]);
				if(read[0].equals("I")) {
					que.offer(num);
					reque.offer(num);
					insCnt++;
				}else if(read[0].equals("D")) {
					if(num > 0) {
						reque.poll();
					}else {
						que.poll();	
					}
					insCnt--;
				}
				
			}
			if(insCnt <= 0) {
				bw.write("EMPTY\n");
			}else {
				bw.write(reque.peek() + " " + que.peek());
				bw.write("\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}

}
