package conditional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2480 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] read =  bf.readLine().split(" ");
		
		int[][] dice = new int[7][2];
		for(int i = 0 ; i < dice.length; i++) {
			dice[i][0] = i;
		}
		Arrays.stream(read)
			.mapToInt(str -> Integer.parseInt(str))
			.forEach(i -> {
				dice[i][1] += 1;
			});
		
		List<int[]> list =  Arrays.stream(dice)
				.filter(arr -> arr[1] > 0)
				.collect(Collectors.toList());
		Collections.sort(list, (o1, o2) -> {
			if(o1[1] > o2[1]) {
				return -1;
			}else if(o1[1] == o2[1]) {
				return o2[0] - o1[0];
			}
			return 1;
		});
		int money = 0;
		switch(list.size()) {
			case 1: money = (list.get(0)[0] * 1000) + 10000;
				break;
			case 2: money = (list.get(0)[0] * 100) + 1000;
			break;
			default: money = (list.get(0)[0] * 100);
			break;

		}
		bw.write(String.valueOf(money));
		
		bf.close();
		bw.flush();
		bw.close();
	}

}
