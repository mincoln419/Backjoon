package com.mermer.sort;

import java.util.Scanner;

public class Loof {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		System.out.println("n의 합셈표");
		while (true) {
			System.out.print("n의 값:");
			n = scanner.nextInt();
			if (n <= 0) {
				System.out.println("n을 양수로 입력해주세요.");
				continue;
			}
			break;
		}

		//makeMultipleTable(n);

		makeSumTable(n);

	}

	static void makeSumTable(int n) {

		for(int i = 0; i <= n ; i ++) {
			for(int j = 0; j <= n; j++) {

				if(j == 0) {
					if(i == 0) {
						System.out.print(String.format("%2s", "") + "|");
					}else {
						System.out.print(String.format("%2d",i) + "|");
					}

				}else {
					if(i == 0) {
						System.out.print(String.format("%2d", j) + " ");
					}else {
						System.out.print(String.format("%2d", i + j) + " ");
					}

				}

			}
			System.out.println();
			if(i == 0) {
				System.out.println("--+---------------------------");
			}
		}

	}

	static void makeMultipleTable(int n) {

		for(int i = 0; i <= n ; i ++) {
			for(int j = 0; j <= n; j++) {

				if(j == 0) {
					if(i == 0) {
						System.out.print(String.format("%2s", "") + "|");
					}else {
						System.out.print(String.format("%2d",i) + "|");
					}

				}else {
					if(i == 0) {
						System.out.print(String.format("%2d", j) + " ");
					}else {
						System.out.print(String.format("%2d", i * j) + " ");
					}

				}

			}
			System.out.println();
			if(i == 0) {
				System.out.println("--+---------------------------");
			}
		}

	}
	
	
}
