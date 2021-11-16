package com.backjoon.two.q1644_primeSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//에라토스테네스의 체로 소수 배열 세팅 - 최대값 4000,000
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2 ; i * i <= n; i++) {
			if(arr[i] == 0) {
				for(int j = i * i ; j <= n; j+= i) {
					arr[j] = 1;
				}
			}
		}
		List<Integer> prime = new ArrayList<>();
		for(int i = 0 ; i <= n ; i ++) {
			if(arr[i] == 0)prime.add(i);
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		while(true) {
			if(sum == n) {
				cnt++;
				sum -= prime.get(left++);
			}else if(sum > n) {
				sum -= prime.get(left++);
			}else {
				if(right == prime.size()) {
					break;
				}
				
				sum += prime.get(right++);
			}
			
		}
		System.out.println(cnt);
	}

}
