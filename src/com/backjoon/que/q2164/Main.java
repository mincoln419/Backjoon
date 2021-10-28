package com.backjoon.que.q2164;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1 ; i <= n ; i ++) {
			que.offer(i);
		}
		
		while(que.size() > 1) {
			
			//ī�����������
			que.poll();
			//�ι�° ī�带 ī�� ������ �ű��
			int poll = que.poll();
			que.offer(poll);
		}
		
		bw.write(que.poll() + "\n");
		bw.flush();
		bf.close();
		bw.close();

	}

}
