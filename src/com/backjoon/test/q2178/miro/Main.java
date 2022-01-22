package com.backjoon.test.q2178.miro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Location{
	
	public int x;
	public int y;
	public int turn;
	
	public Location(int x, int y, int turn) {
		this.x = x;
		this.y = y;
		this.turn = turn;
	}
}

//백준문제 2178 - 미로 탐색
public class Main {
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = bf.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		char[][] board = new char[n + 1][m + 1];//문제에서 1,1 부터 출발하기 때문에 padding값 1 추가
		
		for(int i = 0 ; i < n ; i++) {
			String row = bf.readLine();
			for(int j = 0 ; j < m; j++) {
				board[i + 1][j + 1] = row.charAt(j);				
			}
		}
		
		Queue<Location> que = new LinkedList<>();
		boolean[][] visited = new boolean[n + 1][m + 1];
		
		que.offer(new Location(1, 1, 1));
		visited[1][1] = true;		
		
		int[] dy = {1, -1, 0 , 0};
		int[] dx = {0, 0, 1, -1};
		
		boolean finished = false;
		while(!que.isEmpty()) {
			Location nextLoc = que.poll();
			
			for(int i = 0 ; i < dx.length; i++) {
				int nextY = nextLoc.y + dy[i];
				int nextX = nextLoc.x + dx[i];
				if( nextY > n || nextY < 1)continue;
				if( nextX > m || nextX < 1)continue;
				if(board[nextY][nextX] == '0')continue;
				if(visited[nextY][nextX])continue;
				
				visited[nextY][nextX] = true;
				
				que.offer(new Location(nextX, nextY, nextLoc.turn + 1));
								
				if(nextY == n && nextX == m) {
					finished = true;
					System.out.println(nextLoc.turn + 1);
					break;
				}	
			}
			if(finished)break;
		}
	}
}
