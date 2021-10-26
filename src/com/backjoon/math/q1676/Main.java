package com.backjoon.math.q1676;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		//10 의 배수여야 0이 뒤에서 부터 카운팅 가능 - 5의 배수의 갯수를 구함 -> 5의 제곱인 경우 반복해서 나누어줌
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
