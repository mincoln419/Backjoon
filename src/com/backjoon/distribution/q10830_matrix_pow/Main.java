package com.backjoon.distribution.q10830_matrix_pow;

import java.io.*;

public class Main {

	static int MOD = 1000;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		String[] read = bf.readLine().split(" ");
		n = Integer.parseInt(read[0]);
		long m = Long.parseLong(read[1]);
		
		int[][] A = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			String[] arr = bf.readLine().split(" ");
			for(int j = 0 ; j < n ;j++) {
				A[i][j] = Integer.parseInt(arr[j]);
			}
		}
	
		int[][] answer = dsb(A, m);
				

		//출력
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(answer[i][j]);
				if(j < n-1)System.out.print(" ");
			}
			System.out.println("");
		}
		
		bf.close();
	}
	
	static int[][] dsb(int[][] arr, long m){
		int[][] answer = new int[n][n];
		if(m == 1) {
			//깊은 복사
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					answer[i][j] = arr[i][j] % MOD;
				}
			}
			return answer;
		}
		
		int[][] tmp = dsb(arr, m/2); 
		
		if(m % 2 == 0) {
			answer = getMatrixMult(tmp, tmp);
		}else {
			answer = getMatrixMult(getMatrixMult(tmp, tmp), arr);
		}
		
		return answer;
	}
	
	static int[][] getMatrixMult(int[][] arr1, int[][] arr2){
		int[][] answer = new int[n][n];
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j++) {
				for(int l = 0 ; l < n ; l++) {
					answer[i][j] += arr1[i][l] * arr2[l][j];
				}
				answer[i][j] %= MOD;
			}
		}
		return answer;
	}
	
	
}
