import java.util.*;
public class Main {

    class Graph{
		HashMap<Integer, ArrayList<Integer>> g;
		
		Graph(){
			g = new HashMap<>();
		}
		
		 public void addEdge(int u, int v){
             ArrayList<Integer> arr;
            
              if(this.g.containsKey(u))
                  arr = g.get(u);
              else
                  arr = new ArrayList<>();

              arr.add(v);
              g.put(u,arr);
      
        }
        
         public void display(){
          for(int k : this.g.keySet()){
              ArrayList<Integer> arr = this.g.get(k);
              System.out.print(k+"-> ");
              for(int c : arr){
                  System.out.print(c+", ");
              }
              System.out.println();
          }
	}
	
         public ArrayList<Integer> solve(int key) {
        	 ArrayList<Integer> res = new ArrayList<>();
     		
        	 Queue<Integer> q = new LinkedList<>();
        	 
        	 q.add(key);
        	 
        	 while(!q.isEmpty()) {
        		 int curr = q.poll();
        		 res.add(curr);
        		 
        		 if(this.g.containsKey(curr)) {

            		 for(int c : this.g.get(curr)) {
            			 q.add(c);
            		 }
            		 
        		 }
        		 
        	 }
        	 
        	 Collections.sort(res);
        	 
        	 return res;
         }
	}

    public static void main (String args[]) {

            	Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		Graph g = new Main().new Graph();
		
		int[] id = new int[n];
		int[] parentId = new int[n];
		
		for(int i=0; i<n; i++) {
			id[i] = s.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			parentId[i] = s.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			g.addEdge(parentId[i], id[i]);
		}
		
		
		ArrayList<Integer> res = g.solve(k);
		
		for(int i : res) {
			System.out.print(i+" ");
		}
		
		
    }
}