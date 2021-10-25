package com.backjoon.dp.q9251;

import java.io.*;
import java.util.*;

public class Main {

	/*
	 * 문제 LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이
	 * 되는 수열 중 가장 긴 것을 찾는 문제이다.
	 * 
	 * 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
	 * 
	 * 입력 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
	 * 
	 * 출력 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
	 * 
	 */
	static Integer[][] dp;
	static char[] arr1;
	static char[] arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr1 = bf.readLine().toCharArray();
		arr2 = bf.readLine().toCharArray();

		dp = new Integer[arr1.length][arr2.length];

		System.out.println(LCS(arr1.length - 1, arr2.length - 1));
	}

	static int LCS(int x, int y) {

		if (x < 0 || y < 0)
			return 0;

		// 없으면 점화식 태움
		if (dp[x][y] == null) {

			dp[x][y] = 0;

			if (arr1[x] == arr2[y]) {// 같은 경우에는 -1, -1
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			} else {// 다른경우에는 x루트나 y루트로 돌아가는 경우 각각으로 분기
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}

		// 값이 있으면 리턴
		return dp[x][y];
	}

}
