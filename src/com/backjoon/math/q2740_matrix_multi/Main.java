package com.backjoon.math.q2740_matrix_multi;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		String[] read = bf.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int m = Integer.parseInt(read[1]);
		
		int[][] A = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			String[] arr = bf.readLine().split(" ");
			for(int j = 0 ; j < m ;j++) {
				A[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		read = bf.readLine().split(" ");
		m = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);
		int[][] B = new int[m][k];
		for(int i = 0 ; i < m ; i++) {
			String[] arr = bf.readLine().split(" ");
			for(int j = 0 ; j < k; j++) {
				B[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		int[][] answer = new int[n][k];
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < k ; j++) {
				for(int l = 0 ; l < m ; l++) {
					answer[i][j] += A[i][l] * B[l][j];
				}
			}
		}
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < k ; j++) {
				System.out.print(answer[i][j]);
				if(j < k-1)System.out.print(" ");
			}
			System.out.println("");
		}
		
		bf.close();
	}
	
}
