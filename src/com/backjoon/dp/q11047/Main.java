package com.backjoon.dp.q11047;

import java.io.*;
import java.util.*;


import java.io.*;
import java.util.*;

class TrieNode{
	
	TrieNode[] children;

	boolean isEnd;
	TrieNode fail;
	
	public TrieNode() {
		isEnd = false;
		children = new TrieNode[26];//a ~ z
		for(int i = 0 ; i < 26; i++) {
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
	
		//��ųʸ��� �������
		root = new TrieNode();
		for(int i = 0 ; i < n ; i++) {
			insert(bf.readLine());
		}
		
		//������ ���ư� failure ����
		buildFailure();
		
		int m = Integer.parseInt(bf.readLine());
		
		//����Ž��
		for(int i = 0 ; i < m ; i++) {
			if(search(bf.readLine()))System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	
	
	static void insert(String key) {
		
		int length = key.length();
		int idx;
		
		TrieNode pCrawl = root;
		
		for(int level = 0; level < length ; level++) {
			idx = key.charAt(level) - 'a';
			//System.out.println("idx::" + idx);
			if(pCrawl.children[idx] == null) {
				pCrawl.children[idx] = new TrieNode();
			}
			
			pCrawl = pCrawl.children[idx];
		}		
		
		pCrawl.wordEnd();
	}
	
	static void buildFailure() {
		//fail �Լ� �����
		Queue<TrieNode> que = new LinkedList<>();
		que.offer(root);//root���� bfs
		
		while(!que.isEmpty()) {
			TrieNode pCrawl = que.poll();
			
			for(int i = 0 ; i < 26; i++) {
				TrieNode next = pCrawl.children[i];
				if(next == null)continue;
				
				//���� ���簪�� root�� ��� - fail�� root
				if(pCrawl == root)next.fail = root;
				//�ٸ� ��� -> fail�� ���� �θ� trieNode�� ã�´�
				else {
					TrieNode pre = pCrawl.fail;
					while(pre != root && pre.children[i] == null) {
						pre = pre.fail;
					}
					
					if(pre.children[i] != null)pre = pre.children[i];
					
					next.fail = pre;
				}
				
				if(next.fail.isEnd)next.isEnd = true;
				
				que.offer(next);
			}
		}
	}
	
	//Ž��
	static boolean search(String key) {
		int length = key.length();
		int idx;
		TrieNode pCrawl = root;
		
		boolean result = false;

		for(int level = 0 ; level < length; level++) {
			idx = key.charAt(level) - 'a';
			
			while(pCrawl != root && pCrawl.children[idx] == null) {
				pCrawl = pCrawl.fail;
			}
			
			if(pCrawl.children[idx] != null)pCrawl = pCrawl.children[idx];
			
			if(pCrawl.isEnd) {
				result = true;
				break;
			}
		}
		
		return result;
	}
}

