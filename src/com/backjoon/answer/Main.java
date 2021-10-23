package com.backjoon.answer;

import java.util.*;

public class Main{
	
	public static void main(String[] args) {

	
		Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr, new Comparator<>() {
			@Override
			public int compare(int[] a,int[] b) {
				
				if(a[0] > b[0])return 1;
				else if(a[0] == b[0]) {
					if(a[1] > b[1])return 1;
				}
				
				return -1;
			}
		});
		
		for(int i = 0 ; i < n ; i ++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		
	}

}