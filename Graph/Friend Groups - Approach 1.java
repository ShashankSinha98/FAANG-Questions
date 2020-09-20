class Solution {
    
    class Graph{
        HashMap<Integer,ArrayList<Integer>> g;
        
        Graph(){
            this.g = new HashMap();
        }
        
        public void addEdge(int u, int v){
             ArrayList<Integer> arr;
            
              if(this.g.containsKey(u))
                  arr = g.get(u);
              else
                  arr = new ArrayList<>();

              arr.add(v);
              g.put(u,arr);

              if(this.g.containsKey(v))
                  arr = g.get(v);
              else
                  arr = new ArrayList<>();

              arr.add(u);
              g.put(v,arr);
      
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
        
            public void initialize(int u){
                if(!this.g.containsKey(u))
          this.g.put(u,new ArrayList<>());
      }
        
        public int connectedComp(){
        int ans = 0;
        HashMap<Integer,Boolean> visited = new HashMap<>();
        
        for(int k : this.g.keySet())
            visited.put(k, false);
        
        for(int k : this.g.keySet()){
            if(!visited.get(k)){
                ans += 1;
               dfs_helper(k,visited);
            }
        }
        return ans;
        
    }
        
        public void dfs_helper(int node, HashMap<Integer,Boolean> visited){
            visited.put(node,true);
            
            for(int c : this.g.get(node)){
                if(!visited.get(c))
                    dfs_helper(c,visited);
            }
        }
  
 
    }
    
    public int findCircleNum(int[][] M) {
     
        Graph g = new Solution().new Graph();
        
        for(int i=0; i<M.length; i++){
            for(int j=i; j<M[0].length; j++){
                
                if(i==j && M[i][j]==1)
                    g.initialize(i);
                
                if(i!=j && M[i][j]==1)
                    g.addEdge(i,j);
            }
        }
        int ans = g.connectedComp();
        return ans; 
    }
}