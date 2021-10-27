package com.backjoon.bit.q1094;

import java.io.*;


public class Main {

	static int stick = 64;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		
		int answer = 0;
		int sum = 0;
		while(stick > 0) {
			
			if(stick > n) {
				stick = stick >> 1 ;//반으로 자른다면 비트 연산자가 뒤로 쉬프트
			}else{
				if(sum + stick <= n) {
					sum += stick;
					stick = stick >> 1 ;
					answer++; 
				}else stick = stick >> 1;
			}
			//System.out.println("sum::" + sum);
			//System.out.println("stick::" + stick);
			
			if(sum == n)break;
		}
		
		System.out.println(answer);

	}

}
