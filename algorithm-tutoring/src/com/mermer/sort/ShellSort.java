package com.mermer.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ShellSort {

	static void shellSort(int[] a, int n) {
		for(int h = n / 2; h> 0 ; h/= 2) {
			for(int i = h; i < n ; i++) {
				int j = 0;
				int tmp = a[i];
				for(j = i - h ; j >= 0 && a[j] > tmp; j-= h) {
					a[j + h] = a[j];
				}
				a[j + h]  =tmp;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("셸 정렬(버전 1)\n");
		bw.write("요소수\n");
		int nx = Integer.parseInt(bf.readLine());
		int[] x = new int[nx];
		String[] read = bf.readLine().split(" ");
		for(int i = 0; i < nx; i++) {
			bw.write("x[" + i + "]");
			x[i] = Integer.parseInt(read[i]);
		}
		
		shellSort(x, nx);
		
		bw.write("오름차순으로 정렬했습니다");
		
		for(int a : x) {
			bw.write(a + " ");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
}
