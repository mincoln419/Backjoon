package com.backjoon.dp.backtracking.q2618_policeCar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
 * 참고소스
 * https://subbak2.tistory.com/m/83
 * 
 * */

public class Main {

	static int[][] dp;
	static int[][] arr;
	static int n, w;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());

		dp = new int[w + 1][w + 1];// 마진 1 - 1번 경찰차가 i번 사건 처리, 2번 경찰차가 j번 처리했을 경우 최소비용
		for (int i = 0; i <= w; i++) {
			Arrays.fill(dp[i], -1);
		}
		arr = new int[w + 1][2];
		for (int i = 1; i <= w; i++) {
			String[] read = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(read[0]);
			arr[i][1] = Integer.parseInt(read[1]);
		}

		System.out.println(getRouteDistance(0, 0));

		getPol(0, 0);

		br.close();
	}

	static void getPol(int pol1, int pol2) {
		if (pol1 == w || pol2 == w)
			return;

		int next = Math.max(pol1, pol2) + 1;

		int dist1, dist2 = 0;

		// 경찰1의 지금까지 거리
		if (pol1 == 0) {
			dist1 = getDist(1, 1, arr[next][1], arr[next][0]);
		} else {
			dist1 = getDist(arr[pol1][1], arr[pol1][0], arr[next][1], arr[next][0]);
		}

		// 경찰2의 지금까지 거리
		if (pol2 == 0) {
			dist2 = getDist(n, n, arr[next][1], arr[next][0]);
		} else {
			dist2 = getDist(arr[pol2][1], arr[pol2][0], arr[next][1], arr[next][0]);
		}
		
		if(dp[next][pol2] + dist1 < dp[pol1][next] + dist2) {
			System.out.println(1);
			getPol(next, pol2);
		}else {
			System.out.println(2);
			getPol(pol1, next);
		}
		
	}

	static int getRouteDistance(int pol1, int pol2) {// 인자값은 현재 pol1, pol2 가 담당하고 있는 사건번호

		if (pol1 == w || pol2 == w)
			return 0;

		if (dp[pol1][pol2] != -1) {
			return dp[pol1][pol2];
		}

		int next = Math.max(pol1, pol2) + 1;

		int dist1, dist2 = 0;

		// 경찰1의 지금까지 거리
		if (pol1 == 0) {
			dist1 = getDist(1, 1, arr[next][1], arr[next][0]);
		} else {
			dist1 = getDist(arr[pol1][1], arr[pol1][0], arr[next][1], arr[next][0]);
		}

		// 경찰2의 지금까지 거리
		if (pol2 == 0) {
			dist2 = getDist(n, n, arr[next][1], arr[next][0]);
		} else {
			dist2 = getDist(arr[pol2][1], arr[pol2][0], arr[next][1], arr[next][0]);
		}

		// 경찰1이 문제해결했을 경우
		int result1 = dist1 + getRouteDistance(next, pol2);
		// 경찰2이 문제해결했을 경우
		int result2 = dist2 + getRouteDistance(pol1, next);

		return dp[pol1][pol2] = Math.min(result1, result2);
	}

	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

}
