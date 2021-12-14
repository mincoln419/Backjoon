package com.mermer.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 퀵정렬 비재귀적 방법
 * */
public class QuickSort2 {
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
		Stack<Integer> lstack = new Stack<>();
		Stack<Integer> rstack = new Stack<>();
		
		lstack.push(left);
		rstack.push(right);
		
		while(!lstack.isEmpty()) {
			System.out.println("________________________________");
			int pl = left = lstack.pop(); //왼쪽 커서
			int pr = right = rstack.pop(); //오른쪽 커서
			System.out.printf("pop left : [%d] right : [%d]\n", a[pl], a[pr]);
			//방법 1. 나눌 배열의 요소 개수가 3 이상이면 임의 요소 3을 선택하고 그중에서 중앙값인 요소로 피벗 선택
			int x = 0;
			if(right - left == 1) x = a[(left + right) / 2];
			else x = a[getPivot(a, left, right)];
			
			System.out.println("피벗: " + x);
			while(pl <= pr) {
				while(a[pl] < x) pl++;
				while(a[pr] > x) pr--;
				
				if(pl <= pr) {
					System.out.printf("swapping:: [%d] - [%d]\n", a[pl], a[pr]);
					swap(a, pl++, pr--);
				}
			}
			
			if(left < pr) {
				System.out.printf("push left : [%d] right : [%d]\n", a[left], a[pr]);
				lstack.push(left);
				rstack.push(pr);
			}
			
			if(pl < right) {
				System.out.printf("push left : [%d] right : [%d]\n", a[pl], a[right]);
				lstack.push(pl);
				rstack.push(right);
			}
		}
		
	}

	private static int getPivot(int[] a, int left, int right) {
		int mid = (left + right)/2;
		if(a[left] <= a[right] && a[right] <= a[mid])return right;
		else if(a[mid] <= a[left] && a[left] <= a[right])return left; 
		else return mid;
	}

	private static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;	
	}
}

