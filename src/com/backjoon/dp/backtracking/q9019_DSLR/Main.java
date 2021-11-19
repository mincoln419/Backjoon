package com.backjoon.dp.backtracking.q9019_DSLR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Order{
	
	String mark; //해당 value가 되기 위해 필요했던 mark
	int bef;//변경 직전 value
	int value;
	
	public Order(String mark, int value, int bef) {
		this.mark = mark;
		this.value = value;
		this.bef = bef;
	}

	@Override
	public String toString() {
		return "Order [mark=" + mark + ", bef=" + bef + ", value=" + value + "]";
	}
}

public class Main {
	
	static int MOD = 10000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < T ; t++) {
			
			String[] read = br.readLine().split(" ");
			int s = Integer.parseInt(read[0]);
			int e = Integer.parseInt(read[1]);
			
			int[] visited = new int[10001];//해당 숫자에 대한 방문체크
			Order[] dp = new Order[10001];//기존 숫자값을 node로 기록
			
			Queue<Order> que = new LinkedList<>();
			que.offer(new Order("B", s, -1));//시작점 세팅은 "B", 이전 value는 -1
			visited[s] = 1;
			dp[s] = new Order("B", s, -1);//시작점 이전값은 null..
			//bfs 탐색

			Stack<String> st = new Stack<>();
			while(!que.isEmpty()) {
				Order poll = que.poll();
				//System.out.println(poll.toString());
				//D, S, L, R 순서로 마킹하며 bfs 탐색
				int next = getD(poll.value);
				if(visited[next] == 0) {
					dp[next] = new Order("D", next, poll.value);
					if(next == e)break;
					visited[next] = 1;
					que.offer(dp[next]);
				}
				
				next = getS(poll.value);
				if(visited[next] == 0) {
					dp[next] = new Order("S", next, poll.value);
					if(next == e)break;
					visited[next] = 1;
					que.offer(dp[next]);
				}
				
				next = getL(poll.value);
				if(visited[next] == 0) {
					dp[next] = new Order("L", next, poll.value);
					if(next == e)break;
					visited[next] = 1;
					que.offer(dp[next]);
				}
				
				next = getR(poll.value);
				if(visited[next] == 0) {
					dp[next] = new Order("R", next, poll.value);
					if(next == e)break;
					visited[next] = 1;
					que.offer(dp[next]);
				}
			}
			
			//최종 값 answer를 기준으로 Stack값 세팅
			int tmp = e;

			while(true) {
				if(dp[tmp].value == s)break;
				st.add(dp[tmp].mark);
				tmp = dp[tmp].bef;
			}
			
			while(!st.isEmpty()) {
				bw.write(st.pop() + "");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	/* 각 명령어 연산 함수 정의 */
	static int getD(int num) {
		
		int result = num * 2;
		if(result > 9999) {
			result %= MOD;
		}
		return result;
	}

	static int getS(int num) {
		
		int result = num - 1;
		if(num == 0) {
			result = 9999;
		}
		return result;
	}
	
	static int getL(int num) {
		int result = (num % 1000) * 10 + num / 1000;
		return result;
	}
	
	static int getR(int num) {
		int result = (num / 10) + (num % 10) * 1000;
		return result;
	}
}

