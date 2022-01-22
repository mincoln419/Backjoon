package com.backjoon.greedy.q2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


class Lecture implements Comparable<Lecture>{
	
	int limDay;
	int pay;
	
	public Lecture(int pay, int limDay ) {
		this.pay = pay;
		this.limDay = limDay;
	}

	@Override
	public int compareTo(Lecture target) {
		if(target.pay < this.pay) return 1;
		else if(target.pay == this.pay) {
			if(target.limDay > this.limDay) return 1;
		}
		return -1;
	}
	
}

public class Main {
	/*
	 * n개의 대학(0 ≤ n ≤ 10000) 
	 * d개의 강연 (0 ≤ d ≤ 10000)
	 * 강연료 p (0 ≤ p ≤ 10000)
	 * 강연의 하루 1개만
	 * 
	 * => O(n²) 으로 풀면 1억이 넘어감 -> O(n) 내지는 O(nlongn)을 최대로 고려하여 풀어야 함
	 * 1. 강연 요청 기간이 짧은 강연을 우선적으로 넣되, 
	 * 2. 해당 기간까지 강연의 수가 할 수 있는 강연의 수보다 많을 경우 배제시켜야 함
	 * 
	 * - 구현전략
	 *  1. 우선 강연을 요청 기간 짧은 순으로 정렬
	 *  2. 그리고 원칙은 순차적으로 큐에 순서대로 하나씩 집어넣음 
	 *  3. 여기서 큐는 우선순위 기준으로 하여 poll 되도록 함 -> 페이가 적은 강연으로 하여 강연에서 적은 강연이 먼저 빠짐 
	 *  4. 큐의 사이즈가 강연요청일자보다 큰 경우 하나를 poll 하여 페이가 높은 강연이 큐에 계속 담기도록 함
	 *  5. 주의할 점은 poll을 먼저 해버리면 새로 들어온 강연 페이가 더 낮을 경우 높은 페이의 강연이 빠질 수 있으므로 먼저 offer하고 poll해야함  
	 * -   
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		
		int[][] lectures = new int[n][2]; 
		for(int i = 0 ; i < n ; i++) {
			String[] payDist = bf.readLine().split(" ");
			lectures[i][0] = Integer.parseInt(payDist[0]);
			lectures[i][1] = Integer.parseInt(payDist[1]);
			
		}
		
		Arrays.sort(lectures, (o1, o2) -> o1[1] - o2[1]);
		
		
		for(int[] lec : lectures) {
			int pay = lec[0];
			int limDay = lec[1];
			
			if(limDay > pq.size()) {
				pq.offer(new Lecture(pay, limDay));
			}else {
				pq.offer(new Lecture(pay, limDay));
				pq.poll();
			}
		}

		int tot = 0;
		while(!pq.isEmpty()) {
			Lecture lec = pq.poll();
			
			tot += lec.pay;
		}
		
		System.out.println(tot);
	}
}

