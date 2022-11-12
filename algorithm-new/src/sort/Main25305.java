package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main25305 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		String[] cond = bf.readLine().split(" ");
		int memNum = Integer.parseInt(cond[0]);
		int cutline = Integer.parseInt(cond[1]);
		
		String[] pointstr = bf.readLine().split(" ");
		
		List<Integer> points = Arrays.stream(pointstr)
				.mapToInt(str -> Integer.parseInt(str))
				.boxed()
				.sorted((o1, o2) -> o2 - o1)
				.toList();
		
		bw.write(String.valueOf(points.get(cutline - 1)));
		
		bf.close();
		bw.flush();
		bw.close();
	}

	
}
