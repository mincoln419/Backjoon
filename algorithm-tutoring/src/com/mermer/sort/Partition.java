package com.mermer.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Partition {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("배열을 나눕니다\n");
		bw.write("요소수: ");
		int nx = Integer.parseInt(bf.readLine());
		bw.write(nx + "\n");
		int[] x = new int[nx];
		String[] read = bf.readLine().split(" ");
		for(int i = 0 ; i < nx ; i++) {
			
			x[i] = Integer.parseInt(read[i]);
			bw.write("x[" + i + "] : " + x[i] + ", ");
		}
		partition(x, nx);
		bw.flush();
		bf.close();
		bw.close();
		
	}

	private static void partition(int[] a, int n) {
		int pl = 0;
		int pr = n - 1;
		int x = a[n / 2];
		
		while(pl <= pr) {
			while(a[pl] < x)pl++;
			while(a[pr] > x)pr--;
			if(pl <= pr)swap(a, pl++, pr--);
		}
		
		System.out.println("피벗의 값은 " + x + " 입니다");
		System.out.println("피벗 이하의 그룹");
		for(int i = 0 ; i <= pl-1 ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
		
		if(pl > pr + 1) {
			System.out.println("피벗과 일치하는 그룹");
			for(int i = pr+ 1 ; i <= pl-1 ; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("피벗 이상의 그룹");
		for(int i = pr + 1 ; i < n ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");		
	}

	private static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
		
}
