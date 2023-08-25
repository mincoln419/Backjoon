package com.mermer.sort;

import java.util.Scanner;

public class SumWhile {


	static void sum(int num) {

		int result = 0;
		int i = 1;
		while(i <= num) {
			result += i;
			i++;
		}
		System.out.println("1부터 " + num + "까지의 합은 " + result + " 입니다.");
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 부터 n 까지의 합을 구합니다.");
		System.out.print("n의 값:");
		int n = scanner.nextInt();
		System.out.print("m의 값:");
		int m = scanner.nextInt();

		//sum(n);

		//sumPrint(n);

		//sumByGauce(n);

		sumByBetween(n, m);
	}


	static void sumPrint(int num) {
		int result = 0;
		int i = 1;
		StringBuffer sb = new StringBuffer();

		while(i <= num) {
			result += i;
			if(i > 1) {
				sb.append(" + ");
			}
			sb.append(String.valueOf(i));
			i++;
		}
		System.out.println(sb.toString() + " = " + result);
	}


	static void sumByGauce(int num) {

		int result = 0;
		int i = 1;

		while(i <= num/2) {
			result += (i + ((num + 1) - i));
			i++;
		}
		if(num%2 == 1) {
			result += i;
		}
		System.out.println("1부터 " + num + "까지의 합은 " + result + " 입니다.");

	}

	static void sumByBetween(int from, int to) {

		if(from > to) {
			int tmp = from;
			from = to;
			to = tmp;
		}

		int result = 0;
		int i = from;

		while(i <= (from + to)/2) {
			result += (i + ((to + i) - i));
			i++;
		}
		if((to-from)%2 == 1) {
			result += i;
		}
		System.out.println(from + "부터 " + to + "까지의 합은 " + result + " 입니다.");
	}

}
