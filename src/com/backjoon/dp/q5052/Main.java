package com.backjoon.dp.q5052;

import java.io.*;

class TrieNode{
	
	TrieNode[] children;

	boolean isEnd;
	
	public TrieNode() {
		isEnd = false;
		children = new TrieNode[10];//0 ~ 9
		for(int i = 0 ; i < 10; i++) {
			children[i] = null;
		}
	}
	public void wordEnd() {
		isEnd = true;
	}
}


public class Main {

	static TrieNode root;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		
		int n = Integer.parseInt(bf.readLine());
	
		for(int i = 0 ; i < n ;i++) {
			int m = Integer.parseInt(bf.readLine());
			root = new TrieNode();
			String[] str = new String[m];
			for(int j = 0 ; j < m ; j++) {
				str[i] = bf.readLine();
				
				insert(str[i]);
			}
			
			boolean chk = true;
			for(int j = 0 ; j < m; j++) {
				if(!search(str[i])) {
 					chk = false;
					System.out.println("NO");
					break;
				}
			}	
			if(chk)System.out.println("YES");
		}
	}
	
	static void insert(String key) {
		int level;
		int length = key.length();
		int idx;
		
		TrieNode pCrawl = root;
		
		for(level = 0; level < length ; level++) {
			idx = key.charAt(level) - '0';
			if(pCrawl.children[idx] == null) {
				pCrawl.children[idx] = new TrieNode();
			}
			
			pCrawl = pCrawl.children[idx];
		}		
		
		pCrawl.wordEnd();
	}
	
	static boolean search(String key) {
		int level;
		int length = key.length();
		int idx;
		TrieNode pCrawl = root;

		for(level = 0 ; level < length; level++) {
			idx = key.charAt(level) - '0';
			
			if(pCrawl == null || pCrawl.isEnd) return false;
			pCrawl = pCrawl.children[idx];
		}
		
		return (pCrawl != null && pCrawl.isEnd);
	}
}
