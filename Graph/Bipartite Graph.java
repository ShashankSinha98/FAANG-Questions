class Solution {
    
    class Graph{
        HashMap<Integer,ArrayList<Integer>> g;
        
        Graph(){
            this.g = new HashMap<>();
        }
        
        public void initialize(int u){
      this.g.put(u,new ArrayList<>());
  }
  
        
         public void addEdge(int u, int v){
            ArrayList<Integer> arr;
            if(this.g.containsKey(u))
                arr = this.g.get(u);
            else
                arr = new ArrayList<>();
            
            arr.add(v);
            this.g.put(u,arr);
            
            
        }
        
         public void display(){
            for(int k : this.g.keySet()){
                System.out.print(k+" -> ");
                for(int w : this.g.get(k)){
                    System.out.print(w+" -> ");
                }
                System.out.println();
            }
        }
    
        public Boolean checkBipartite(){
            int n = this.g.size();
            
            int[] col = new int[n];

            for(int i=0; i<n; i++)
                col[i] = -1;
            
            for(int i=0; i<n; i++){
                if(col[i]==-1){
                    boolean isBip = isBipartite(i,col);
                    if(!isBip)
                        return false;
                }
            }
            return true;

        }
        
        public Boolean isBipartite(int n,int[] col){
            
            
            Queue<Integer> q = new LinkedList<>();
            q.add(n);
            col[n] = 1;
            
            while (!q.isEmpty()){
                int curr = q.poll();
                
                for(int c : this.g.get(curr)){
                    if(col[c]==-1){
                        col[c] = (col[curr]+1)%2;
                        q.add(c);
                    } else if(col[c]==col[curr])
                        return false;
                }
            }
            return true;
        }
        
    
    }
    
    public boolean isBipartite(int[][] graph) {
     
        Graph g = new Solution().new Graph();
        
        if(graph.length==0)
            return true;
        
        for(int i=0; i<graph.length; i++){
           g.initialize(i);
            for(int c : graph[i]){
                g.addEdge(i,c);
            }
        }
        
        
        return g.checkBipartite();
    }
}