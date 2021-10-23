package com.backjoon.tree;

import java.io.*;
import java.util.*;

public class Main {

		
	public static int[] arr;
	//메모화에 비용과 색깔을 담는다
	public static int[] memo;//
	
	
	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(bf.readLine());
			
			memo = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			//top-bottom
			int[] arr = new int[1001];

			for(int i = 0 ; i < n ; i++) {
				int next = Integer.parseInt(st.nextToken());
				arr[i] = next;
				memo[i] = 1;
			}
			
			int answer = 1;
			
			for(int i = 0 ; i < n ;  i++) {
				int next = arr[i];
				for(int j = 0 ; j < i ; j++) {
					if(next > arr[j]) {
						memo[i] = Math.max(memo[i], memo[j] + 1);
					}
				}
				answer = Math.max(answer, memo[i]);
			}
			
			System.out.println(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}

