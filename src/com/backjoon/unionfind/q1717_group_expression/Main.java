package com.backjoon.unionfind.q1717_group_expression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static int[] group; 
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] read = br.readLine().split(" ");
        int n = Integer.parseInt(read[0]);
        int m = Integer.parseInt(read[1]);
        
        group = new int[n + 1]; //root는 -1 임
        Arrays.fill(group, -1);
        for(int i = 0 ; i < m ; i++) {
        	read = br.readLine().split(" ");
        	int d = Integer.parseInt(read[0]);
        	int a = Integer.parseInt(read[1]);
        	int b = Integer.parseInt(read[2]);
        	
        	if(d == 0) {//합집합
        		grouping(a, b);
        	}else {//동일 집합확인 -> unionFind
        		if(findRoot(a) == findRoot(b))bw.write("YES\n");
        		else bw.write("NO\n"); 
        	}
        	
        }
        br.close();
        bw.flush();
        bw.close();
	}
	
	private static void grouping(int a, int b) {
		
		//각각 부모의 번호로 바꿈
		a = findRoot(a);
		b = findRoot(b);
		if(a == b)return; //이미 같은 그룹이면 볼것도 없음
		
		if(a > b){ //a를 더 큰 그룹으로 만들예정 -> 부모값이 더 작아야 함 
			a ^= b;
			b ^= a;
			a ^= b;
		}
		group[a] = group[a] + group[b];//b의 경우도 root이기 때문에 group[b]는 음수이다.. 
		// (음수의 크기는 결국 해당 집합의 크기라고 볼 수 있다)->a 속한 그룹의 size = -group[findRoot(a)];  
		group[b] = a;
	}

	private static int findRoot(int num) {
		if(group[num] < 0) return num;	
		return group[num] = findRoot(group[num]);
	}
}
