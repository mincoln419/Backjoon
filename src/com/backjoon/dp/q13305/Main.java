package com.backjoon.dp.q13305;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		String[] read = bf.readLine().split(" ");
		long[] dist = new long[n];//n-1���� ������ 1��°���� �ǹ̰������Ƿ�
		for(int i = 1 ; i < n; i++) {
			dist[i] = Long.parseLong(read[i - 1]);
		}
		read = bf.readLine().split(" ");
		long[] cost = new long[n];
		for(int i = 0 ; i < n- 1; i++) {
			cost[i] = Long.parseLong(read[i]);
		}
		
		long min = cost[0];//��������� ������������ �ϰ�..
		long sum = 0L;//����� �հ�
		for(int i = 1 ; i < n ; i++) {
			sum += min * dist[i];//������ ���� ������� �ϴ� �����
			min = Math.min(min, cost[i]);//��������� ����������� ����
		}
		
		System.out.println(sum);
	}
}
