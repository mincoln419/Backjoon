package com.backjoon.stack.q10773;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(bf.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0 ; i < n ; i++) {
			
			int num = Integer.parseInt(bf.readLine());
			
			if(num == 0)st.pop();
			else st.push(num);
		}
		int sum = 0;
		for(Integer a : st) {
			sum += a;
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		bf.close();
		bw.close();
	}

}
