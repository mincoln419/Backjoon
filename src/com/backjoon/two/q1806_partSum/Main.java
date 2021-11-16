package com.backjoon.two.q1806_partSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = br.readLine().split(" ");
		
		int n = Integer.parseInt(read[0]);
		int s = Integer.parseInt(read[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int i = 0 ;
		Queue<Integer> ique = new LinkedList<>();
		
		long isum = 0;
		int answer = INF;
	
		while(i < n) {
		
			isum += arr[i];
			ique.offer(arr[i]);
			i++;
			while(isum >= s) {
				answer = Math.min(ique.size(), answer);
				isum -= ique.poll();
			}
		}
		
		if(answer == INF)System.out.println(0);
		else System.out.println(answer);
	}
	
}
