package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		
		int[] arr = IntStream.range(0, 5).map(i -> {
			try {
				int n = Integer.parseInt(bf.readLine());
				return n;
			}catch(Exception e){
				e.printStackTrace();
			}
			return 0;
		}).toArray();
		
		int avg = (int) Arrays.stream(arr).average().getAsDouble();		
		bw.write(String.valueOf(avg));
		bw.write("\n");
		Arrays.sort(arr);
		int middle = arr[2];
		bw.write(String.valueOf(middle));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
