package com.backjoon.segment.q11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = br.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int m = Integer.parseInt(read[1]);
		
		read = br.readLine().split(" ");
		
		long[] arr = new long[n + 1];
		long[] sum = new long[n + 1];
		for(int i = 0 ; i < n ; i++) {
			int a = Integer.parseInt(read[i]);
			arr[i + 1] = a;
			sum[i + 1] = sum[i] + a;
		}
		
		//a까지의 합과 b까지의 합을 빼면 a~ b까지의합이다.
		for(int i = 0 ; i < m ; i++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			bw.write((sum[b] - sum[a - 1]) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
