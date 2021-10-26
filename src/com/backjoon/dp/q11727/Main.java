package com.backjoon.dp.q11727;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	/*
	 * ���� 2��n ���簢���� 1��2, 2��1�� 2��2 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Ʒ� �׸��� 2��17 ���簢���� ä�� �Ѱ��� ���̴�.
	 * 
	 * 
	 * 
	 * �Է� ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)
	 * 
	 * ��� ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
	 * 
	 */
	static int MOD = 10007;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		int n = Integer.parseInt(bf.readLine());
		
		//��ȭ�ı��ؼ� dp�� ó��
		int[] dp = new int[n + 2];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		//dp[4] = dp[3] * 2 - 1;
		
		for(int i = 3 ; i <= n ; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2)%MOD;
		}
		System.out.println(dp[n]);
	}

}
