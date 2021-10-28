package com.backjoon.stack.q4949;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String read = bf.readLine();
			
			if(read.equals("."))break;
			
			Stack<Character> st = new Stack<>();
			for(int j = 0 ; j < read.length(); j++) {
				
				if(read.charAt(j) != '('
						&& read.charAt(j) != ')'
						&& read.charAt(j) != '['
						&& read.charAt(j) != ']')continue;
				
				if(st.isEmpty()) { 
						if(read.charAt(j) == '('|| read.charAt(j) == ')')st.push(read.charAt(j));
				}else {
					if(st.peek() == '(' && read.charAt(j) == ')')st.pop();
					else if(read.charAt(j) == '('|| read.charAt(j) == ')')st.push(read.charAt(j));
				}

				if(st.isEmpty()) {
						if(read.charAt(j) == '['|| read.charAt(j) == ']')st.push(read.charAt(j));
				}else {
					if(st.peek() == '[' && read.charAt(j) == ']')st.pop();
					else if(read.charAt(j) == '['|| read.charAt(j) == ']')st.push(read.charAt(j));
				}
			}
			
			if(st.isEmpty())bw.write("yes\n");
			else bw.write("no\n");
		}
		
		bf.close();
		bw.close();
	}
}
