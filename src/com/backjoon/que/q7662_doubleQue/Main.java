package com.backjoon.que.q7662_doubleQue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Long[]> que = new PriorityQueue<>((o1, o2) -> o1[0].compareTo(o2[0]));// 오름차순으로 out
			PriorityQueue<Long[]> reque = new PriorityQueue<>((o1, o2) -> o2[0].compareTo(o1[0]));// 내림차순으로 out
			
			int[] memo = new int[1000000];// 최대 입력 수 배열
			int insCnt = 0;
			for (int i = 0; i < k; i++) {
				String[] read = br.readLine().split(" ");
				Long num = Long.parseLong(read[1]);
				if (read[0].equals("I")) {
					que.offer(new Long[] { num, (long)i });
					reque.offer(new Long[] { num, (long)i });
					insCnt++;
				} else if (read[0].equals("D")) {
					if (insCnt == 0)
						continue;// 만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다.
					if (num == 1) {
						// 최대값 out
						while (true) {
							Long[] poll = reque.poll().clone();
							if (memo[poll[1].intValue()] == 0) {
								memo[poll[1].intValue()] = 1;
								break;
							}
						}
						insCnt--;
					} else if (num == -1) {
						while (true) {
							Long[] poll = que.poll().clone();
							if (memo[poll[1].intValue()] == 0) {
								memo[poll[1].intValue()] = 1;
								break;
							}
						}
						insCnt--;
					}

				}

			}

			if (insCnt == 0) {
				bw.write("EMPTY\n");
			} else {
				long min = 0;
				long max = 0;
				while (!reque.isEmpty()) {
					Long[] poll = reque.poll().clone();
					if (memo[poll[1].intValue()] == 0) {
						max = poll[0];
						break;
					}
				}
				while (!que.isEmpty()) {
					Long[] poll = que.poll().clone();
					if (memo[poll[1].intValue()] == 0) {
						min = poll[0];
						break;
					}
				}
				bw.write(max + " " + min + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();

	}

}
