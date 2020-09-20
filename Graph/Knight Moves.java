import java.util.*;

class Pair{
	int i,j;
	
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.i+","+this.j+")";
	}
}


public class Steps_by_Knight {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		while(t--!=0) {
			int n = s.nextInt();
			int[][] board = new int[n][n];
			
			int si = s.nextInt();
			int sj = s.nextInt();
			Pair st = new Pair(si-1,sj-1);
			
			int ei = s.nextInt();
			int ej = s.nextInt();
			Pair end = new Pair(ei-1,ej-1);


			
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[0].length; j++) {
					if(i==st.i && j==st.j) {
						continue;
					} else {
						board[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			
			int[] dx = new int[] {2,1,-1,-2,-2,-1,1,2};
			int[] dy = new int[] {1,2,2,1,-1,-2,-2,-1};
		
			
			Queue<Pair> q = new LinkedList<>();
			q.add(st);
			
			while(!q.isEmpty()) {
				System.out.println(q);
				Pair curr = q.poll();
	
				if(curr.i==end.i && curr.j==end.j) 
					break;
				
				for(int i=0; i<8; i++) {
					if(isValid(curr.i+dx[i], curr.j+dy[i], board) && 
							board[curr.i+dx[i]][curr.j+dy[i]]>board[curr.i][curr.j]+1) {
						board[curr.i+dx[i]][curr.j+dy[i]] = board[curr.i][curr.j]+1;
						q.add(new Pair(curr.i+dx[i],curr.j+dy[i]));
					}
				}
				}
			
			display(board);
			
			if(board[end.i][end.j]==Integer.MAX_VALUE) {
				System.out.println("-1");
			} else {
				System.out.println(board[end.i][end.j]);
			}

		}
		
		
	}
	
	private static void display(int[][] board) {
		// TODO Auto-generated method stub
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j]+"	");
			}
			System.out.println();
		}
		
	}

	public static boolean isValid(int i, int j, int[][] board) {
		if(i<0 || j<0 || i>=board.length || j>=board[0].length)
			return false;
		else
			return true;
	}

}
