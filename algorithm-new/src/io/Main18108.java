package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main18108 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String read = bf.readLine();
		
		String add = "??!";

		StringBuffer sb = new StringBuffer();
		sb.append(read);
		sb.append(add);
		
		bw.write(sb.toString());
		
		bf.close();
		bw.flush();
		bw.close();
	}

}
