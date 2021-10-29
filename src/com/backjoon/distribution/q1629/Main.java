package com.backjoon.distribution.q1629;

import java.io.*;

public class Main {
	
	static long B;
	static long C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = bf.readLine().split(" ");
		int A = Integer.parseInt(read[0]);
		B = Long.parseLong(read[1]);//�ŵ�����Ƚ��
		C = Long.parseLong(read[2]);//���������ϱ� ���� MOD
		
		System.out.println(dsb(A, B));
	}

	static long dsb(long A, long B) {//�ΰ��� ������ ���
		
		if(B == 0)return 1 % C;
		
		long d = dsb(A, B/2);
		if(B % 2 == 0) {
			return (long)d * d % C;
		}else {
			return (long)d * d % C * A % C;
		}
	}
}
