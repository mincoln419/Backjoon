package com.backjoon.stack.q17298;

import java.io.*;
import java.util.*;


class ArrNum{
	public int idx;
	public int num;
	public ArrNum(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		Stack<ArrNum> st = new Stack<>();
		
		String[] read = bf.readLine().split(" ");
		
		int[] arr = new int[n];
		for(int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(read[i]); 
		}
		
		Integer[] answer = new Integer[n];
		for(int i = 0 ; i < n ; i++) {
			int num = arr[i];
			
			if(st.isEmpty())st.push(new ArrNum(i, num));
			else {
				if(st.peek().num < num) {
					ArrNum pop = st.pop();
					answer[pop.idx] = num;
					i--;
				}else st.push(new ArrNum(i, num));
			}
		}
		
		while(!st.isEmpty()) {
			ArrNum pop = st.pop();
			answer[pop.idx] = -1;
		}
		
		for(int i = 0 ; i < n; i++) {
			bw.write(answer[i] + " ");
		}
		bw.flush();
		bf.close();
		bw.close();

	}

}
