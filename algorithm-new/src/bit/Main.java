package bit;

import java.io.*;


public class Main {

	static int stick = 64;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		
		long bin = 0;//비트연산으로 집합연산을 위한 공집합 초기화
		
		for(int i = 0 ; i < n ; i++) {
			String[] arr = bf.readLine().split(" ");
			
			if(arr[0].equals("all")) {
				bin = (long) Math.pow(2, 21) - 1;
				continue;
			}
			
			if(arr[0].equals("empty")) {
				bin = 0;
				continue;
			}

			int s = Integer.parseInt(arr[1]);
			if(arr[0].equals("add")) {
				if((bin & (1 << s)) == 0){
					bin = bin|1 << s;
				}else continue;
			}
			
			if(arr[0].equals("remove")) {
				if((bin & (1 << s)) != 0){
					bin = bin & ~(1 << s);
				}else continue;
			}
			
			if(arr[0].equals("check")) {
				if((bin & (1 << s)) == 0){
					bw.write(0 +"\n");
				}else bw.write(1 +"\n");
			}
			
			if(arr[0].equals("toggle")) {
				if((bin & (1 << s)) == 0){
					bin = bin | 1 << s;
				}else bin = bin & ~(1 << s);
			}
			
			//System.out.println(Long.toBinaryString(bin));
		}
		bf.close();
		bw.flush();
		bw.close();
	}

}
