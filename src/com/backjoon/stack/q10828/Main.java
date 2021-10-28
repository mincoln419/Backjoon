package com.backjoon.stack.q10828;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(bf.readLine());
		
		Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
			
			if(read[0].equals("push")) {
				
				st.push(Integer.parseInt(read[1]));
				
			}else if(read[0].equals("pop")) {
				
				if(st.isEmpty())bw.write("-1\n");
				else bw.write(st.pop() + "\n");
				
			}else if(read[0].equals("size")) {
				
				bw.write(st.size() +"\n");
				
			}else if(read[0].equals("empty")) {
				
				if(st.isEmpty())bw.write("1\n");
				else bw.write("0\n");
				
			}else if(read[0].equals("top")) {
				
				if(st.isEmpty())bw.write("-1\n");
				else bw.write(st.peek() + "\n");
				
			}
		}
		bw.flush();
		bf.close();
		bw.close();
	}

}
