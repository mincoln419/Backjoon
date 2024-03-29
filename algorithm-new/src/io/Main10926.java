package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main10926 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String read = bf.readLine();
	
		int year = Integer.parseInt(read);
		
		//2541 = 1998 + a
		int a = 2541 - 1998;
				
		bw.write(String.valueOf(year - a));
		
		bf.close();
		bw.flush();
		bw.close();
	}

}
