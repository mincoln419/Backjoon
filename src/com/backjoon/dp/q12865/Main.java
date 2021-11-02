package com.backjoon.dp.q12865;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(bf.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n + 1][k + 1];
		
	
		//dp[weight]�� ���԰� weight ��ŭ �Ǵ� ����� ��ġ�� �ִ밪�� �Է��Ѵ�. -> �߰��Ҽ� ���� ���� �ش� ���԰� �޸�ȭ�� ���� i������ �״�� �����´�
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= k; j++){//
				if(w[i] > j) {//�ش� �޸𰪿� �߰��� �� �����Ƿ� �״�� ������ 
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]]+ v[i]);
				}
				
			}
		}
		
		System.out.println(dp[n][k]);
		
	}
}
