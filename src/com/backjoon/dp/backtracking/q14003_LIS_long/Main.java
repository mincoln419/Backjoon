package com.backjoon.dp.backtracking.q14003_LIS_long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int max = 1000001;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] arr = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		long[] dp = new long[max]; //  해당 LIS size(= dp의 index)까지의 수중 가장 큰값
		int[] index = new int[max]; // arr의 index에 해당하는 수까지 LIS값
		
		
		dp[0] = arr[0];
		index[0] = 0;//size가 0인 LIS는 존재하지 않으므로
		
		int size = 1;//LIS 배열 수 - LIS의 최소값은 1이므로
		
		for(int i = 1 ; i < n ; i++) {
			
			if(dp[size - 1] < arr[i]) {//LIS가 계속되므로 dp값 세팅 
				index[i] = size;
				dp[size] = arr[i];
				size++;
				continue;
			}else if(dp[size - 1] == arr[i]) {
				index[i] = size - 1;
				continue;
			}
			
			//LIS가 끊겼음.. 그래서 해당 index에서 기존 LIS값 중에서 이어질 수 있는 값을 찾음 - 이분탐색-low_bound
			int left = 0;
			int right = size - 1;
			int ret = 0;
			
			while(left <= right) {
				int mid = (left + right)/2;
				
				if(dp[mid] < arr[i]) {
					left = mid + 1;
				}else {
					ret = mid;
					right = mid - 1;
				}
			}
			
			dp[ret] = arr[i];
			index[i] = ret;
		}
		
		Stack<Long> stk = new Stack<>();
		size--;
		for(int i = n - 1; i >= 0 ; i--) {
			if(size == -1)break;
			
			if(index[i] == size) {
				stk.push(arr[i]);
				size--;
			}
		}
		
		System.out.println(stk.size());
		while(!stk.isEmpty()) {
			System.out.print(stk.pop() +" ");
		}
	}

}
