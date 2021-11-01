package com.backjoon.distribution.q6549_histogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] read = bf.readLine().split(" ");
			if(read[0].equals("0"))break;
			
			int n = Integer.parseInt(read[0]);
			int[] arr = new int[n]; 
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(read[i + 1]);
			} 
		}
		
		
		
		bf.close();
	}

}
