package com.backjoon.distribution.q6549_histogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] read = bf.readLine().split(" ");
			if (read[0].equals("0"))break;

			int n = Integer.parseInt(read[0]);
			arr = new int[100001];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(read[i + 1]);
			}			
			
			bw.write(getMax(0, n - 1) + "\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	
	private static long getMax(int s, int e) {
		long leftMax = 0L, rightMax = 0L, midMax = 0L;
		
		if(s >= e) return arr[s];
		
		leftMax = Math.max(leftMax, getMax(s, (s + e) / 2));
		rightMax = Math.max(rightMax, getMax((s + e)/2 + 1, e));
		
		long length = 1;
		long height = arr[(s + e) / 2];
		midMax = height * length;
		int left = ((s + e) / 2) - 1;
		int right = ((s + e) / 2) + 1;
		
		while(true) {
			if(left == s - 1 && right == e + 1) break;
			else if ((left >= s && right <= e && arr[left] >= arr[right]) || (right == e + 1)) {
				length++;
				if(height > arr[left]) height = arr[left];
				midMax = Math.max(midMax, height * length);
				left--;
			}else if((left >= s && right <= e && arr[left] < arr[right]) || (left == s - 1)) {
				length++;
				if(height > arr[right])height = arr[right];
				midMax = Math.max(midMax, height * length);
				right++;
			}
			
		}

		return Math.max(Math.max(leftMax, rightMax), midMax);
	}

}
