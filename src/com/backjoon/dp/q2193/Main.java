package com.backjoon.dp.q2193;

import java.io.*;

public class Main {
	/*
	 * ���� 0�� 1�θ� �̷���� ���� �������� �Ѵ�. �̷��� ������ �� Ư���� ������ ���� �͵��� �ִµ�, �̵��� ��ģ��(pinary
	 * number)�� �Ѵ�. ��ģ���� ������ ������ �����Ѵ�.
	 * 
	 * ��ģ���� 0���� �������� �ʴ´�. ��ģ�������� 1�� �� �� �������� ��Ÿ���� �ʴ´�. ��, 11�� �κ� ���ڿ��� ���� �ʴ´�. ���� ���
	 * 1, 10, 100, 101, 1000, 1001 ���� ��ģ���� �ȴ�. ������ 0010101�̳� 101101�� ���� 1, 2�� ��Ģ��
	 * ����ǹǷ� ��ģ���� �ƴϴ�.
	 * 
	 * N(1 �� N �� 90)�� �־����� ��, N�ڸ� ��ģ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� N�� �־�����.
	 * 
	 * ���: ù° �ٿ� N�ڸ� ��ģ���� ������ ����Ѵ�.
	 */
	
	static long[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		dp = new long[n + 2];//�� �ڸ����� ��ģ�� ������ �޸�ȭ
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for(int i = 3 ; i <= n ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
