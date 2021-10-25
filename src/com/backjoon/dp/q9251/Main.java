package com.backjoon.dp.q9251;

import java.io.*;
import java.util.*;

public class Main {

	static Integer[][] dp;
	static char[] arr1;
	static char[] arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		arr1 = bf.readLine().toCharArray();
		arr2 = bf.readLine().toCharArray();
		
		dp = new Integer[arr1.length][arr2.length];
		
		
			
		System.out.println(LCS(arr1.length - 1, arr2.length -1));
	}
	
	static int LCS(int x, int y) {
		
		if(x < 0 || y < 0) return 0;
		
		//������ ��ȭ�� �¿�
		if(dp[x][y] == null) {
			
			dp[x][y] = 0;
			
			if(arr1[x] == arr2[y]) {//���� ��쿡�� -1, -1
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			}else {//�ٸ���쿡�� x��Ʈ�� y��Ʈ�� ���ư��� ��� �������� �б�
				dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
			}
		}
		
		//���� ������ ����
		return dp[x][y];
	}

}
