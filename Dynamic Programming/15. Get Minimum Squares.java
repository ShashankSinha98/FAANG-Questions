import java.util.*;
import java.lang.*;
import java.io.*;
class Get_Minimum_Squares
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner s = new Scanner(System.in);
	 int t = s.nextInt();
	 
	 while(t--!=0){
	     int n = s.nextInt();
	     int res = solve(n);
	     System.out.println(res);
	 }
	 }
	 
	 static int solve(int n){
	     int[] dp = new int[n+1];
	     dp[1] = 1;
	     
	     for(int i=2;i<=n;i++){
	         dp[i] = i;
	         for(int j=1;j*j<=i;j++){
	             dp[i] = Math.min(dp[i],dp[i-(j*j)]+1);
	         }
	     }
	    return dp[n];
	 }
}