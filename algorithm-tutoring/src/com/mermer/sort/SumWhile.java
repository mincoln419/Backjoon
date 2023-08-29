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
		int n = 0;
		int m = 0;
		System.out.println("1 부터 n 까지의 합을 구합니다.");
		while(true) {
			System.out.print("n의 값:");
			n = scanner.nextInt();
			if(n <= 0) {
				System.out.println("n을 양수로 입력해주세요.");
				continue;
			}
			break;
		}

		while(true) {
			System.out.print("m의 값:");
			m = scanner.nextInt();
			if(m <= 0) {
				System.out.println("m을 양수로 입력해주세요.");
				continue;
			}
			break;
		}


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
			result += num + 1;
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
		int i = 1;

		while(i <= (to - from + 1)/2) {
			result += from + to;
			//System.out.println("===> " + result );
			i++;
		}

		if((to - from + 1)%2 == 1) {
			result += (from + to)/2;
		}
		System.out.println(from + "부터 " + to + "까지의 합은 " + result + " 입니다.");
	}

}
