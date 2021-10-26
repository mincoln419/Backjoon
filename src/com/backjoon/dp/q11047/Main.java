package com.backjoon.dp.q11047;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] read = bf.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);
		
		int[] coins = new int[n];
		for(int i = 0 ; i < n ; i++) {
			coins[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(coins);
		int idx = coins.length - 1;
		int answer = 0;
		while(idx >= 0) {
			if(k < coins[idx]) {
				idx--;
				continue;
			}else {
				answer += k/coins[idx];
				k %= coins[idx];
			}
			
			if(k == 0)break;
			
		}
		System.out.println(answer);
	}

}
