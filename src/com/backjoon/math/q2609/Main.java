package com.backjoon.math.q2609;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bf.readLine());

		for (int i = 0; i < num; i++) {
			String[] read = bf.readLine().split(" ");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			if (n < m) {
				n ^= m;
				m ^= n;
				n ^= m;
			}
			//System.out.println(gcd(n, m));
			System.out.println(m * n / gcd(n, m));
		}
	}

	static int gcd(int a, int b) {

		if (b == 0)
			return a;

		return gcd(b, a % b);
	}
}
