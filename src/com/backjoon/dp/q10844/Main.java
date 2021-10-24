package com.backjoon.dp.q10844;
import java.util.*;
import java.io.*;
public class Main {

	static int MOD = 1000000000;

	/*
	 * ����:
	 * 45656�̶� ���� ����.
	 * 
	 * �� ���� ������ ��� �ڸ��� ���̰� 1�̴�. �̷� ���� ��� ����� �Ѵ�.
	 * 
	 * N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���غ���. 0���� �����ϴ� ���� ��ܼ��� �ƴϴ�.
	 * 
	 * �Է�: ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�.
	 * 
	 * ���: ù° �ٿ� ������ 1,000,000,000���� ���� �������� ����Ѵ�.
	 * 
	 */
	static int[][] memo;
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		//memo���� i�� �����ϴ� �ڸ����� ���
 		memo = new int[10][n];
 		
 		//Ž������ ���� �� -1�� �ʱ� ����
 		for(int i = 0; i < 10 ; i ++) {
 			Arrays.fill(memo[i], -1);
 			memo[i][0] = 1;//��, ������ �ڸ����� 0�� ��� = ���� �Ѱ��� ����� �ִ� ��ܼ��� 1����.
 		}
		
		int sum = 0;
		for(int i = 1 ; i <= 9 ; i++) {
			sum += dp(i , n - 1);
			sum %= MOD;
		}
		
		System.out.println(sum + "");
	}
	
	static int dp(int pre, int rem) {
		
		if(memo[pre][rem] == -1) {
			
			int sum = 0;
			if(pre + 1 <= 9) {
				 sum += dp(pre + 1, rem - 1);
			} 
			if(pre - 1 >= 0) {
				sum += dp(pre - 1, rem - 1);
			}
			memo[pre][rem] = sum%MOD;
		}

		return memo[pre][rem];
	}
}
