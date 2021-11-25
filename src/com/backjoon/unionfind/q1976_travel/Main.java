package com.backjoon.unionfind.q1976_travel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static int[] root;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        root = new int[n + 1];
        Arrays.fill(root, -1);
        
        for(int i = 1 ; i <= n ; i++) {
        	String[] read = br.readLine().split(" ");
        	for(int j = i + 1 ; j <= n ; j++) {
        		if(Integer.parseInt(read[j - 1]) == 1) {//연결되어있을 경우에만
        			connect(i , j);
        		}
        	}
        }

        String[] read = br.readLine().split(" ");
        int bf = Integer.parseInt(read[0]);
        boolean flag = true;
        for(int i = 1 ; i < m ; i++) {
        	int a = Integer.parseInt(read[i]);
        	if(getRoot(bf) != getRoot(a)) {
        		flag = false;
        		break;
        	}
        	bf = a;
        }
        
        if(flag)bw.write("YES\n");
        else bw.write("NO\n");
        
        br.close();
        bw.flush();
        bw.close();
        
	}

	private static void connect(int a, int b) {
		a = getRoot(a);
		b = getRoot(b);
		
		if(a == b)return;
		
		if(a > b) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		root[a] = root[a] + root[b];
		root[b] = a;
	}

	private static int getRoot(int a) {
		if(root[a] < 0) return a;
		
		return root[a] = getRoot(root[a]);
	}
}
