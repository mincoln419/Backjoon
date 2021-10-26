package com.backjoon.math.q1676;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		//10 �� ������� 0�� �ڿ��� ���� ī���� ���� - 5�� ����� ������ ���� -> 5�� ������ ��� �ݺ��ؼ� ��������
		int answer = 0;
		for(int i = 1 ; i <= n ; i++) {
			int num = i;
			while(true) {
				if(num % 5 == 0) {
					num /= 5;
					answer++;
				}else break;
			}
			
		}
		System.out.println(answer);
	}
}
