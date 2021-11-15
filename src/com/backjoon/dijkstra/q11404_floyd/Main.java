package com.backjoon.dijkstra.q11404_floyd;

import java.io.*;
import java.util.*;

public class Main {

	static Long[][] board;
	static Long[] dist;
	static Long INF = Long.MAX_VALUE;
	static int n, m;

	// Bellman-Ford - 최단거리 구할때 음수가 포함될 경우.. -> cycle 여부를 판단하는 로직 추가
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		
		board = new Long[n + 1][n + 1];
		
		for(int i = 0 ; i <= n ; i ++) {
			Arrays.fill(board[i], INF);
			board[i][i] = 0L;
		}
		
		for(int i = 0 ; i < m ; i++) {
			String[] read = bf.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			Long w = Long.parseLong(read[2]);
			board[a][b] = Math.min(board[a][b], w);
		}
		
		for(int i = 1 ; i <= n ; i ++) {
			for(int j = 1 ; j <= n; j++) {
				for(int k = 1; k <= n ; k++) {
					if(i == j || j == k || i == k)continue;
					
					if(board[j][i] != INF && board[i][k] != INF) {
						board[j][k] = Math.min(board[j][k], board[j][i] + board[i][k]);
					}
				}
			}
		}
		
		
		for(int i = 1 ; i < board.length; i++) {
			for(int j = 1 ; j < board.length; j++) {
				Long b = board[i][j];
				if(b.compareTo(INF) == 0)System.out.print("0 ");
				else System.out.print(b +" ");
			}
			System.out.println("");
		}
	}
}
