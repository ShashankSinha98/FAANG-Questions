
// Using Graph - DFS, no of connected components

class Solution {
    
    class Graph{
    
    HashMap<Integer, ArrayList<Integer>> g;
    
    Graph(){
        this.g = new HashMap<>();
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
    
    public void initialize(int u){
        this.g.put(u,new ArrayList<>());
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
    
    
    public int numIslands(char[][] grid) {
        
        
        int r = grid.length;
        if(r==0)
            return 0;
        
        int c = grid[0].length;
        
        if(c==0)
            return 0;
        
        Graph g = new Solution().new Graph();
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                
                if(grid[i][j]=='1'){
                    g.initialize(i*c+j);
                
                    if(i-1>=0 && grid[i-1][j]=='1')
                    g.addEdge(i*c+j, (i-1)*c+j);
                
                    if(j-1>=0 && grid[i][j-1]=='1')
                        g.addEdge(i*c+j, i*c+(j-1));
                }
                    
            }
        }
        
        int ans = g.connectedComp();
        
        return ans;
        
    }
}