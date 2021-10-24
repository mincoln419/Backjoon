package com.backjoon.math;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

	public static void main(String[] args) {

		Test t = new Test();
		int[][] cityMap = 	{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int n = 3;
		int m = 3;
		System.out.println(t.solution(m, n, cityMap));

	}

    int MOD = 20170805;
    static int[][] memo;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 ,  0, -1};
    static int m;
    static int n;
    static int[][] visited;
    
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        memo = new int[n][m];
        this.n = n;
        this.m = m;
        visited = new int[n][m];
        
        dfs(0, 0, -1, 1, cityMap);
        
        answer = memo[n-1][m-1];
        
        Date date = new Date();
        date.getTime();
        
       
        return answer;
    }
    
    void dfs(int x, int y, int bf, int route, int[][] cityMap){
        
        memo[y][x] = (route + 1) % MOD;
        
        for(int i = 0 ; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX < 0 || nextX >= m)continue;
            if(nextY < 0 || nextY >= n)continue;
            if(visited[nextY][nextX] == 1) continue;
            if(cityMap[nextY][nextX] == 1) continue;//이동 지역이 보행자보호구역인경우
            if(cityMap[y][x] == 2){//이전구간이 우회전 금지구역인경우
                if(bf == 0 && i == 1)continue;
                if(bf == 1 && i == 2)continue;
                if(bf == 2 && i == 3)continue;
                if(bf == 3 && i == 0)continue;
            }
            visited[nextY][nextX] = 1;
            dfs(nextX, nextY, i, memo[y][x], cityMap);
            visited[nextY][nextX] = 0;
        }
        
        
    }
}
