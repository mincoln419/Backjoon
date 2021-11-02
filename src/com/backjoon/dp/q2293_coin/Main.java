package com.backjoon.dp.q2293_coin;

import java.io.*;

public class Main {
	
	static int target;
	static int[] coin;
	static int[] cache;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] read = bf.readLine().split(" ");
							
		int n = Integer.parseInt(read[0]);
		target = Integer.parseInt(read[1]);
		
		coin = new int[n + 1];
		for(int i = 0 ; i < n ; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		}
		cache = new int[100005];
		cache[0] = 1;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j <= target; j++) {
				if(j >= coin[i]) {
					cache[j] += cache[j - coin[i]];
				}
			}
		}
		
		bw.write(cache[target] +"\n");
		
		
		bf.close();
		bw.close();

	}	

}
