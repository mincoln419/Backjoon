package com.backjoon.dp.q11399;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		Integer[] arr = new Integer[n];

		String[] read = bf.readLine().split(" ");
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(read[i]);
		}
		
		Arrays.sort(arr);//�ð� ���� �ɸ��� ��� ������ �����ϰ�
		
		int sum = 0;
		int answer = 0;
		for(int i = 0 ; i < arr.length; i++) {
			sum += arr[i];
			answer += sum;
		}
		
		System.out.println(answer);
	}

}
