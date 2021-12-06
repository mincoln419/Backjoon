package com.backjoon.dp.q1509_palindrom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int[][] cache;
	static int[] minValue;
	static char[] arr; 
	static int len;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr = (" " + br.readLine()).toCharArray();//j - 1 조건때문에 마진 추가
		len = arr.length;
		cache = new int[len][len];
		minValue = new int[len];
		
		//팰린드롬 분할의 개수의 최소값 -> s부터 시작할때의 패린드롬을 구해서 cache에 종료지점을 제외한 나머지 부분을 0으로 처리
		//-> cache의 각 행의 합이 분할의 개수
		
		palindrome();
		for(int i = 1 ; i < len ; i ++) {
			minValue[i] = len;
			for(int j = 1 ; j <= i ; j++) {
				//팰리드롬 판별
				if(cache[j][i] > 0) {
					minValue[i] = Math.min(minValue[i], minValue[j - 1] + 1);
				}
			}
		}
		bw.write(minValue[len - 1] + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void palindrome() {
		
		for(int i = 1 ; i < len ;i++) {
			
			//길이 1개짜리
			cache[i][i] = 1;
			
			//길이 2개짜리
			if(i < len - 1) {
				if(arr[i] == arr[i + 1]) {
					cache[i][i + 1] = 1;
					cache[i + 1][i] = 1;
				}
			}
			
		}
		
		//길이 3개 이상
		for(int i = 3 ; i < len ;i++) {
			for(int j = 1; j < len - i + 1; j++) {
				int k = j + i - 1;
				if(arr[j] == arr[k]) {
					if(cache[j + 1][k - 1] == 1) {
						cache[j][k] = 1;
						cache[k][j] = 1;
					}
				}
			}
		}
		
	}
}
