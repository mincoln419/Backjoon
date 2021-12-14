package com.mermer.sort;

import java.util.*;

public class MergeSort {

	//병합정렬 구현
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		
		for(int i = 0 ; i < 10 ; i ++) {
			int ran = (int)(Math.random() * 100);
			if(list.contains(ran))continue;
			list.add(ran);
		}
		
		//랜덤한 수 10개
		for(int a : list) System.out.print(a + " ");
		System.out.println();
		
		List<Integer> reult = merge(list);
		//정렬한 값
		for(int a : reult) System.out.print(a + " ");
		System.out.println();
	}

	private static List<Integer> merge(List<Integer> list) {
		
		if(list.size() <= 1)return list;
		
		List<Integer> result = new ArrayList<>();
		
		if(list.size() == 2) {
			if(list.get(0) > list.get(1)) {
				result.add(list.get(0));
				result.add(list.get(1));
			}else {
				result.add(list.get(1));
				result.add(list.get(0));
			}
			return result;
		}
		
		int mid = list.size()/2;
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		for(int i = 0 ; i < list.size() ; i++) {
			if(i < mid)left.add(list.get(i));
			else right.add(list.get(i));
		}
		merge(left);
		merge(right);
		
		
		int i = 0, j = 0;
		while(i + j < list.size()) {
			int a = left.get(i);
			int b = right.get(j);
			
			if(a < b) {
				result.add(a);
				i++;
			}else {
				result.add(b);
				j++;
			}
			
			if(i == mid - 1) {
				result.add(b);
				j++;
			}else if(j == list.size() - mid) {
				result.add(a);
				i++;
			}
		}
		
		return result;
	}

	
	
	
	
	
}
