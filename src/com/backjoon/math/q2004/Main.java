package com.backjoon.math.q2004;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] read = bf.readLine().split(" ");
		long n = Long.parseLong(read[0]);
		long k = Long.parseLong(read[1]);
		
		
		// nC2 = n!/(k! * (n-k))! 이므로  n까지의 5배수 숫자에서 k까지의 5배수숫자 + n-k까지의 5배수 를 빼면 됨 
		long nC2 = 0;
		long penta = 5;
		while(penta <= n) {
			nC2 += n/penta;
			penta *= 5;
		}
		
		long bin = 2;
		long nC2bin = 0;
		while(bin <= n) {
			nC2bin += n/bin;
			bin *= 2;
		}
		
		
		long kfac = 0;
		penta = 5;
		while(penta <= k) {
			kfac += k/penta;
			penta *= 5;
		}
		
		bin = 2;
		long kfacbin = 0;
		while(bin <= k) {
			kfacbin += k/bin;
			bin *= 2;
		}
		
		
		long nkfac = 0;
		penta = 5;
		while(penta <= n-k) {
			nkfac += (n-k)/penta;
			penta *= 5;
		}
		
		bin = 2;
		long nkfacbin = 0;
		while(bin <= (n-k)) {
			nkfacbin += (n-k)/bin;
			bin *= 2;
		}
		
		System.out.println(Math.min(nC2 - kfac - nkfac, nC2bin -  kfacbin - nkfacbin));
		
		bf.close();
	}

}
