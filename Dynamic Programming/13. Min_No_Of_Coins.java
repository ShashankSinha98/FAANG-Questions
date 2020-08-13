import java.util.*;

import java.io.*;
public class Min_No_Of_Coins {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t--!=0) {
			String[] strarr = br.readLine().split("\\s+");
			int V = Integer.parseInt(strarr[0]);
			int N = Integer.parseInt(strarr[1]);
			
			strarr = br.readLine().split("\\s+");
			int[] coins = new int[N];
			int k = 0;
			for(int i=0; i<N; i++) 
				coins[i] = Integer.valueOf(strarr[k++]);
			
			int res = min_coins(coins,N,V);
			if(res==Integer.MAX_VALUE) {
				System.out.println("-1");
			} else {
			System.out.println(res);
		}
		}

	}
	
	static int min_coins(int[] coins, int C, int V) {
		
		int[] dp = new int[V+1];
		//dp[0] = 1;
		
		for(int i=1; i<=V; i++) {
			int temp = Integer.MAX_VALUE-1;
			for(int c=0; c<C; c++) {
				if(i-coins[c]>=0) 
					temp = Math.min(temp,dp[i-coins[c]]);
			}
			dp[i] = temp+1;
		}
		//display(dp);
		return dp[V];
		
	}
	
	static void display(int[] arr) {
		for(int i=0; i<100; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
