package com.mermer.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 퀵정렬 재귀적 방법
 * */
public class QuickSort {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int nx = Integer.parseInt(bf.readLine());
		int[] x = new int[nx];
		String[] read = bf.readLine().split(" ");
		System.out.println("퀵 정렬");
		System.out.print("요소수 ");
		System.out.println(nx + "\n");
		for(int i = 0; i < nx; i++) {
			x[i] = Integer.parseInt(read[i]);
			System.out.print("x[" + i + "]:" + x[i] + " , " );
		}
		System.out.println();
		
		quickSort(x, 0, nx - 1);
		
		System.out.println("오름차순으로 정렬했습니다");
		
		for(int a : x) {
			System.out.print(a + " ");
		}
		
		bf.close();
	}

	private static void quickSort(int[] a, int left, int right) {

		int pl = left;
		int pr = right;
		int x = a[(pl + pr)/2];
		
		System.out.printf("a[%d] ~ a[%d] : {", left, right);
		for(int i = left; i < right; i++) {
			System.out.printf("%d , ", a[i]);
		}
		System.out.printf("%d}\n" , a[right]);
		
		while(pl <= pr) {
			while(a[pl] < x)pl++;
			while(a[pr] > x)pr--;
			if(pl <= pr)swap(a, pl++, pr--);
		}
		
		if(left < pr)quickSort(a, left, pr);
		if(pl < right)quickSort(a, pl, right);
		
	}

	private static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;	
	}
}
