package com.backjoon.math.q2981;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());

		int[] nums = new int[n];
		for(int i = 0 ; i < n ; i++) {
			nums[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(nums);
		
		int gcdVal = nums[1] - nums[0];
		for(int i = 1 ; i < nums.length - 1; i++) {
			gcdVal = gcd(gcdVal, nums[i + 1] - nums[i]);
		}
		
		for(int i = 2 ; i <= gcdVal ; i++) {
			if(gcdVal % i == 0)System.out.print(i + " ");
		}
		
		bf.close();
	}

	static int gcd(int b, int a) {
		
		if(a == 0)return b;
		
		return gcd(a, b%a);
	}
}
