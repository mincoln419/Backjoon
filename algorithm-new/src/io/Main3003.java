package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main3003 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] read = bf.readLine().split(" ");

		//ŷ 1��, �� 1��, �� 2��, ��� 2��, ����Ʈ 2��, �� 8��
		List<Integer> chessPieces = Arrays.asList(1, 1, 2, 2, 2, 8);
		
		List<Integer> nowPieces = Arrays.stream(read)
			.mapToInt(str -> Integer.parseInt(str))
			.boxed()
			.collect(Collectors.toList());
		
		IntStream.range(0, chessPieces.size())
			.forEach(i -> {
				int need = chessPieces.get(i) - nowPieces.get(i);
				try {
					bw.write(String.valueOf(need));
					bw.write(" ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
		bf.close();
		bw.flush();
		bw.close();
	}

}
