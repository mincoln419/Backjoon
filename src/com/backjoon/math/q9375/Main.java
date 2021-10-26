package com.backjoon.math.q9375;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(bf.readLine());
			
			Map<String, Integer> part = new HashMap<>();
			for (int j = 0; j < m; j++) {
				String read[] = bf.readLine().split(" ");// wear, part - wear >= part..
				
				part.put(read[1], part.getOrDefault(read[1], 1) + 1);//의상종류에는 '알몸'인 경우가 default
			}
			// 하나씩 안입은것까지 포함.. 그리고 알몸인 경우 제외
			int answer = 1; 
			for(String key : part.keySet()) {
				answer *= part.get(key);
			}
			System.out.println(answer - 1);
		}

	}

}
