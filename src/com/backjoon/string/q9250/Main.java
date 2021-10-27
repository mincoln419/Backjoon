package com.backjoon.string.q9250;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String[] S = new String[n];
		for(int i = 0 ; i < n ; i++) {
			S[i] = bf.readLine();
		}
		
		int m = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < m ; i++) {
			String target = bf.readLine();
			boolean chk = true;
			for(int j = 0 ; j < n ; j++) {
				if(target.indexOf(S[j]) >= 0) {
					chk = false;
					System.out.println("YES");
				}
			}
			if(chk)System.out.println("NO");
			
		}

		bf.close();
	}
}
