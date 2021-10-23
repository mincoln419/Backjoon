package com.backjoon.answer;

import java.util.*;

public class Beach {

	public static void main(String[] args) {
	
        Scanner sc = new Scanner(System.in);
        Date bgn = new Date();
        String[] NM = sc.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] wb = new String[M];

        for(int i = 0 ; i < N ; i++){
        	wb[i] = sc.nextLine();
        }
        Beach beach = new Beach();
        int answer = beach.solution(N, M, wb);
        
        System.out.println(answer);
        sc.close();
        Date end = new Date();
        
        System.out.print("Runtime::" + (end.getTime() - bgn.getTime()));
	}	

	public int solution(int N, int M, String[] wb) {
		// TODO Auto-generated method stub
		
		
		
		return 0;
	}
}
