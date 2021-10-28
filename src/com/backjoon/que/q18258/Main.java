package com.backjoon.que.q18258;

import java.io.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedBlockingDeque<Integer> que = new LinkedBlockingDeque<>();
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
			
			if(read[0].equals("push")) {
				que.offer(Integer.parseInt(read[1]));
			}else if(read[0].equals("pop")) {
				if(que.isEmpty()) bw.write( -1 +"\n");
				else bw.write(que.poll() + "\n");
			}else if(read[0].equals("size")) {
				bw.write(que.size() + "\n");
			}else if(read[0].equals("empty")) {
				bw.write((que.isEmpty()? 1 : 0) + "\n");
			}else if(read[0].equals("front")) {
				if(que.isEmpty()) bw.write( -1 +"\n");
				else bw.write(que.getFirst() + "\n");
			}else if(read[0].equals("back")) {
				if(que.isEmpty()) bw.write( -1 +"\n");
				else bw.write(que.getLast() + "\n");
			}
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}
}
