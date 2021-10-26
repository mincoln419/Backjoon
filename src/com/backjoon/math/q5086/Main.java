package com.backjoon.math.q5086;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String[] read = bf.readLine().split(" ");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			if(m == 0 && n == 0)break;
			if(m % n == 0)System.out.println("factor");
			else if(n % m == 0)System.out.println("multiple");
			else System.out.println("neither");
		}
	}

}
