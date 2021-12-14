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
		/* 
		 * 방법 2. 나눌 배열의 처음, 가운데, 끝 요소를 정렬한 다음 가운데 요소와 끝에서 두번째 요소를 교환.
		 * 피벗으로 끝에서 두 번째 요소의 값(a[right-1] 을 선택하여 나눌 대상의 범위를 a[left + 1] ~ a[right-2]로 좁힌다.
		 * */ 
		int x = 0;
		if(right - left == 1) x = a[(left + right) / 2];
		else x = a[getPivot(a, left, right)];
		System.out.println("피벗: " + x);
		
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

	private static int getPivot(int[] a, int left, int right) {

		int mid = (left + right)/2;
		int tmp = 0;
		
		if(a[left] > a[right]) {
			swap(a, left, right);	
		}
		
		if(a[left] > a[mid]) {
			swap(a, left, mid);
		}
		
		if(a[mid] > a[right]) {
			swap(a, mid, right);
		}
		return right - 1;
	}

	private static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;	
	}
}
