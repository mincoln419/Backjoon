package conditional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2525 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] read =  bf.readLine().split(" ");
		
		int A = Integer.parseInt(read[0]);
		int B = Integer.parseInt(read[1]);
		
		int C = Integer.parseInt(bf.readLine());
		
		int duringH = C/60;
		int duringM = C%60;
		
		int timerH = (A + duringH + ((B + duringM) >= 60? 1 : 0)) % 24;
		int timerM = (B + duringM) % 60;
		
		bw.write(String.valueOf(timerH));
		bw.write(" ");
		bw.write(String.valueOf(timerM));
		
		bf.close();
		bw.flush();
		bw.close();
	}

}
