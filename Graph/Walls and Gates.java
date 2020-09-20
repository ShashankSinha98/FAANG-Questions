import java.util.*;

class Pair1{
	int i, j;
	
	Pair1(int i,int j){
		this.i = i;
		this.j = j;
	}
}

public class Walls_and_Gates {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		int[][] graph = new int[n][m];
		Queue<Pair1> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				graph[i][j] = s.nextInt();
				if(graph[i][j]==0)
					q.add(new Pair1(i,j));
			}
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		while(!q.isEmpty()) {
			Pair1 curr = q.poll();
			int i = curr.i;
			int j = curr.j;
			
			for(int k=0; k<4; k++) {
				if(isValid(i+dx[k], j+dy[k], graph) && graph[i][j]+1<graph[i+dx[k]][j+dy[k]]) {
					graph[i+dx[k]][j+dy[k]] = graph[i][j]+1;
					q.add(new Pair1(i+dx[k], j+dy[k]));
				}
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	
	}
	
	public static Boolean isValid(int i, int j, int[][] graph) {
		if(i<0||j<0||i>=graph.length||j>=graph.length||graph[i][j]==-1)
			return false;
		else
			return true;
	}

}
