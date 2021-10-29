package com.backjoon.distribution.q11444_fibonachi_matrix;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int MOD = 1000000007;
	static int n = 2;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		String[] read = bf.readLine().split(" ");
		Long m = Long.parseLong(read[0]);
		
		long[][] fibo = {{0,1},{1,1}};
		
	
		long[][] answer = dsb(fibo, m);
				

		//출력
		System.out.println(answer[1][0]);
		
		bf.close();
	}
	
	static long[][] dsb(long[][] arr, long m){
		long[][] answer = new long[n][n];
		if(m == 1) {
			//깊은 복사
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					answer[i][j] = arr[i][j] % MOD;
				}
			}
			return answer;
		}
		
		long[][] tmp = dsb(arr, m/2); 
		
		if(m % 2 == 0) {
			answer = getMatrixMult(tmp, tmp);
		}else {
			answer = getMatrixMult(getMatrixMult(tmp, tmp), arr);
		}
		
		return answer;
	}
	
	static long[][] getMatrixMult(long[][] arr1, long[][] arr2){
		long[][] answer = new long[n][n];
		
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
