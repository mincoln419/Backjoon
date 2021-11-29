package com.backjoon.unionfind.q20040_cycle_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int[] root;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] read = br.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int m = Integer.parseInt(read[1]);
		
		root = new int[n + 1];
		for(int i = 0 ; i <=n ; i++) {
			root[i] = i;
		}
		
		boolean flag = true;		
		for(int i = 0 ; i < m ; i ++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			if(!connect(a , b)) {
				bw.write((i + 1) + "\n");
				flag = false;
				break;
			}
		}
		
		if(flag)bw.write(0 + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
	private static boolean connect(int a, int b) {
		a = getRoot(a);
		b = getRoot(b);
		if(a == b)return false;
		if(a > b) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		root[b] = a;
		return true;
	}
	private static int getRoot(int a) {
		if(root[a] == a) return a;
		return root[a] = getRoot(root[a]);
	}


}
