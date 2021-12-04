package com.backjoon.kmp.q1786_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String p = br.readLine();
		
		List<Integer> list = kmp(s, p);
		bw.write(list.size() + "\n");
		for(int i = 0 ; i < list.size() ; i++) {
			bw.write((list.get(i) + 1) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static List<Integer> kmp(String s, String p) {

		List<Integer> result = new ArrayList<>();
		
		int[] pi = getPi(p);
		
		int n = s.length();
		int m = p.length();
		int j = 0;
		
		for(int i = 0 ; i < n ; i++) {
			while(j > 0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if(s.charAt(i) == p.charAt(j)) {
				if(j == m - 1) {
					result.add(i - m + 1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		return result;
	}

	private static int[] getPi(String p) {

		int m = p.length();
		int j = 0;
		
		int[] pi = new int[m];
		
		for(int i = 1; i < m; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			
			if( p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

}
