package com.backjoon.math.q3036;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String[] read = bf.readLine().split(" ");
		int[] ring = new int[n];
		for(int i = 0 ; i < n ; i++) {
			ring[i] = Integer.parseInt(read[i]);
		}
		
		//각각의 수를 최대공약수로 값을 나눈 값
		int std = ring[0];
		for(int i = 1; i < n ; i++) {
			
			int mod = gcd(Math.max(std, ring[i]), Math.min(std, ring[i]));
			System.out.println((std/mod) + "/" + (ring[i]/mod));
		}

		bf.close();
	}
	
	//a >= b일 경우
	static int gcd(int a, int b) {
		if(b == 0)return a;
		return gcd(b, a%b);
	}

}
