package com.backjoon.stack.q9012;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n  = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			String read = bf.readLine();
			
			Stack<Character> st = new Stack<>();
			for(int j = 0 ; j < read.length(); j++) {
				
				if(st.isEmpty())st.push(read.charAt(j));
				else {
					if(st.peek() == '(' && read.charAt(j) == ')')st.pop();
					else st.push(read.charAt(j));
				}
				
			}
			if(st.isEmpty())bw.write("YES\n");
			else bw.write("NO\n");
		}
		
		
		bf.close();
		bw.close();
	}
}
