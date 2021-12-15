package com.mermer.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.util.*;

public class MergeSort {

	//병합정렬 구현
	public static void main(String[] args) throws IOException {
		File file = new File("src/com/mermer/sort/target/test.txt");
		FileOutputStream bw = new FileOutputStream(file);
		List<Integer> list = new LinkedList<>();
		
		for(int i = 0 ; i < 100000 ; i ++) {
			int ran = (int)(Math.random() * 10000000);
			if(list.contains(ran))continue;
			list.add(ran);
		}
		
		//랜덤한 수 10개
		for(int a : list)bw.write((a + "\n").getBytes());
		bw.write("\n".getBytes());
		
		List<Integer> reult = split(list);
		//정렬한 값
		for(int a : reult) bw.write((a + "\n").getBytes());
		bw.write("\n".getBytes());
		
		
		bw.flush();
		bw.close();
	}

	private static List<Integer> split(List<Integer> list) {
		
		if(list.size() <= 1)return list;
	
		int mid = list.size()/2;
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		for(int i = 0 ; i < list.size() ; i++) {
			if(i < mid)left.add(list.get(i));
			else right.add(list.get(i));
		}
		
		left = split(left);
		right = split(right);
		
		return merge(left, right);
	}

	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		while(i + j < left.size() + right.size()) {
			
			if(i == left.size()) {
				result.add(right.get(j));
				j++;
			}else if(j == right.size()) {
				result.add(left.get(i));
				i++;
			}else {
				if(left.get(i) < right.get(j)) {
					result.add(left.get(i));
					i++;
				}else {
					result.add(right.get(j));
					j++;
				}
			}
		}
		return result;
	}

	
	
	
	
	
}
