import java.io.*;
import java.util.*;
public class Max_Rectangle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		
		while(t--!=0) {
			String str = br.readLine();
			String[] str_arr = str.split("\\s+");
			int n = Integer.valueOf(str_arr[0]);
			int m = Integer.valueOf(str_arr[1]);
			
			int[][] mat = new int[n][m];
			str = br.readLine();
			str_arr = str.split("\\s+");
			
			int k=0;
			for(int i=0; i<n;i++) {
				for(int j=0; j<m;j++) {
					mat[i][j] = Integer.valueOf(str_arr[k++]);
				}
			}
			
			System.out.println(max_rectagle(mat, n, m));
		}
		
		
	}
	
	static int max_rectagle(int[][] mat, int n, int m) {
		
		int[] arr = new int[m];
		int max_area = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (mat[i][j]!=0) 
					arr[j]+=mat[i][j];
				else
					arr[j] = 0;
			}
			max_area = Integer.max(max_area, max_area_under_hist(arr,m));
		}
		
		return max_area;
	}
	
	static int max_area_under_hist(int[] arr, int n) {
		
		int max_area = Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<>();
		int i=0;
		
		while(i<n) {
			
			if(st.isEmpty() || arr[st.peek()]<=arr[i])
				st.add(i++);
			else {
				int top = st.pop();
				
				int area = 0;
				if(st.isEmpty()) 
					area = arr[top] * i;
				else
					area = arr[top] * (i-st.peek()-1);
				
				max_area = Integer.max(max_area,area);
			}
		}
		
		while(!st.isEmpty()) {
			int top = st.pop();
			
			int area = 0;
			if(st.isEmpty()) 
				area = arr[top] * i;
			else
				area = arr[top] * (i-st.peek()-1);
			
			max_area = Integer.max(max_area,area);
		}
		
		return max_area;
		
	}

}
