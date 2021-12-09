package com.backjoon.bitmasking.q2098;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = 1;
		int b = a << 10;
		int c = b >> 1;
		//c ^= b;
		//b ^= c;
		
		bw.write(b + "\n");
		bw.write(c + "\n");
		
		bw.flush();
		bf.close();
		bw.close();

	}

}
