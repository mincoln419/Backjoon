package com.mermer.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ShellSort2 {

	static void shellSort(int[] a, int n) {
		int cnt = 0;
		int h = 0;
		for(h = 1; h < n / 9; h = h * 3 + 1);
		
		for(; h> 0 ; h/= 3) {
			for(int i = h; i < n ; i++) {
				int j = 0;
				int tmp = a[i];
				for(j = i - h ; j >= 0 && a[j] > tmp; j-= h) {
					a[j + h] = a[j];
					cnt++;
				}
				a[j + h]  = tmp;
			}
		}
		System.out.println("cnt::" + cnt);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("셸 정렬(버전 2)\n");
		bw.write("요소수 ");
		int nx = Integer.parseInt(bf.readLine());
		bw.write(nx + "\n");
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
