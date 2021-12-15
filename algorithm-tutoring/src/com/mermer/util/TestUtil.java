package com.mermer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * @packageName : com.mermer.util 
 * @fileName : TestUtil.java 
 * @author : Mermer
 * @date : 2021.12.16 
 * @description : 
 * =========================================================== 
 * DATE AUTHOR NOTE 
 * ----------------------------------------------------------- 
 * 2021.12.16 Mermer 최초 생성 
 */
public class TestUtil {

	public static int[] getRandomArr(int n, int range, boolean flag) throws Exception {

		/* 
		 * flag가 true 일 경우에는 중복 설정을 허용하지 않는 방식으로 리턴
		 * */
		if(flag)return getRandomArr(n, range);
		
		/*
		 * 그렇지 않은 경우에는 중복상관없이 바로 배열에 담아 리턴
		 * */
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			int ran = (int)(Math.random() * range);
			arr[i] = ran;
		}
		
		return arr;
	}
	
	
	/* 중복을 허용하지 않는 랜덤 수 배열 */
	public static int[] getRandomArr(int n, int range) throws Exception{
		
		if(n > range) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int[] arr = new int[n];
		Set<Integer> set = new HashSet<>();
		for(int i = 0 ; i < n ;) {
			int ran = (int)(Math.random() * range);
			if(set.contains(ran))continue;
			set.add(ran);
			arr[i] = ran;
			i++;
		}
				
		return arr;
	}

	/* getRandomArr 값을 리스트로 받길 원할 때 */
	public static List<Integer> getRandomArrAsList(int n, int range, boolean flag) throws Exception {
		List<Integer> result = new ArrayList<>();
		int[] arr = null; 
		if(flag) arr = getRandomArr(n, range);
		else  arr = getRandomArr(n, range, flag);
			
		Arrays.stream(arr).forEach(num -> {result.add(num);});
		
		return result; 
	}
	
	/* getRandomArrAsList overload */
	public static List<Integer> getRandomArrAsList(int n, int range) throws Exception {
		
		return getRandomArrAsList(n, range, true); 
	}
	
}
