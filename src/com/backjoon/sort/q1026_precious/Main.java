package com.backjoon.sort.q1026_precious;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		String[] read = bf.readLine().split(" ");
		for(int i = 0 ; i < n ; i++) {
			a[i] = Integer.parseInt(read[i]);
		}
		
		read = bf.readLine().split(" ");
		for(int i = 0 ; i < n ; i++) {
			b[i] = Integer.parseInt(read[i]);
		}
		
		//a, b값의 곱이 최소가 되려면 b 순서에 맞게 정렬해야 함 -> b가 클수록 a는 작아야 함
		Arrays.sort(a);
		Arrays.sort(b);
		
		int s = 0;
		for(int i = 0 ; i < n ; i++) {
			s += a[n - i - 1] * b[i];
		}
		
		bw.write(s + "\n");
		
		bw.flush();
		bf.close();
		bw.close();
	}
}
