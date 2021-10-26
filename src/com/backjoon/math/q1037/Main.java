package com.backjoon.math.q1037;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		
		String[] read = bf.readLine().split(" ");
		
		int[] chk = new int[n];
		for(int i = 0 ; i < n ; i++) {
			chk[i] = Integer.parseInt(read[i]);
		}
		
		Arrays.sort(chk);
		int num = chk[chk.length-1] * chk[0];
		for(int i = 0 ; i < n ; i++) {
			if(num % chk[i] != 0) {
				num *= chk[i];
			}
		}
		System.out.println(num);
		
		
	}
	
}
