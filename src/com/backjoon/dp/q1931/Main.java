package com.backjoon.dp.q1931;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		Integer[][] arr = new Integer[n][2];
		int max = (int)Math.pow(2, 31) - 1;

		for(int i = 0 ; i < n ; i++) {
			String[] read = bf.readLine().split(" ");
			arr[i][0] = Integer.parseInt(read[0]);
			arr[i][1] = Integer.parseInt(read[1]);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] > o2[1])return 1;
			else if(o1[1] == o2[1]) {
				if(o1[0] > o2[0])return 1;
			}
			return -1;
		});//종료시간 빠른순으로 잡고
		
		//회의시간이 동시에 가능한 경우는 pad에 담고, 아닌 경우는 담지 않는다
		Deque<Integer[]> que = new LinkedBlockingDeque<>();
		que.offer(arr[0]);
		int answer = 0;
		for(int i = 1 ; i < n ; i++) {
			
			Integer[] first = que.getFirst().clone();
			
			if(first[1] <= arr[i][0]) {
				que.offer(arr[i].clone());
				Integer[] poll = que.poll().clone();
				//System.out.println("answer::" + poll[0] + " , " + poll[1]);
				answer++;
			}
		}
		answer += que.size();
		System.out.println(answer);
		
	}
}
